package ir.ac.kntu.logic;

import java.net.StandardSocketOptions;
import java.util.*;

public class ConsoleGraphicsEngine implements GraphicsEngine {
    Director director;
    @Override
    public void initialize(List<Soldier> groupA, List<Soldier> groupB, Soldier currentASoldier, Soldier currentBSoldier, Attack attack, int turn) {
        
        System.out.println("______________________________ Group A ______________________________");
        printGroup(groupA, currentASoldier);

        if (currentASoldier != null && currentBSoldier != null) {
            visualizeFight(currentASoldier, currentBSoldier, attack);
        } else {
            System.out.println("\n\n");
        }

        printGroup(groupB, currentBSoldier);
        System.out.println("______________________________ Group B ______________________________");
        System.out.println();
        System.out.println("turn: " + turn);
    }

    @Override
    public void visualizeFight(Soldier currentASoldier, Soldier currentBSoldier, Attack attack) {
        System.out.println("\n");
        System.out.println("                               ~ARENA~");
        System.out.println("                               Soldier A");
        System.out.println(currentASoldier.toString() + "\n\n");
            if (attack.isHitsA()) {
                System.out.println("Soldier A attacks ~ AccuracyRoll:" + attack.getAccuracyRollA() + " ~" + hitAttackNote("A") + attack.getDmgA() + " DMG");
            } else {
                System.out.println("Soldier A attacks ~ AccuracyRoll:" + attack.getAccuracyRollA() + " ~" + missedAttackNote());
            }
            if (attack.isHitsB()) {
                System.out.println("Soldier B attacks ~ AccuracyRoll:" + attack.getAccuracyRollA() + " ~" + hitAttackNote("B") + attack.getDmgB() + " DMG");
            } else {
                System.out.println("Soldier B attacks ~ AccuracyRoll:" + attack.getAccuracyRollA() + " ~" + missedAttackNote());
            }
            System.out.println("\n\n" + currentBSoldier.toString());

        System.out.println("                               Soldier B");
        System.out.println("                               ~ARENA~\n\n");
    }

    @Override
    public void visualizeDeath(List<Soldier> groupA, List<Soldier> groupB) {
        System.out.println("\n\n\n");
        System.out.println("______________________________ Group A ______________________________");
        for (Soldier s : groupA) {
            System.out.println(s);
        }
        System.out.println("\n\n");
        System.out.println("______________________________ Group B ______________________________");
        for (Soldier s : groupB) {
            System.out.println(s);
        }
    }

    @Override
    public void visualizeVictoryCondition(Director.VictoryState victoryState, List<Soldier> groupA, List<Soldier> groupB) {
        switch (victoryState) {
            case WIN_A:
                System.out.println("\n    Group A Win");
                System.out.println("\n\n\n\n");
                visualizeDeath(groupA, groupB);
                break;
            case WIN_B:
                System.out.println("\n    Group B Win");
                System.out.println("\n\n\n\n");
                visualizeDeath(groupA, groupB);
                break;
            case NOT_FINISHED:
                System.out.println("    Game dose not finished");
                System.out.println("\npress any key to proceed");
                (new Scanner(System.in)).nextLine();
                System.out.println("\n\n\n\n");
                break;
            default:
                break;
        }
    }

    static void printGroup(List<Soldier> group, Soldier soldier) {
        for (Soldier s : group) {
            if (s.equals(soldier)) {
                continue;
            }
            System.out.println(s);
        }
    }

    static String missedAttackNote() {
        return " Attack Missed";
    }

    String hitAttackNote(String hitterGroupId) {
        if (hitterGroupId == "A") {
            return " Attack Hits ~ Soldier B takes ";
        } else {
            return " Attack Hits ~ Soldier A takes ";
        }
    }
}