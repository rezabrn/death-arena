package ir.ac.kntu.logic;

public enum Calibre {
    FIVE(5 ,15, 0),TEN(10, -10, 5);

    private final int name;
    private final int accuracy;
    private final int power;

    Calibre(int name, int accuracy, int power) {
        this.name = name;
        this.accuracy = accuracy;
        this.power = power;
    }

    public int getName() {
        return name;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPower() {
        return power;
    }
}