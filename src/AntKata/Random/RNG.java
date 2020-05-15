package AntKata.Random;

public class RNG {
    private static RNGImpl impl = new RNGImpl();

    private RNG() {}

    public static void setImpl(RNGImpl impl) {
        RNG.impl = impl;
    }

    public static int random(int min, int max) {
        return impl.random(min, max);
    }
}
