public abstract class Animal {

    private final double MAX_AGE = 10;
    public final double MAX_HEALTH = 10;
    public final double MAX_SATIATION = 10;

    private double speedK = 50000d / 3600000d;
    public double age;
    private double health;
    private double satiation;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    private boolean isAlive;
    long previousTime;


    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = Math.min(health, MAX_HEALTH);
    }

    public double getSatiation() {
        return satiation;
    }

    public void setSatiation(double satiation) {
        this.satiation = Math.min(satiation, MAX_SATIATION);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void feed() {
        setSatiation(satiation + 1);
    }

    public void run() {
        previousTime = System.currentTimeMillis();
        while (isAlive) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            calculateTime();
        }
    }
    public void calculateTime() {
        long currentTime = System.currentTimeMillis();
        long delta = currentTime - previousTime;
        age = age + (delta * speedK) / 24 / 365;
        satiation = satiation - (delta / 3600d * speedK);
        if (satiation <= 0) {
            satiation = 0;
            health = health - (delta / 3600d * speedK);
        }
        if (age > MAX_AGE || health <= 0) {
            isAlive = false;
        }
    }
}
