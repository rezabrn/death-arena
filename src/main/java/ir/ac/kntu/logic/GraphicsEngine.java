package ir.ac.kntu.logic;

import java.util.List;

public interface GraphicsEngine {

    public void initialize(List<Soldier> groupA, List<Soldier> groupB, Soldier currentASoldier, Soldier currentBSoldier,
            BattleField battleField, int turn);

    public void visualizeFight(Soldier currentASoldier, Soldier currentBSoldier, BattleField battleField);

    public void visualizeDeath(List<Soldier> groupA, List<Soldier> groupB);

    public void visualizeVictoryCondition(Director.VictoryState victoryState, List<Soldier> groupA,
            List<Soldier> groupB);
}
