package ir.ac.kntu.logic;

import java.util.*;

import ir.ac.kntu.util.RandomHelper;

public class Director {

    private List<Soldier> groupA;

    private List<Soldier> groupB;

    private GraphicsEngine graphicsEngine;

    private Soldier currentASoldier;

    private Soldier currentBSoldier;

    private VictoryState victoryState;

    private BattleField battleField;

    public Director(int counter) {
        groupA = new ArrayList<>();
        groupB = new ArrayList<>();
        List<Soldier>[] groups = new List[] { groupA, groupB };
        currentASoldier = null;
        currentBSoldier = null;
        battleField = null;
        for (List<Soldier> currentGroup : groups) {
            for (int i = 0; i < counter; i++) {
                Gun gun;
                Calibre calibre = (RandomHelper.nextBoolean() ? Calibre.FIVE : Calibre.TEN);
                if (RandomHelper.nextBoolean()) {
                    gun = new AssaultRifle(calibre);
                } else {
                    gun = new SniperRifle(calibre, RandomHelper.nextBoolean());
                }
                currentGroup.add(new Soldier((currentGroup.equals(groupA) ? "A" : "B") + (i + 1),
                        (RandomHelper.nextInt(10, 99)), 0, gun));
            }
        }
        graphicsEngine = new ConsoleGraphicsEngine();

        victoryState = VictoryState.NOT_FINISHED;
    }

    public void startGameLoop() {
        graphicsEngine.initialize(groupA, groupB, currentASoldier, currentBSoldier, battleField);
        while (victoryState.equals(VictoryState.NOT_FINISHED)) {
            currentASoldier = groupA.get(RandomHelper.nextInt(groupA.size()));
            currentBSoldier = groupB.get(RandomHelper.nextInt(groupB.size()));

            battleField = new BattleField(currentASoldier, currentBSoldier);

            graphicsEngine.initialize(groupA, groupB, currentASoldier, currentBSoldier, battleField);

            currentASoldier.setDamage(currentASoldier.getDamage() + battleField.getDamageB());
            currentASoldier.setHealth(currentASoldier.getHealth() - battleField.getDamageB());

            currentBSoldier.setDamage(currentBSoldier.getDamage() + battleField.getDamageA());
            currentBSoldier.setHealth(currentBSoldier.getHealth() - battleField.getDamageA());

            if (currentASoldier.getHealth() <= 0) {
                groupA.remove(currentASoldier);
            }

            if (currentBSoldier.getHealth() <= 0) {
                groupB.remove(currentBSoldier);
            }

            if (groupA.size() == 0) {
                victoryState = VictoryState.WIN_B;
            } else if (groupB.size() == 0) {
                victoryState = VictoryState.WIN_A;
            }
            graphicsEngine.visualizeVictoryCondition(victoryState, groupA, groupB);
        }
    }

    public enum VictoryState {
        WIN_A, WIN_B, NOT_FINISHED
    }
}