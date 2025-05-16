import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        System.out.println("Welcome to funny letter based rouge like");
        levelGenerator engine = new levelGenerator();
        player user = new player();
        user.startingLetters();
        while(user.isAlive()){
            level newLevel = engine.newLevel();
            System.out.println("Level: " + engine.getLevelsCompleted());
            while(newLevel.encounterAlive()) {
                System.out.println("Enemies:");
                newLevel.display_enemy();
                Scanner scn = new Scanner(System.in);
                boolean valid = false;
                while(!valid) {
                    try {
                        System.out.println("Who are you attacking?");
                        int initialTarget = scn.nextInt();
                        int[] playerPhase = user.action();
                        newLevel.receive_damage(initialTarget, playerPhase[0], playerPhase[1]);
                        valid = true;
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Invalid target, try again (We use 0 based indexing FYI).");
                    }
                    catch (InputMismatchException e){
                        System.out.println("I thought it was obvious that I wanted an index here, but I guess I'm stupid. Try again!");
                        scn.nextLine();
                    }
                }
                user.heal();
                if(!newLevel.encounterAlive()) {
                    user.chooseRewards(newLevel.getRewards());
                    break;
                }
                int enemyPhase = newLevel.enemy_phase();
                user.takeDamage(enemyPhase);
                if(!user.isAlive()) break;
                else{
                    System.out.println("Your health");
                    System.out.println(user.getHealth());
                }

            }
        }
        System.out.println("Game Over!");



    }
}
