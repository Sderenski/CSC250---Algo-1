package edu.neumont.View;

import java.util.ArrayList;
import java.util.HashMap;

public class Display {
    // To display the outputs, I need to iterate through the hashmap
    // show the keys first and then the values
    public String display(HashMap<String, ArrayList<String>> isoValue, boolean type){
        String outStr = "";
        if (type) {
            System.out.println("Exact Isomorphs");
            outStr+="Exact Isomorphs\n";
        }
        else {
            System.out.println("\nLoose Isomorphs");
            outStr+="\nLoose Isomorphs\n";
        }
        for (var key : isoValue.keySet()){
            System.out.print(key.trim() + ": ");
            outStr+=key.trim()+ ": ";
            for (var valueISO : isoValue.get(key)){
                System.out.print(valueISO + " ");
                outStr+=valueISO + " ";
            }
            System.out.println();
            outStr+="\n";
        }
        return outStr;
    }

    public String displayNon(ArrayList<String> isoValue){
        System.out.println("\nNon-Isomorphs");
        String outStr = "\nNon-Isomorphs\n";
        for(var val : isoValue) {
            System.out.print(val + " ");
            outStr+= val + " ";
        }
        return outStr;
    }
}
