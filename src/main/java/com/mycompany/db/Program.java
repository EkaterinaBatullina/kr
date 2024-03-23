/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.db;

/**
 *
 * @author ekaterina
 */
public class Program {
    String chanel;
    BroadcastsTime time;
    String name;
    
    public Program(String chanel, BroadcastsTime time, String name) {
        this.chanel = chanel;
        this.name = name;
        this.time = time;
    }
    
    public String toString() {
        return chanel + " " + time.hour + ":" + time.minute + " " + name;
    }
    
}
