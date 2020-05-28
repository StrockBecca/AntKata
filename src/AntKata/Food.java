package AntKata;

import java.awt.*;

public class Food {
    private Point position;
    private int cycle;
    // TODO Attributs à rajouter pour gérer le cycle de vie

    public Point getPosition() {
        return position;
    }

    public Food(int x, int y) {
        this.position = new Point(x, y);
        this.cycle = 0;
        // TODO
    }

    public boolean isAlive() {
        // TODO
        if(this.cycle < 10000) {
            return true;

        } else {
            return false;
        }
    }

    public void nextTurn() {
        this.cycle += 1;
    }
}
