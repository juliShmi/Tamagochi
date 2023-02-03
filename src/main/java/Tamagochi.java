import javax.swing.*;
import java.awt.*;

public class Tamagochi {
    private JFrame animalFrame;
    private JTextArea statusArea;
    private JButton feedButton;
    private Animal animal;

    public static void main(String[] args) throws InterruptedException {
        Tamagochi tamagochi = new Tamagochi();
        tamagochi.init();
        while(tamagochi.animal == null) {
            Thread.sleep(100);
        }
        tamagochi.play();
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void play() {
        animalFrame.setVisible(false);
        animalFrame.dispose();
        initFrame();
        //Thread catThread = new Thread(cat);
        //catThread.start();
        while (animal.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            animal.calculateTime();
            showStatus();
        }
        statusArea.setText("Your animal is dead!");
//        //catThread.stop();
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
        statusArea.setText("Name: " + animal.getName() + "\n Age: " + animal.getAge() + "\n Health: " + animal.getHealth()
                + "\n Satiation: " + animal.getSatiation());
    }

    private void chooseAnimal(String animalFromButton) {
        switch (animalFromButton) {
            case ("Cat"):
                setAnimal(new Cat());
                break;
            case ("Dog"):
                setAnimal(new Dog());
                break;
        }
    }

    private void setStartScreen() {
        animalFrame = new JFrame("Start Screen");
        animalFrame.setVisible(true);
        animalFrame.setSize(250, 250);
        animalFrame.setLocation(300, 200);
        JPanel catPanel = new JPanel();
        JButton catButton = new JButton("Choose a Cat");
        catPanel.setSize(100, 100);
        catPanel.setBackground(Color.green);
        catPanel.add(catButton);
        animalFrame.getContentPane().add(BorderLayout.WEST, catPanel);

        JPanel dogPanel = new JPanel();
        dogPanel.setSize(100, 100);
        dogPanel.setBackground(Color.blue);
        JButton dogButton = new JButton("Choose a Dog");
        dogPanel.add(dogButton);
        animalFrame.getContentPane().add(BorderLayout.EAST, dogPanel);
        catButton.addActionListener(e -> chooseAnimal("Cat"));
        dogButton.addActionListener(e -> chooseAnimal("Dog"));
    }

    private void init() {
        setStartScreen();
    }
}
