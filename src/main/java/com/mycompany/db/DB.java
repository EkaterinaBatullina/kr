/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.db;

/**
 *
 * @author ekaterina
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class DB {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        List<String> list1 = Files.readAllLines(new File("/Users/ekaterina/Desktop/schedule.txt").toPath(), Charset.defaultCharset());
        Iterator<String> iterator = list1.iterator();
        Map<String, List<Program>> map = new HashMap<>();
        String chanel = null;
        String current = null;
        BroadcastsTime time = null;
        String name = null;
        
        List<Program> allPrograms = new ArrayList<>();
        List<Program> chanelsProgram = new ArrayList<>();
        
        while (iterator.hasNext()) {
 
            current = iterator.next();
            if (current.charAt(0) == '#') {
                
                if (chanel != null) {
                    map.put(chanel, chanelsProgram);
                    chanelsProgram = new ArrayList<>();
                }
                chanel = current;
                
            }
            else if (current.charAt(0) == '0' || current.charAt(0) == '1' || current.charAt(0) == '2') {
                time = new BroadcastsTime(current);
                name = null;
            }
            else {
                name = current;
            }
            
            if (name != null) {
                
                Program program = new Program(chanel, time, name);
                chanelsProgram.add(program);
                allPrograms.add(program); 
            }
        }
        
        Collections.sort(allPrograms,
                (program1, program2) -> program1.time.compareTo(program2.time)
        );
        
        String givenName; // вводим параметры через сканнер
        BroadcastsTime givenTime;
        String givenChanel;
        BroadcastsTime givenTime1;
        BroadcastsTime givenTime2;
        Iterator<Program> iterator1 = allPrograms.iterator();
        
        while (iterator1.hasNext()) { // поиск по названию
            Program current1 = iterator1.next();
            if (current1.name.equals(givenName)) {
                System.out.print(current.toString() + " ");
            }
        }
        
//        while (iterator1.hasNext()) { // по времени
//           Program current1 = iterator1.next();
//           if (current1.time.equals(givenTime)) {
//                System.out.print(current.toString() + " ");
//            }
//        }

//        while (iterator1.hasNext()) { // по названию канала и времени
//            Program current1 = iterator1.next();
//            if (current1.chanel.equals(givenChanel)) {
//                if (current1.time.equals(givenTime)) {
//                    System.out.print(current.toString() + " ");
//                }
//            }
//        }

//        while (iterator1.hasNext()) { // по названию канала и промежутку времени
//            Program current1 = iterator1.next();
//            if (current1.chanel.equals(givenChanel)) {
//                if (current1.time.between(givenTime1, givenTime2)) {
//                    System.out.print(current.toString() + " ");
//                }
//            }
//        }

        
  }
}
