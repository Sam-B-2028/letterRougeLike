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
                    break;
                }
                else{
                    word.add(Character.toString(ch));
                    letters_known.remove(Character.toString(ch));
                }
                comfirmedWord = chosenWord;
            }
        }
        letters_known.addAll(word);
        return attack.action(comfirmedWord);
    }
    public void heal(){
        health += recovery;
    }
    public void takeDamage(int pain){
        if(shield > 0){
            shield -= pain;
            //if damage dealt excedes shield, do the left over damage
            if(shield < 0) health -= pain;
        }
        else{
            health -= pain;
        }
        if(health <= 0) alive = false;
    }
    public boolean isAlive(){
        return alive;
    }
}
