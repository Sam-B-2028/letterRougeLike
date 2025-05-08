import java.util.ArrayList;

public class levelGenerator {
    int levelsCompleted = 0;

    public void reset(){
        levelsCompleted = 0;
    }

    public level newLevel(){
        ArrayList<Enemy> e = new ArrayList<>();
        String[] rewards = new String [3];

        int number_of_enemies = (int)(Math.random() * levelsCompleted) + 1;
        for(int i = 0; i < number_of_enemies; )

        return new level(e, rewards);
    }

}
