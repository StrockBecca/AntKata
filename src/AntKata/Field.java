package AntKata;

import AntKata.ant.Ant;
import AntKata.ant.Colony;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.stream.Collectors;

public class Field extends JPanel {
    private BufferedImage image;
    private Colony c;
    private List<Food> food;
    private int widthX;
    private int heightX;
    private JLabel foodLabel;

    public Field(int width, int height) {
        this.widthX = width;
        this.heightX = height;

        initColonyAndFood();

        initOnClickListenerFood();

        initUI();
    }

    private void initOnClickListenerFood() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    image.setRGB(e.getX(), e.getY(), Color.green.getRGB());
                    // TODO
                    repaint();
                } catch (Exception exception) {
                    System.out.println("Invalid click");
                }
            }
        });
    }

    private void initUI() {
        // init gridbaglayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Init image for printing ants
        this.image = new BufferedImage(this.widthX, this.heightX, BufferedImage.TYPE_INT_ARGB);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(image));
        add(label, gbc);

        // Init button
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            //TODO
        });

        // Init food collected labels
        JPanel j = new JPanel();
        JLabel t = new JLabel("Food collected : ");
        foodLabel = new JLabel("0");

        // Add label and button to panel
        j.add(resetButton);
        j.add(t);
        j.add(foodLabel);

        // Add panel to gridBagLayout
        add(j, gbc);

        // First paint
        repaint();
    }

    private void initColonyAndFood() {
        // TODO
        this.c = new Colony(0, new Point(this.widthX / 2, this.heightX / 2));
        this.food = new ArrayList<>();
    }

    public void nextTurn() {

        // TODO add lifecycle

        foodLabel.setText("TODO");

        this.image = new BufferedImage(widthX, heightX, BufferedImage.TYPE_INT_ARGB);

        for (Ant a : c.getAnts())
            this.image.setRGB(a.getPositionX(), a.getPositionY(), Color.blue.getRGB());

        for (Point p : food.stream().map(Food::getPosition).collect(Collectors.toList()))
            this.image.setRGB(p.x, p.y, Color.green.getRGB());

        this.image.setRGB(c.getPositionX(), c.getPositionY(), Color.red.getRGB());

        repaint();

        // On itère sur une autre liste pour pouvoir retirer un élement sans risquer d'erreurs
        for (Food f : new ArrayList<>(food)) {
            f.nextTurn();
            if (!f.isAlive())
                food.remove(f);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

}
