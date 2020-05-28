package AntKata.ant;

import AntKata.Random.RNG;

import java.awt.Point;
import java.util.List;


public class Ant {
    private Point position;
    private Status status;
    private Point lastKnownFoodPosition;

    public Ant(Point positionColony) {
        this.position = positionColony;
    }

    private void scatter() {
        int randomX = RNG.random(-1, 1);
        int randomY = RNG.random(-1, 1);

        this.status = this.getStatus();

        switch(this.status) {
            case WANDERING:
                this.position = new Point(this.getPositionX() + randomX, this.getPositionY() + randomY);
                break;

            case RETURNING_COLONY:
                this.position = new Point(this.getPositionX() - randomX, this.getPositionY() - randomY);
                break;
            case FETCHING_FOOD:
                break;
            default:
                break;
        }
    }

    private void foodLocation(Point location){
        this.lastKnownFoodPosition = location;
    }

    public int getPositionX() {

        return this.position.x;
    }

    public int getPositionY() {

        return this.position.y;
    }

    public Point getPosition() {

        return this.position;
    }

    public Status getStatus() {

        return this.status;
    }

    public void setPosition(Point point) {

        this.position = new Point(point.x, point.y);
    }

    public Point getLastKnownFoodPosition() {

        return lastKnownFoodPosition;
    }
}
