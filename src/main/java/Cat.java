public class Cat extends Animal implements Runnable {
    public Cat() {
        this.setAge(0);
        this.setHealth(MAX_HEALTH);
        this.setSatiation(MAX_SATIATION);
        this.setAlive(true);
        this.previousTime = System.currentTimeMillis();
    }
}
