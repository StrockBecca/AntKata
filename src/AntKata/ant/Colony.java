package AntKata.ant;

import AntKata.ant.Ant;
import AntKata.ant.CellType;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Colony {
    private List<Ant> ants;
    private Point position;
    private int foodCollected;

    public Colony(int nbAnts, Point position) {

        this.ants = new ArrayList<>();
        this.position = position; //colony position
        this.foodCollected = 0;

        for(int i = 0 ; i < nbAnts ; i++){
            ants.add(new Ant(position));
        }
    }

    public int next(List<Point> food) {

        //communication between ants when they are at the same location
        for (int i = 0 ; i < ants.size() - 1; i++) {
            for (int j = i + 1 ; j < ants.size() ; j++) {

                if (ants.get(i).getPosition().equals(ants.get(j).getPosition())) {
                    // if ant i is on her way back to the colonny or to fetch food, then she is the one knowing were the food is
                    if(ants.get(i).getStatus() == Status.FETCHING_FOOD || ants.get(i).getStatus() == Status.RETURNING_COLONY) {
                        ants.get(j).setLastKnownFoodPosition(ants.get(i).getLastKnownFoodPosition());
                        ants.get(j).setStatus(Status.FETCHING_FOOD);

                        // else it is ant j who knows where the food is
                    } else if (ants.get(j).getStatus() == Status.FETCHING_FOOD || ants.get(j).getStatus() == Status.RETURNING_COLONY) {
                        ants.get(i).setLastKnownFoodPosition(ants.get(j).getLastKnownFoodPosition());
                        ants.get(i).setStatus(Status.FETCHING_FOOD);
                    }
                }
            }

            switch(ants.get(i).getStatus()) {
                case RETURNING_COLONY :
                    if(ants.get(i).getPosition().equals(this.position)) {
                        this.foodCollected++;
                    }
                    break;

                case FETCHING_FOOD:
                    if(ants.get(i).getPosition().equals(this.ants.get(i).getLastKnownFoodPosition())) {
                        if (!ants.get(i).atFoodLocation(food)) {
                            ants.get(i).setStatus(Status.WANDERING);
                        } else {
                            ants.get(i).setStatus(Status.RETURNING_COLONY);
                        }
                    }
                    break;

                case WANDERING:
                    ants.get(i).lookForFood(food);
                    break;

                default:
                    break;
            }
            //ants.get(i).scatter();
        }

        for (Ant ant : ants) {
/*
            switch(ant.getStatus()) {
                case RETURNING_COLONY :
                    if(ant.getPosition().equals(this.position)) {
                        this.foodCollected++;
                    }
                    break;
                default:
                    break;
            }
*/
            ant.scatter();
        }

        return foodCollected;
    }

    public List<Ant> getAnts() {
        return ants;
    }

    public int getPositionX() {
        return position.x; }

    public int getPositionY() {
        return position.y;
    }

}
