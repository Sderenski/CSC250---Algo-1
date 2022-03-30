package edu.neumont.Controller;

/*
        TODO
        1.) Ask the user for the file
        2.) find the file from the file path provided
        3.) Read through each line of the file
        4.) Each line check the Iso values of the words
        5.) To check the ISO values by looping through the letters and assign each of the chars
            a number but also keep a list of key value pairs for the letters, use a hashmap....
        6.) Then add the ISO words to different array lists depending on their values
        7.) Output the values to console and text file.


        File Path for Input:
        C:\Users\sderenski\Downloads\IsomorphInput1.txt
     */

import example.lib.Console;
import example.lib.IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Controller {
    private String fileString;
    private FileInputStream input = null;
    private FileOutputStream output = null;
    private ArrayList<String> fileWords = new ArrayList<String>();
    private HashMap<Integer, String> exactISO = new HashMap<Integer, String>();

    public void run(){
        fileExists();
        for (var word : fileWords){
            hashAdding(word.toCharArray());
            // iterate through the chars in the word
            // checking if the char is new or repeated
        }


    }


    private void fileExists(){
        boolean quit = false;
        while(!quit){
            try{
                fileString = Console.getString("Enter in File Path: ");
                input = new FileInputStream(fileString);
                fileWords.add(IOStream.readToString(input));
                quit = true;
            }catch(Exception e){
                System.out.println("That file doesn't exist");
            }
        }
    }

    // function to check if the letters have been used before or not
    // Find a way to iterate through the hashmap and if it isn't there
    // add it and create a new value for it
    private void hashAdding(char[] wordChar){
        int counter = 0;
        ArrayList<Character> letters = new ArrayList<Character>();
        HashMap<Integer, Character> charMap = new HashMap<Integer, Character>();
        for (int i = 0; i < wordChar.length; i++) {
            if (compareLetter(letters, wordChar, i)){
                letters.add(wordChar[i]);
                charMap.put(counter, wordChar[i]);
            } else{
                assigningHash(wordChar, i, charMap);
            }
        }
    }

    public boolean compareLetter(ArrayList<Character> letters, char[] wordChar, int count){
        for (char letter : letters){
            if (letter != wordChar[count]){
                return true;
            }
        }
        return false;
    }

    public void assigningHash(char[] wordChar, int count, HashMap<Integer, Character> charMap){
        Iterator charIter = charMap.entrySet().iterator();
        while (charIter.hasNext()){
            Map.Entry charElem = (Map.Entry)charIter.next();
            if ((char)charElem.getValue() == wordChar[count]){
                charMap.put((int)charElem.getKey(), (char)charElem.getValue());
                break;
            }
        }
    }
}
