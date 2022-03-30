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

     */

import example.lib.Console;
import example.lib.IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Controller {
    private String fileString;
    private FileInputStream input = null;
    private FileOutputStream output = null;

    public void run(){
        fileExists();

    }


    private void fileExists(){
        boolean quit = false;
        while(!quit){
            try{
                fileString = Console.getString("Enter in File Path: ");
                input = new FileInputStream(fileString);
                IOStream.writeToConsole(input);
                quit = true;
            }catch(Exception e){
                System.out.println("That file doesn't exist");
            }
        }
    }
}
