import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public void help(){
        System.out.println("What letter (or word) do you want to check the stats of?");
        Scanner scn = new Scanner(System.in);
        boolean valid = false;
        String questionableLetter = "";
        while(!valid){
            try{
                questionableLetter = scn.nextLine();
                int[] question = attack.action(questionableLetter);
                System.out.println("This letter/word's attack: " + question[0]);
                System.out.println("This letter/word's possible targets: " + question[1]);
                System.out.println("This letter/word's self recovery: " + question[2]);
                System.out.println("This letter/word's shield: " + question[3]);
                valid = true;
            }
            // todo - fix non-letter input being acceptable
            catch (Exception e){
                System.out.println("Bad input, try again");
            }
        }

    }

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
        System.out.println("Type the word you are attacking with (or press ? to figure out what a letter does):");
        Scanner scn = new Scanner(System.in);
        boolean valid = false;
        String comfirmedWord = "";
        while(!valid) {

            String chosenWord = scn.next();
            if(chosenWord.equals("?")){
                help();
                System.out.println("Type the word you are attacking with (or press ? to figure out what a letter does):");
            }
            //checks if you use only letters you know
            else{ for(int i = 0; i < chosenWord.length();i++) {
                char ch = (chosenWord.charAt(i));
                if (!letters_known.contains(Character.toString(ch))) {
                    System.out.println("Your word contains a letter you don't know, try again");
                    letters_known.addAll(word);
                    word.clear();
                    valid = false;
                    break;
                } else {
                    word.add(Character.toString(ch));
                    letters_known.remove(Character.toString(ch));
                    valid = true;
                }
            }
                //checks to see if your word is an actual word
                WordCheck checker = new WordCheck();
                if(checker.checkWord(chosenWord)) comfirmedWord = chosenWord;
                else{
                    valid = false;
                    System.out.println("The word you chose is not in the English dictionary, try again");
                    letters_known.addAll(word);
                    word.clear();
                }
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
        boolean finished = false;
        System.out.print("Press r to choose a reward or any other input to capitalize an already known letter (or press ? to learn what letters and words do): ");
        Scanner scn = new Scanner(System.in);
        while(!finished) {
            String choice = scn.nextLine();
            if (choice.equals("r")) {
                System.out.println("Reward options:");
                for (int i = 0; i < rewards.length; i++) {
                    System.out.print(rewards[i] + " ");
                }
                System.out.println("Type the index of your chosen reward : ");
                boolean valid = false;
                while (!valid) {
                    try {
                        int chosen_letter = scn.nextInt();
                        letters_known.add(rewards[chosen_letter]);
                        valid = true;
                    } catch (InputMismatchException e) {
                        System.out.println("I said to input the INDEX of the letter of what you wanted you dunce, try again");
                        scn.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("FYI We use 0 based indexing here, so please try again.");
                    }
                }
                finished = true;
            } else if (choice.equals("?")) {
                help();
                System.out.print("Press r to choose a reward or any other input to capitalize an already known letter (or press ? to learn what letters and words do): ");
            } else {
                printKnownLetters();
                System.out.println("What letter would you like to capitalize?");
                String toCapital = scn.nextLine();
                for (int i = 0; i < letters_known.size(); i++) {
                    if (letters_known.get(i).equals(toCapital))
                        letters_known.set(i, letters_known.get(i).toUpperCase());
                }
                finished = true;
            }
        }
    }
    public int getHealth(){
        return health;
    }
}
