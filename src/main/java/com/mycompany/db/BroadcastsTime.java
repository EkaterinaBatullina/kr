/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.db;

/**
 *
 * @author ekaterina
 */
public class BroadcastsTime  {
    String hour = "";
    String minute = "";
   
    public BroadcastsTime(String time) {
        
        boolean flag = false;
        for (int i = 0; i < time.length(); ++i) {
            if (time.charAt(i) == ' ') {
                break;
            }
            if (time.charAt(i) == ':') {
                flag = true;
                continue;
            }
            if (flag == false) {
                    hour += time.charAt(i);
            }
            else {
                minute += time.charAt(i);
            }
        }  
    }
    
    byte hour() {
        return new Byte(hour);
    }
    
    byte minutes() {
        return new Byte(minute);
    }
    
    boolean after(BroadcastsTime t) {
        
        boolean flag = false;
        if (before(t) == false) {
            if (hour() != t.hour() &&  minutes() != t.minutes()) {
                flag = true;
            }
        } 
        return flag;
    }
    
    boolean before(BroadcastsTime t) {
        
        boolean result = true;
        if (t.hour() < hour()){
                result = false;
        }
        if (t.hour() == hour()){
            if (t.minutes() <= minutes()) {
                result = false;
            }
        }
        return result;
        
    }
    
    boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        
        boolean flag = false;
        if (after(t1) && before(t2)) {
            flag = true;
        }
        return flag;
        
    }

   
    public int compareTo(BroadcastsTime t) {
        
        int result = 0;
        if (after(t)){
            result = 1;
        }
        if (before(t)) {
            result = -1;
        }
        return result;
    }
    
}
