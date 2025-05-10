import java.util.ArrayList;
import java.util.Scanner;

public class player {
    ArrayList<String> letters_known = new ArrayList<>();
    ArrayList<String> word = new ArrayList<>();
    private int health = 25;
    private int damage = 0;
    private int shield = 0;
    private int recovery = 0;
    private boolean alive = true;
    private letter attack = new letter();

    public void printKnownLetters(){
        System.out.println("Known Letters: ");
        for (String s : letters_known) {
            System.out.print(s + " ");
        }
    }
    public int[] action(){
        System.out.print("Letters Known: ");
        for(int i = 0; i < letters_known.size();i++){
            System.out.print(letters_known.get(i) + " ");
        }
        System.out.println("What word are you attacking with?");
        Scanner scn = new Scanner(System.in);
        boolean valid = false;
        String comfirmedWord = "";
        while(!valid) {
            String chosenWord = scn.next();
            for(int i = 0; i < chosenWord.length();i++){
                char ch = (chosenWord.charAt(i));
                if(!letters_known.contains(Character.toString(ch))){
                    System.out.println("Your word contains a letter you don't know, try again");
                    letters_known.addAll(word);
                    word.clear();
                    valid = false;
                    break;
                }
                else{
                    word.add(Character.toString(ch));
                    letters_known.remove(Character.toString(ch));
                    valid = true;
                }
                comfirmedWord = chosenWord;
            }
        }
        letters_known.addAll(word);
        word.clear();
        int[] w = attack.action(comfirmedWord);
        recovery = w[2];
        shield = w[3];
        return w;
    }
    public void heal(){
        health += recovery;
    }
    public void takeDamage(int pain){
        if(shield > 0){
            int leftOver = shield - pain;
            shield -= pain;
            //if damage dealt excedes shield, do the left over damage
            if(leftOver < 0) health += leftOver;
        }
        else{
            health -= pain;
        }
        if(health <= 0) alive = false;
    }
    public boolean isAlive(){
        return alive;
    }
    //randomizes starting letters
    public void startingLetters(){
        for(int i = 0; i < 6; i++){
            int letter = (int) (Math.random() * 26);
            if(letter == 0){
                letters_known.add("a");
            } else if (letter == 1) {
                letters_known.add("b");
            } else if (letter == 2) {
                letters_known.add("c");
            }else if (letter == 3) {
                letters_known.add("d");
            }else if (letter == 4) {
                letters_known.add("e");
            }else if (letter == 5) {
                letters_known.add("f");
            }else if (letter == 6) {
                letters_known.add("g");
            }else if (letter == 7) {
                letters_known.add("h");
            }else if (letter == 8) {
                letters_known.add("i");
            }else if (letter == 9) {
                letters_known.add("j");
            }else if (letter == 10) {
                letters_known.add("k");
            }else if (letter == 11) {
                letters_known.add("l");
            }else if (letter == 12) {
                letters_known.add("m");
            }else if (letter == 13) {
                letters_known.add("n");
            }else if (letter == 14) {
                letters_known.add("o");
            }else if (letter == 15) {
                letters_known.add("p");
            }else if (letter == 16) {
                letters_known.add("q");
            }else if (letter == 17) {
                letters_known.add("r");
            }else if (letter == 18) {
                letters_known.add("s");
            }else if (letter == 19) {
                letters_known.add("t");
            }else if (letter == 20) {
                letters_known.add("u");
            }else if (letter == 21) {
                letters_known.add("v");
            }else if (letter == 22) {
                letters_known.add("w");
            } else if (letter == 23) {
                letters_known.add("x");
            }else if (letter == 24) {
                letters_known.add("y");
            }
            else{
                letters_known.add("z");
            }
        }
    }
    public void chooseRewards(String [] rewards){
        System.out.print("Choose what letter to add to your collection: ");
        for(int i = 0; i < rewards.length; i++){
            System.out.print(rewards[i] + " ");
        }
        Scanner scn = new Scanner(System.in);
        int chosen_letter = scn.nextInt();
        letters_known.add(rewards[chosen_letter]);
    }
    public int getHealth(){
        return health;
    }
}
