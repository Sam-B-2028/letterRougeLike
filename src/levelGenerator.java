import java.util.ArrayList;

public class levelGenerator {
    int levelsCompleted = 0;

    public void reset(){
        levelsCompleted = 0;
    }
    public int getLevelsCompleted(){
        return levelsCompleted;
    }
    public level newLevel(){
        ArrayList<Enemy> e = new ArrayList<>();
        String[] rewards = new String [3];

        int number_of_enemies = (int)(Math.random() * levelsCompleted) + 1;
        for(int i = 0; i < number_of_enemies; i++){
            e.add(new Enemy((int) (Math.random() * levelsCompleted) + 1,
                    (int) (Math.random() * levelsCompleted) + 1,
                    (int) (Math.random() * levelsCompleted) + 2,
                            (int) (Math.random() * levelsCompleted)));
            //every 5 levels completed add a more powerful enemy in the array of enemies
            if(levelsCompleted % 5 == 4)  e.add(new Enemy((int) (Math.random() * levelsCompleted) + 4,
                    (int) (Math.random() * levelsCompleted) + 1,
                    (int) (Math.random() * levelsCompleted) + 4,
                    (int) (Math.random() * levelsCompleted) + 2));
        }
        //randomizes the rewards
        for(int i = 0; i < 3; i++){
            int letter = (int) (Math.random() * 26);
            if(letter == 0){
                rewards[i] = "a";
            } else if (letter == 1) {
                rewards[i] = "b";
            } else if (letter == 2) {
                rewards[i] = "c";
            }else if (letter == 3) {
                rewards[i] = "d";
            }else if (letter == 4) {
                rewards[i] = "e";
            }else if (letter == 5) {
                rewards[i] = "f";
            }else if (letter == 6) {
                rewards[i] = "g";
            }else if (letter == 7) {
                rewards[i] = "h";
            }else if (letter == 8) {
                rewards[i] = "i";
            }else if (letter == 9) {
                rewards[i] = "j";
            }else if (letter == 10) {
                rewards[i] = "k";
            }else if (letter == 11) {
                rewards[i] = "l";
            }else if (letter == 12) {
                rewards[i] = "m";
            }else if (letter == 13) {
                rewards[i] = "n";
            }else if (letter == 14) {
                rewards[i] = "o";
            }else if (letter == 15) {
                rewards[i] = "p";
            }else if (letter == 16) {
                rewards[i] = "q";
            }else if (letter == 17) {
                rewards[i] = "r";
            }else if (letter == 18) {
                rewards[i] = "s";
            }else if (letter == 19) {
                rewards[i] = "t";
            }else if (letter == 20) {
                rewards[i] = "u";
            }else if (letter == 21) {
                rewards[i] = "v";
            }else if (letter == 22) {
                rewards[i] = "w";
            } else if (letter == 23) {
                rewards[i] = "x";
            }else if (letter == 24) {
                rewards[i] = "y";
            }
            else{
                rewards[i] = "z";
            }
        }
        levelsCompleted++;
        return new level(e, rewards);
    }

}
