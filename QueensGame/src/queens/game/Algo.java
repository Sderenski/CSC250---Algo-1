package queens.game;

public class Algo {
    // Needs to print out all the different solutions along with recording them
    // Thinking about holding the solutions in a hashmap that converts the pattern to a string
    // then save the array to the key

    // For finding the solutions, I am thinking that there is one main function to be
    // called then two versions of the same one for moving....

    public static void nQueens(int n){
        // Passes the array to the rest of the functions down... Create an array list of ints?
        // if the number is -1 go back to the previous position.
        int[] gameBrd = new int[n];
        move(gameBrd, n);
        System.out.println("Final: ");
        displayQueen(gameBrd);
    }

    // Init Move
    private static void move(int[] queens, int n){
        // position 1
        // position variable
        // The position has a
        int p = 0;
        int pValue = 1;
        while(pValue < n){
            if(queens[p + 1] == -1){
                pValue++;
                if(pValue < n){
                    queens[p] = pValue;
                } else{
                    System.out.println("Out of Moves.");
                }
            } else {
                queens[p] = pValue;
            } // Maybe the Placement of this is messing it up.......
            moveR(queens, n, p + 1);
        }
    }

    // Recursive Move
    private static void moveR(int[] queens, int n, int p){
        // Always check to verify that the array list isn't more than n length....
        if (p != n){
            for (int r = 1; r < n + 1; r++){
                // Why is it not breaking back up????
                // should i try the more naive way of doing this???
                if(checkArr(queens, r, p) && diArray(queens, r, p)){
                    queens[p] = r;
                    displayQueen(queens);
                    System.out.println(p);
                    moveR(queens, n, p + 1);
                }
                // TODO Figure out why it is placing -1 for everything
            }
        }
    }

    private static boolean checkArr(int[] array, int r, int p){
        for (int i = 0; i < p; i++) {
            if (array[i] == r) return false;
        }
        return true;
    }

    private static boolean diArray(int[] array, int r, int p){
        if (array[p - 1] == r + 1 || array[p - 1] == r -1) return false;
        return true;
    }

    private static void displayQueen(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
