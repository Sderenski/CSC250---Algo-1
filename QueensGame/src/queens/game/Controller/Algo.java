package queens.game.Controller;

import java.util.Arrays;
import java.util.HashMap;

import static queens.game.View.View.*;

public class Algo {
    // Needs to print out all the different solutions along with recording them
    // Thinking about holding the solutions in a hashmap that converts the pattern to a string
    // then save the array to the key

    // For finding the solutions, I am thinking that there is one main function to be
    // called then two versions of the same one for moving....
    private static HashMap<String, int[]> solutions = new HashMap<>();
    private static int steps = 0;

    public static void nQueens(int n){
        // Passes the array to the rest of the functions down... Create an array list of ints?
        // if the number is -1 go back to the previous position.
        int[] gameBrd = new int[n + 1];
        move(gameBrd, n);
        System.out.println("Final: ");
        displayQueen(solutions);
    }


    // TODO Rebuild/construct the move functions...
    // there is an issue with placing the queens.....


    // Init Move
    private static void move(int[] queens, int n){
        // Get init for position in array
        // Create pVal for the position to loop through. Each iteration will have its own scope of it.
        int p = 0;
        int pVal = 1;
        while (pVal <= n){
            queens[p] = pVal;
            moveR(queens, n, p + 1);
            pVal++;
        }
    }

    // Recursive Move
    private static void moveR(int[] queens, int n, int p){
        // Find a way to recurse back up. Chances are through a while loop....
        int pVal = 1;
        boolean broke = false;
                while(pVal <= n){
            // This save Conditional is breaking....
            // Why........
            if (checkFunctions(queens, p, pVal)){
                if (queens[p] == pVal){
                    pVal++;
                } else{
                    queens[p] = pVal;
                    if(p == n - 1 && queens[queens.length-2] != 0) {
                        solutions.put(convertString(queens), Arrays.copyOf(queens, queens.length));
                        broke = true;
                        break;
                    } else {
                        moveR(queens, n, p + 1);
                    }
                }
            } else {
                pVal++;
            }
        }
        if(pVal > n || broke == true) {
            queens[p] = 0;
        }
    }



    //-----------------------------------------------------------------------------
    // Helper Functions


    // Should be checking the array for numbers.
    // Create basic tests for the checks to make sure they work the way they are intended.
    private static boolean checkArr(int[] array, int r, int p){
        for (int i = 0; i < p; i++) {
            if (array[i] == r) {
                return false;
            }
        }
        return true;
    }

    // Does check the diagonal far enough....
    // This might be it?? I don't fully know how to check the scaling...
    // Create it to make loop to jump back every position
    private static boolean diArray(int[] array, int r, int p){
        for(int i = 0; i < p; i++){
            if ((r - array[i]) == (p - i)) {
                return false;
            }
            if ((r - array[i]) == -(p - i)) {
                return false;
            }
        }
        return true;
    }

    // Uses both functions to check the values
    // Works the way it needs to....
    // I need to bring this logic to the nQueens game...
    private static boolean checkFunctions(int[] arr, int p, int pVal){
        while (p < arr.length){
            // If true
            if(checkArr(arr, pVal, p)){
                if (p > 0){
                    if(diArray(arr, pVal, p)){
                        return true;
                    }
                    else{
                        return false;
                    }
                } else{
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    // Converts to string from array
    private static String convertString(int[] arr){
        String finalStr = "";
        for(int i = 0; i < arr.length - 1; i++){
            finalStr += String.valueOf(arr[i]);
        }
        return finalStr;
    }


    // Count the steps....
    private static void countSteps(){

    }
}
