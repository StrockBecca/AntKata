package AntKata.ant;

import AntKata.Random.RNG;

import java.awt.Point;
import java.util.List;


public class Ant {
    private Point position;
    private Status status;
    private Point lastKnownFoodPosition;
    private Point colony;

    public Ant(Point positionColony) {
        this.position = positionColony;
        this.colony = positionColony;
        this.status = Status.WANDERING;
    }

    public void scatter() {
        int randomX = RNG.random(-1, 1);
        int randomY = RNG.random(-1, 1);

        //this.status = this.getStatus();

        switch(this.getStatus()) {
            case WANDERING:
                this.position = new Point(this.getPositionX() + randomX, this.getPositionY() + randomY);
                break;

            case RETURNING_COLONY:
                this.path(this.colony);
                break;

            case FETCHING_FOOD:
                this.path(this.lastKnownFoodPosition);
                break;

            default:
                break;
        }
    }

    public void foodLocation(Point location){
        this.lastKnownFoodPosition = location;
        this.status = Status.RETURNING_COLONY;
    }

    private void path(Point destination) {
        if (destination != null ){
            if (destination.getX() > this.getPositionX()){
                this.position = new Point(this.getPositionX() + 1, this.getPositionY() );
            } else if (destination.getX() < this.getPositionX()) {
                this.position = new Point(this.getPositionX() - 1, this.getPositionY() );
            } else if (destination.getX() == this.getPositionX()) {
                if (destination.getY() > this.getPositionY()){
                    this.position = new Point(this.getPositionX(), this.getPositionY() + 1);
                } else if (destination.getY() < this.getPositionY()){
                    this.position = new Point(this.getPositionX(), this.getPositionY() - 1);
               } else if (destination.getY() == this.getPositionY()){
// if food exist =>statut = return to colonny else scatter
                }
            }
        }
    }

    //check if the food location has expired or not
    public boolean atFoodLocation(List<Point> food) {
        if(this.lastKnownFoodPosition != null) {
            if(food.contains(this.lastKnownFoodPosition)) {
                this.status = Status.RETURNING_COLONY;
                return true;
            }
        }
        return false;
    }

    public void lookForFood(List<Point> food) {
        for (Point location : food) {
            if (location.equals(this.position)) {
                this.foodLocation(location);
            }
        }
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

    public Point getLastKnownFoodPosition() {

        return lastKnownFoodPosition;
    }

    public void setPosition(Point point) {

        this.position = new Point(point.x, point.y);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setLastKnownFoodPosition(Point lastKnownFoodPosition) {
        this.lastKnownFoodPosition = lastKnownFoodPosition;
    }
}
