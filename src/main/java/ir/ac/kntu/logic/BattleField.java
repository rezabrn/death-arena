package ir.ac.kntu.logic;

import ir.ac.kntu.logic.Soldier;
import ir.ac.kntu.util.RandomHelper;

public class BattleField {
    private int accuracyRollA;
    private int accuracyRollB;
    private boolean hitsA;
    private boolean hitsB;
    private int damageA;
    private int damageB;
    private final Soldier soldierA;
    private final Soldier soldierB;

    public BattleField(Soldier currentASoldier, Soldier currentBSoldier) {
        hitsA = hitsB = false;
        damageA = damageB = accuracyRollA = accuracyRollB = 0;
        soldierA = currentASoldier;
        soldierB = currentBSoldier;

        if (RandomHelper.nextBoolean()) {
            firstAFight();
        } else {
            firstBFight();
        }
    }

    private void firstAFight() {
        accuracyRollA = RandomHelper.nextInt(1, 99);
        hitsA = accuracyRollA <= soldierA.getGun().getAccuracy();
        if (hitsA) {
            damageA = soldierA.getGun().getPower();
        }
        if (soldierB.getHealth() - damageA > 0) {
            accuracyRollB = RandomHelper.nextInt(1, 99);
            hitsB = accuracyRollB <= soldierB.getGun().getAccuracy();
            if (hitsB) {
                damageB = soldierB.getGun().getPower();
            }
        }
    }

    private void firstBFight() {
        accuracyRollB = RandomHelper.nextInt(1, 99);
        hitsB = accuracyRollB <= soldierB.getGun().getAccuracy();
        if (hitsB) {
            damageB = soldierB.getGun().getPower();
        }
        if (soldierA.getHealth() - damageB > 0) {
            accuracyRollA = RandomHelper.nextInt(1, 99);
            hitsA = accuracyRollA <= soldierA.getGun().getAccuracy();
            if (hitsA) {
                damageA = soldierA.getGun().getPower();
            }
        }
    }

    public boolean isHitsA() {
        return hitsA;
    }

    public boolean isHitsB() {
        return hitsB;
    }

    public int getAccuracyRollA() {
        return accuracyRollA;
    }

    public int getAccuracyRollB() {
        return accuracyRollB;
    }

    public int getDamageA() {
        return damageA;
    }

    public int getDamageB() {
        return damageB;
    }
}