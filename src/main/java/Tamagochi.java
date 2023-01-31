import javax.swing.*;
import java.awt.*;

public class Tamagochi {
    private JFrame animalFrame;
    private JTextArea statusArea;
    private JButton feedButton;
    private Animal animal;

    public static void main(String[] args) {
        Tamagochi tamagochi = new Tamagochi();
        tamagochi.play();
    }

    public void play() {
        initFrame();
        animal = new Cat();
        //Thread catThread = new Thread(cat);
        //catThread.start();
        while(animal.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            animal.calculateTime();
            showStatus();
        }
        statusArea.setText("Your animal is dead!");
        //catThread.stop();
    }

    private void initFrame() {
        animalFrame = new JFrame("Animal Frame");
        animalFrame.setSize(250, 250);
        animalFrame.setLocation(300, 200);
        statusArea = new JTextArea(10, 40);
        animalFrame.getContentPane().add(BorderLayout.CENTER, statusArea);
        feedButton = new JButton("Feed me");
        animalFrame.getContentPane().add(BorderLayout.SOUTH, feedButton);
        feedButton.addActionListener(e -> animal.feed());
        animalFrame.setVisible(true);
    }

    private void showStatus() {
        statusArea.setText("Age: " + animal.getAge() + "\n Health: " + animal.getHealth()
                + "\n Satiation: " + animal.getSatiation());
    }
}
