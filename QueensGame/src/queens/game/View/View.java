package queens.game.View;

import java.util.ArrayList;

public class View {

    public static void displayQueen(ArrayList<int[]> solutions){
        System.out.println("Total Solutions: " + solutions.size());
        int count = 1;
        for(int i = 0; i < solutions.size(); i++){
            System.out.println();
            displayBoard(solutions, i, count);
            count++;
            System.out.println();
        }
    }

    // Create a way to display the board...
    private static void displayBoard(ArrayList<int[]> solutions,int index, int count) {
        int n = solutions.get(index).length - 1;
        System.out.println("Solution " + count + ": found in " + solutions.get(index)[n]);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (solutions.get(index)[c] == r + 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }

    }
}
