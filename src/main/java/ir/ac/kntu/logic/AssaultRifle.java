package ir.ac.kntu.logic;

public class AssaultRifle extends Gun {
    AssaultRifle(Calibre calibre) {
        super(calibre, "AR", 50, 10);
    }

    @Override
    public String toString() {
        return " |Gun~" + getName() + "      " + " |Acc~" + getAccuracy() + "%" + " |Calibre~"
                + (getCalibre() == Calibre.FIVE ? 5 : 10) + "mm";
    }
}