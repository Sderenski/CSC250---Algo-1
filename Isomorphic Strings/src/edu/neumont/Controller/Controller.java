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

        The non isometric strings are there because they are don't have a group that they are apart of. meaning they are they the only ones of that group.

        File Path for Input - TEST:
        C:\Users\sderenski\Downloads\IsomorphInput1.txt
     */

import edu.neumont.Static.Console;
import edu.neumont.Static.IOStream;
import edu.neumont.View.Display;

import java.io.*;
import java.util.*;

public class Controller {
    private Display view = new Display();
    private String fileString;
    private String outTxt;
    private File filePath;
    private BufferedReader input = null;
    private FileOutputStream output = null;
    private ArrayList<String> fileWords = new ArrayList<>();
    private ArrayList<String> nonISO;
    private HashMap<String, ArrayList<String>> exactISO = new HashMap<>();
    private HashMap<String, ArrayList<String>> looseISO = new HashMap<>();

    // Main Run function
    public void run(){
        fileExists();
        for (var word : fileWords){
            exactHashAdding(word.toCharArray(), word);
            looseHashAdding(word.toCharArray(), word);
        }
        filterNon(exactISO);
        filterNon(looseISO);
        sortingHashMaps();
        outTxt = view.display(exactISO, true);
        outTxt+=view.display(looseISO, false);
        outTxt+=view.displayNon(nonISO);
        outFile();


    }

    // function to check if the letters have been used before or not
    // Find a way to iterate through the hashmap and if it isn't there
    // add it and create a new value for it
    private void exactHashAdding(char[] wordChar, String word){
        int offSet = 0;
        ArrayList<Character> letters = new ArrayList<>();
        ArrayList<Integer> isoValueInt = new ArrayList<>();
        // Loops through the byte array
        for (int i = 0; i < wordChar.length; i++) {
            // Gets te count
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
        if (!checkKeys(key, exactISO)) exactISO.put(key, new ArrayList<>());
        exactISO.get(key).add(word);
    }


    private void looseHashAdding(char[] wordChar, String word){
        // Creating loose Isomorphs
        // Read through the bytes and iterate through them
        // Add them to an array and check if there are any matching
        // if so increase the number
        ArrayList<Integer> isoValueInt = new ArrayList<>();
        HashMap<Character, Integer> charValues = new HashMap<>();
        // Loops through the byte array
        for (int i = 0; i < wordChar.length; i++) {
            // For the loose value, we need to do a double nested for loop to iterate through the letters of the string
            // if there is a double or triple, add up that number. Maybe use a hashmap to increase the numbers according to the letters?
            if(charValues.containsKey(wordChar[i])){
                 charValues.put(wordChar[i], charValues.get(wordChar[i]) + 1);
            }else{
                charValues.put(wordChar[i], 1);
            }
        }

        String keyString = countingLetter(isoValueInt, charValues);

        if (!checkKeys(keyString, looseISO)) looseISO.put(keyString, new ArrayList<>());
        looseISO.get(keyString).add(word);
    }

    // Possible function to be used in creating a hashmap for the values....
    private String countingLetter(ArrayList<Integer> isoVal, HashMap<Character, Integer> charVal){
        String str= "";
        for(char key : charVal.keySet()){
            isoVal.add(charVal.get(key));
        }
        Collections.sort(isoVal);
        for(var number : isoVal){
            str += number + " ";
        }
        return str;
    }

    private void sortingHashMaps(){
        for (var key : looseISO.keySet()){
            Collections.sort(looseISO.get(key));
        }
        for (var key : exactISO.keySet()){
            Collections.sort(exactISO.get(key));
        }
        Collections.sort(nonISO);
    }

    // TODO after fixing the loose Isometric Function
    // Filter out the non-isometric strings from the rest.
    // Could filtering happen through the exact Iso finding? Like a check case of which groups are alone.

    // Filter through the array lists after they are created in another function.
    // This would work for both the hashmaps
    private void filterNon(HashMap<String, ArrayList<String>> isoVals){
        ArrayList<String> keysRemove = new ArrayList<>();
        ArrayList<String> valuesAdded = new ArrayList<>();
        for(var key : isoVals.keySet()){
            if(isoVals.get(key).size() <= 1){
                keysRemove.add(key);
                valuesAdded.add(isoVals.get(key).get(0));
            }
        }
        LinkedHashSet<String> rmDup = new LinkedHashSet<>(valuesAdded);
        nonISO = new ArrayList<>(rmDup);
        for (var keyRM : keysRemove){
            isoVals.remove(keyRM);
        }
    }





    // ******* Helper Functions **********************

    // Checking to see if the value exists or not
    private void fileExists(){
        boolean quit = false;
        while(!quit){
            try{
                fileString = Console.getString("Enter in File Path: ");
                filePath = new File(fileString);
                input = new BufferedReader(new FileReader(fileString));
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

    // Outputting the arraylists and hashmaps to a file...
    private void outFile(){
        String outPath = filePath.getParent() + "\\output.txt";
        // convert the outputs into strings in the display functions....
        try{
            FileOutputStream outputStream = new FileOutputStream(outPath);
            IOStream.writeToStream(outTxt, outputStream);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

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

    private boolean checkKeys(String key, HashMap check){
        for (var i : check.keySet()){
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
            fin += str + " ";
        }
        return fin;
    }
}
