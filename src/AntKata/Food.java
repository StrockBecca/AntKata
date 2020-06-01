package AntKata;

import java.awt.*;

public class Food {
    private Point position;
    private int lifespan;

    public Point getPosition() {

        return position;
    }

    public Food(int x, int y) {
        this.position = new Point(x, y);
        this.lifespan = 0;
    }

    public boolean isAlive() {
        if(this.lifespan < 1000) {
            return true;

        } else {
            return false;
        }
    }

    public void nextTurn() {

        this.lifespan += 1;
    }


}
