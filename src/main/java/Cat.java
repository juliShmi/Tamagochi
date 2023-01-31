public class Cat implements Runnable {
    private final double MAX_AGE = 10;
    private final double MAX_HEALTH = 10;
    private final double MAX_SATIATION = 10;
    private double speedK = 50000d/3600000d;

    private double age;
    private double health;
    private double satiation;
    private boolean isAlive;
    long previousTime;

    public Cat() {
        this.age = 0;
        this.health = MAX_HEALTH;
        this.satiation = MAX_SATIATION;
        this.isAlive = true;
        this.previousTime = System.currentTimeMillis();
    }

    public boolean isAlive() {return this.isAlive;};

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

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

    public void feed() {
        setSatiation(satiation +1);
    }

    @Override
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
