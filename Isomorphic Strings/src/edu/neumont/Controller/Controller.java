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

        I am confused what makes an Isometric value a non Iso string?


        File Path for Input - TEST:
        C:\Users\sderenski\Downloads\IsomorphInput1.txt
     */

import edu.neumont.View.Display;
import example.lib.Console;
import example.lib.IOStream;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.*;

public class Controller {
    private Display view = new Display();
    private String fileString;
    private BufferedReader input = null;
    private FileOutputStream output = null;
    private ArrayList<String> fileWords = new ArrayList<>();
    private HashMap<String, ArrayList<String>> exactISO = new HashMap<>();
    private HashMap<String, ArrayList<String>> looseISO = new HashMap<>();

    // Main Run function
    public void run(){
        fileExists();
        for (var word : fileWords){
            exactHashAdding(word.toCharArray(), word);
            // iterate through the chars in the word
            // checking if the char is new or repeated
        }
        view.displayExact(exactISO);

    }

    // Checking to see if the value exists or not
    private void fileExists(){
        boolean quit = false;
        while(!quit){
            try{
                fileString = Console.getString("Enter in File Path: ");
                input = new BufferedReader(new FileReader("C:\\Users\\sderenski\\Downloads\\IsomorphInput1.txt"));
                String line = input.readLine();
                while(line != null){
                    fileWords.add(line);
                    line = input.readLine();
                }
                input.close();
                quit = true;
            }catch(Exception e){
                System.out.println("That file doesn't exist");
            }
        }
    }

    // function to check if the letters have been used before or not
    // Find a way to iterate through the hashmap and if it isn't there
    // add it and create a new value for it
    private void exactHashAdding(char[] wordChar, String word){
        int offSet = 0;
        ArrayList<Character> letters = new ArrayList<>();
        ArrayList<Integer> isoValueInt = new ArrayList<>();
        for (int i = 0; i < wordChar.length; i++) {
            int count = compareLetter(letters, wordChar, i);
            if (count >= 0){
                isoValueInt.add(count);
                offSet++;
            }else {
                letters.add(wordChar[i]);
                isoValueInt.add(i - offSet);
            }
        }
        String key = stringBuilder(isoValueInt);
        if (!checkKeys(key)) exactISO.put(key, new ArrayList<>());
        exactISO.get(key).add(word);
//        view.displayExact(exactISO);
        //exactISOAssign(charMap, word);
    }


    // Tries to find if the letter has been found or not in the list, if so then return the key number
    private int compareLetter(ArrayList<Character> letters, char[] wordChar, int count){
        int keyValue = 0;
        for (char letter : letters){
            if (letter == wordChar[count]){
                return keyValue;
            }
            keyValue++;
        }
        return -1;
    }

    private boolean checkKeys(String key){
        for (String i : exactISO.keySet()){
            if (i.equals(key)){
                return true;
            }
        }
        return false;
    }

    // Appending the key together to build a string
    private String stringBuilder(ArrayList<Integer> strings){
        String fin = "";
        for (var str : strings){
            fin += str;
        }
        return fin;
    }
}
