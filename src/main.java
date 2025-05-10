import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        levelGenerator engine = new levelGenerator();
        player user = new player();
        user.startingLetters();
        while(user.isAlive()){
            level newLevel = engine.newLevel();
            System.out.println("Level: " + engine.getLevelsCompleted());
            while(newLevel.encounterAlive()) {
                newLevel.display_enemy();
                System.out.println("Who are you attacking?");
                Scanner scn = new Scanner(System.in);
                int initialTarget = scn.nextInt();
                int[] playerPhase = user.action();
                user.heal();
                newLevel.receive_damage(initialTarget, playerPhase[0], playerPhase[1]);
                if(!newLevel.encounterAlive()) break;
                int enemyPhase = newLevel.enemy_phase();
                user.takeDamage(enemyPhase);
                if(!user.isAlive()) break;
                else{
                    System.out.println("Your health");
                    System.out.println(user.getHealth());
                }

            }
            user.chooseRewards(newLevel.getRewards());
        }
        System.out.println("Game Over!");



    }
}
