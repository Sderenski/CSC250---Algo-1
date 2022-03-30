package edu.neumont.View;

import java.util.ArrayList;
import java.util.HashMap;

public class Display {
    // To display the outputs, I need to iterate through the hashmap
    // show the keys first and then the values
    public void displayExact(HashMap<String, ArrayList<String>> exactISO){
        for (var key : exactISO.keySet()){
            System.out.print(key + ": ");
            for (var valueISO : exactISO.get(key)){
                System.out.print(valueISO + " ");
            }
            System.out.println();
        }
    }
}
