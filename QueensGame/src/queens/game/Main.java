package queens.game;

import queens.game.Controller.Algo;

public class Main {

    public static void main(String[] args) {
	    // The checking system doesn't scale right....
        // For now use 4 and create the helper functions....
        Algo.nQueens(6);
    }
}
