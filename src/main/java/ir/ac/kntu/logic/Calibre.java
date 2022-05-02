package ir.ac.kntu.logic;

public enum Calibre {
    FIVE(15, 0), TEN(-10, 10);

    private final int accuracy;
    private final int power;

    Calibre(int accuracy, int power) {
        this.accuracy = accuracy;
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPower() {
        return power;
    }
}