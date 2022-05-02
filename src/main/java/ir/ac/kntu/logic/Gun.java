package ir.ac.kntu.logic;

public class Gun {
    private final Calibre calibre;
    private final String name;
    private int accuracy;
    private int power;

    public Gun(Calibre calibre, String name, int accuracy, int power) {
        this.calibre = calibre;
        this.name = name;
        this.accuracy = accuracy + calibre.getAccuracy();
        this.power = power + calibre.getPower();
    }

    public Calibre getCalibre() {
        return calibre;
    }

    public String getName() {
        return name;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPower() {
        return power;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setPower(int power) {
        this.power = power;
    }

}