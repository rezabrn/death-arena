package ir.ac.kntu.logic;

import ir.ac.kntu.util.RandomHelper;

public class SniperRifle extends Gun {
    private boolean scope;

    public SniperRifle(Calibre calibre, boolean scope) {
        super(calibre, "SR", 60, 20);
        this.scope = false;
        if (scope) {
            this.scope = true;
            setAccuracy(getAccuracy() + RandomHelper.nextInt(5, 15));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SniperRifle other = (SniperRifle) obj;
        return scope == other.scope;
    }

    @Override
    public String toString() {
        return " |Gun~" + getName() + (scope ? "-scope" : "      ") + " |Acc~" + getAccuracy() + "%" + " |Calibre~" + (getCalibre() == Calibre.FIVE ? 5 : 10) + "mm";
    }
}