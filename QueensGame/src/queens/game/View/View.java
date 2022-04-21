package queens.game.View;

import java.util.HashMap;

public class View {

    public static void displayQueen(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void displayQueen(HashMap<String, int[]> solutions){
        for(String key : solutions.keySet()){
            System.out.println(key);
            displayBoard(solutions, key);
        }
    }

    // Create a way to display the board..
    private static void displayBoard(HashMap<String, int[]> solutions, String key) {
        int n = solutions.get(key).length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (solutions.get(key)[c] == r + 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
