package edu.neumont.View;

import java.util.ArrayList;
import java.util.HashMap;

public class Display {
    // To display the outputs, I need to iterate through the hashmap
    // show the keys first and then the values
    public void display(HashMap<String, ArrayList<String>> isoValue, boolean type){
        if (type) System.out.println("Exact Isomorphs");
        else System.out.println("\nLoose Isomorphs");
        for (var key : isoValue.keySet()){
            System.out.print(key + ": ");
            for (var valueISO : isoValue.get(key)){
                System.out.print(valueISO + " ");
            }
            System.out.println();
        }
    }
}
