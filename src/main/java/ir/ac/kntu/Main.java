package ir.ac.kntu;

import ir.ac.kntu.logic.ConsoleGraphicsEngine;
import ir.ac.kntu.logic.Director;
import ir.ac.kntu.logic.GraphicsEngine;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter the number of a group: ");
        int counter = (new Scanner(System.in)).nextInt();
        Director director = new Director(counter);

        director.startGameLoop();

    }

}
