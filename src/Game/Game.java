package Game;

import Display.Display;

/**
 * Created by ilnurgazizov on 18.09.15.
 */
public class Game {
    private boolean             running;

    public Game() {
        running = false;
        Display display = new Display(this);

    }
}
