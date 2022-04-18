package edu.neumont.Static;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

public class Console {
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    public static final String RESET = "\u001B[0m";

    static Scanner scanner = new Scanner(System.in);

    // Static functions
    public static String getString(String prompt) {
        System.out.print(prompt);
        // returns a string
        return scanner.nextLine();
    }

    // function to get an integer for age. It will forever try to get a proper integer for the int.
    // if not it shoots out an exception without breaking the code. Won't finish until the right format is entered.
    static int getInteger(String prompt) {
        int i = 0;

        boolean valid = false;
        while (!valid) {
            try {
                i = Integer.parseInt(getString(prompt));
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer.");
            }
        }
        return i;
    }

    // Selection getInteger Method
    public static int getInteger(String prompt, int min, int max) {
        int i = 0;

        boolean valid = false;
        while (!valid) {
            try {
                i = Integer.parseInt(getString(prompt));
                valid = (i >= min && i <= max); // Checking to make sure the selection doesn't go out of bounds for the enum.
                if (!valid) {
                    Console.setColor(RED_BACKGROUND);
                    System.out.println("Value is not between " + min + " and " + max + ".");
                    Console.setColor(RESET);
                }
            } catch (NumberFormatException ex) {
                Console.setColor(RED_BACKGROUND);
                System.out.println("Invalid integer.");
                Console.setColor(RESET);
            }
        }
        return i;
    }

    static int getInteger(String prompt, int min) {
        int i = 0;

        boolean valid = false;
        while (!valid) {
            try {
                i = Integer.parseInt(getString(prompt));
                valid = (i >= min); // Checking to make sure the selection doesn't go out of bounds for the enum.
                if (!valid) {
                    System.out.println("Value is not 1 or above " + min + ".");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer.");
            }
        }
        return i;
    }


    static float getFloat(String prompt) {
        float result = 0;

        boolean valid = false;
        while (!valid) {
            try {
                result = Float.parseFloat(getString(prompt));
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid float.");
            }
        }
        return result;
    }

    static int getRanBdIn(int low, int high) {
        Random ran = new Random();
        return ran.nextInt(low, high + 1);
    }

    static int getRanBdEx(int low, int high) {
        Random ran = new Random();
        return ran.nextInt(low, high);
    }

    public static String getDateString(String prompt, SimpleDateFormat dateFormat){
        String string = null;
        boolean valid = false;
        while(!valid){
            string = getString(prompt);
            try {
                dateFormat.parse(string);
                valid = true;
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return string;
    }

    public static void setColor(String color) {
        System.out.print(color);
    }

    public static void print(String string, String color){
        Console.setColor(color);
        System.out.print(string);
        Console.setColor(RESET);
    }
    public static void println(String string, String color){
        Console.setColor(color);
        System.out.println(string);
        Console.setColor(RESET);
    }

}
