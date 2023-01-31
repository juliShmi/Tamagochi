import javax.swing.*;
import java.awt.*;

public class Tamagochi {
    private JFrame catFrame;
    private JTextArea statusArea;
    private JButton feedButton;
    private Cat cat;

    public static void main(String[] args) {
        Tamagochi tamagochi = new Tamagochi();
        tamagochi.play();
    }

    public void play() {
        initFrame();
        cat = new Cat();
        //Thread catThread = new Thread(cat);
        //catThread.start();
        while(cat.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cat.calculateTime();
            showStatus();
        }
        statusArea.setText("Cat is dead!");
        //catThread.stop();
    }

    private void initFrame() {
        catFrame = new JFrame("Cat Frame");
        catFrame.setSize(250, 250);
        catFrame.setLocation(300, 200);
        statusArea = new JTextArea(10, 40);
        catFrame.getContentPane().add(BorderLayout.CENTER, statusArea);
        feedButton = new JButton("Feed me");
        catFrame.getContentPane().add(BorderLayout.SOUTH, feedButton);
        feedButton.addActionListener(e -> cat.feed());
        catFrame.setVisible(true);
    }

    private void showStatus() {
        statusArea.setText("Age: " + cat.getAge() + "\n Health: " + cat.getHealth() + "\n Satiation: " + cat.getSatiation());
    }
}
