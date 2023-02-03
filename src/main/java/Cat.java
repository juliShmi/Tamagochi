public class Cat extends Animal {
    public Cat() {
        this.setAge(0);
        this.setHealth(MAX_HEALTH);
        this.setSatiation(MAX_SATIATION);
        this.setAlive(true);
        this.previousTime = System.currentTimeMillis();
        this.setName("Kiki");
        this.setPicture("https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg");
    }
}
