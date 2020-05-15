package AntKata.Random;

import java.util.concurrent.ThreadLocalRandom;

public class RNGImpl {

    public int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
