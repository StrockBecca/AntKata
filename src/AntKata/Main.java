package AntKata;

import AntKata.Random.RNG;
import AntKata.Random.RNGImpl;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    public static void main(String[] args) throws InterruptedException {

        RNG.setImpl(new RNGImpl());

        JFrame frame = new JFrame();
        frame.setTitle("Ant Kata");

        frame.setSize(WIDTH, HEIGHT);

        Field f = new Field(WIDTH, HEIGHT);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(f);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (true) {
            f.nextTurn();
            Thread.sleep(50);
        }
    }

}
