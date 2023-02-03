public class Dog extends Animal implements Runnable {
    public Dog() {
        this.setAge(0);
        this.setHealth(MAX_HEALTH);
        this.setSatiation(MAX_SATIATION);
        this.setAlive(true);
        this.previousTime = System.currentTimeMillis();
        this.setName("Sparky");
        this.setPicture("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.womansday.com%2Flife%2Fg32979681%2Fcute-cat-photos%2F&psig=AOvVaw1CBFkr84E8DQTGrfEpDGhf&ust=1675334506927000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCKiWgMOR9PwCFQAAAAAdAAAAABAE");
    }
}
