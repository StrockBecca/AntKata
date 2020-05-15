package AntKata.ant;

import AntKata.Random.RNG;
import AntKata.Random.RNGMock;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AntTest {

    @BeforeClass
    public static void mockRNG() {
        RNG.setImpl(new RNGMock());
    }

    @Test
    public void antFindFoodAndCollect() {
        // Given
        Colony c = new Colony(1, new Point(5, 5));

        List<Point> food = new ArrayList<>(List.of(new Point(6, 6)));

        // Init, ant moving to 6, 6
        c.next(food);

        // Check
        Assert.assertEquals(1, c.getAnts().size());
        Assert.assertEquals(Status.WANDERING, c.getAnts().get(0).getStatus());
        Assert.assertEquals(new Point(6, 6), c.getAnts().get(0).getPosition());

        // Ant found food, going back to the colony
        c.next(food);

        // Check
        Assert.assertEquals(Status.RETURNING_COLONY, c.getAnts().get(0).getStatus());
        Assert.assertEquals(new Point(5, 5), c.getAnts().get(0).getPosition());
        Assert.assertEquals(food.get(0), c.getAnts().get(0).getLastKnownFoodPosition());

        // Ant brought back food going for some more
        c.next(food);

        // Check
        Assert.assertEquals(Status.FETCHING_FOOD, c.getAnts().get(0).getStatus());
        Assert.assertEquals(new Point(6, 6), c.getAnts().get(0).getPosition());

        // Ant found food, going back to the colony
        c.next(food);

        // Check
        Assert.assertEquals(Status.RETURNING_COLONY, c.getAnts().get(0).getStatus());
    }

    @Test
    public void antTalkOtherAntFetch() {
        // Given
        Colony c = new Colony(2, new Point(5, 5));

        List<Point> food = new ArrayList<>(List.of(new Point(8, 8)));

        // check list size
        Assert.assertEquals(2, c.getAnts().size());

        c.getAnts().get(0).setPosition(new Point(8, 8));
        c.getAnts().get(1).setPosition(new Point(6, 6));

        // Init, ants moving to 7, 7
        c.next(food);

        // Check
        Assert.assertEquals(2, c.getAnts().size());
        Assert.assertEquals(Status.RETURNING_COLONY, c.getAnts().get(0).getStatus());
        Assert.assertEquals(Status.WANDERING, c.getAnts().get(1).getStatus());

        // ants on same position, talk
        c.next(food);

        // Check
        Assert.assertEquals(Status.RETURNING_COLONY, c.getAnts().get(0).getStatus());
        Assert.assertEquals(Status.FETCHING_FOOD, c.getAnts().get(1).getStatus());
        Assert.assertEquals(food.get(0), c.getAnts().get(1).getLastKnownFoodPosition());
    }
}
