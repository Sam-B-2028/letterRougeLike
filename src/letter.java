import java.util.ArrayList;
import java.util.Scanner;

public class letter {
    int[] packet = new int[4];
    int damage = 0;
    int targets = 1;
    int recovery = 0;
    int shield = 0;

    public int[] action(String word){
        reset();
        Scanner scn = new Scanner(word);
        scn.useDelimiter("");
        ArrayList<String> word_split = new ArrayList<>();
        while(scn.hasNext()){
            word_split.add(scn.next());
        }
        for(int i = 0; i < word_split.size();i++){
            if(word_split.get(i).equals("a") || word_split.get(i).equals("A")){
                a(word_split.get(i));
            }if(word_split.get(i).equals("b") || word_split.get(i).equals("B")){
                b(word_split.get(i));
            }if(word_split.get(i).equals("c") || word_split.get(i).equals("C")){
                c(word_split.get(i));
            }if(word_split.get(i).equals("d") || word_split.get(i).equals("D")){
                d(word_split.get(i));
            }if(word_split.get(i).equals("e") || word_split.get(i).equals("E")){
                e(word_split.get(i));
            }if(word_split.get(i).equals("f") || word_split.get(i).equals("F")){
                f(word_split.get(i));
            }if(word_split.get(i).equals("g") || word_split.get(i).equals("G")){
                g(word_split.get(i));
            }if(word_split.get(i).equals("h") || word_split.get(i).equals("H")){
                h(word_split.get(i));
            }if(word_split.get(i).equals("i") || word_split.get(i).equals("I")){
                if(word_split.contains("j")){
                    i(word_split.get(i));
                }
                i(word_split.get(i));
            }if(word_split.get(i).equals("j") || word_split.get(i).equals("J")){
                if(!word_split.contains("i")) {
                    j(word_split.get(i));
                }
            }if(word_split.get(i).equals("k") || word_split.get(i).equals("K")){
                k(word_split.get(i));
            }if(word_split.get(i).equals("l") || word_split.get(i).equals("L")){
                l(word_split.get(i));
            }if(word_split.get(i).equals("m") || word_split.get(i).equals("M")){
                m(word_split.get(i));
            }if(word_split.get(i).equals("n") || word_split.get(i).equals("N")){
                n(word_split.get(i));
            }if(word_split.get(i).equals("o") || word_split.get(i).equals("O")){
                o(word_split.get(i));
            }if(word_split.get(i).equals("p") || word_split.get(i).equals("P")){
                p(word_split.get(i));
            }if(word_split.get(i).equals("q") || word_split.get(i).equals("Q")){
                q(word_split.get(i));
            }if(word_split.get(i).equals("r") || word_split.get(i).equals("R")) {
                r(word_split.get(i));
            }if(word_split.get(i).equals("s") || word_split.get(i).equals("S")){
                 s(word_split.get(i));
                 //if s is followed by h, increase shield and recovery by 1
                 if(i != word_split.size() - 1 && (word_split.get(i+1).equals("h") || word_split.get((i+1)).equals("H"))){
                     shield++;
                     recovery++;
                 }
            }if(word_split.get(i).equals("t") || word_split.get(i).equals("T")){
                //if h follows t, do h twice
                if (i != word_split.size() - 1&&(word_split.get(i + 1).equals("h") || word_split.get(i + 1).equals("H"))) {
                    h(word_split.get(i + 1));
                }
                t(word_split.get(i));
            }if(word_split.get(i).equals("u") || word_split.get(i).equals("U")) {
                //if u follows q, do q twice but not u
                if (i != 0 &&(word_split.get(i - 1).equals("q") || word_split.get(i - 1).equals("Q"))) {
                    q(word_split.get(i - 1));
                }
                else {
                    u(word_split.get(i));
                }

            }
            if(word_split.get(i).equals("v") || word_split.get(i).equals("V")){
                v(word_split.get(i));
            }if(word_split.get(i).equals("w") || word_split.get(i).equals("W")){
                w(word_split.get(i));
            }if(word_split.get(i).equals("x") || word_split.get(i).equals("X")){
                x(word_split.get(i));
            }if(word_split.get(i).equals("y") || word_split.get(i).equals("Y")){
                y(word_split.get(i));
            }if(word_split.get(i).equals("z") || word_split.get(i).equals("Z")) {
                z(word_split.get(i));
            }
        }
        packet[0] = damage;
        packet[1] = targets;
        packet[2] = recovery;
        packet[3] = shield;
        return packet;
    }
    private void a(String letter){
        if(letter.equals(letter.toLowerCase())){
            recovery+=2;
        }
        else{
            recovery+=2;
            targets++;
        }
    }
    private void b(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage -= 4;
            shield *=2;

        }
        else{
            damage -=4;
            shield *=3;
        }
    }private void c(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage +=2;
            shield += 1;
        }
        else{
            damage += 2;
            shield += 2;
        }
    }private void d(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage *= 2;
            shield -=4;
        }
        else{
            damage *=3;
            shield -=4;
        }
    }private void e(String letter){
        if(letter.equals(letter.toLowerCase())){
            shield++;
        }
        else{
            shield += 2;
        }
    }private void f(String letter){
        if(letter.equals(letter.toLowerCase())){
            targets *= 2;
        }
        else{
            targets++;
            targets *=2;
        }
    }private void g(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage += 4;
            targets--;
        }
        else{
            damage += 6;
            targets--;

        }
    }private void h(String letter){
        if(letter.equals(letter.toLowerCase())){
            recovery+= 2;
            damage --;
        }
        else{
            recovery += 3;
        }
    }private void i(String letter){
        if(letter.equals(letter.toLowerCase())){
            recovery *= 2;
        }
        else{
            recovery *= 3;
        }
    }private void j(String letter){
        if(letter.equals(letter.toLowerCase())){

        }
        else{

        }
    }private void k(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage += 6;
            shield -= 2;
        }
        else{
            damage += 6;
            shield -= 4;
            targets++;
        }
    }private void l(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage++;
            targets++;
        }
        else{
            damage += 2;
            targets +=2;
        }
    }private void m(String letter){
        if(letter.equals(letter.toLowerCase())){
            targets /= 2;
            damage *= 2;
        }
        else{
            targets /= 4;
            damage *= 4;
        }
    }private void n(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage++;
        }
        else{
            damage+=3;
        }
    }
    private void o(String letter){
        if(letter.equals(letter.toLowerCase())){
            shield += 5;
            damage -= 2;
        }
        else{
            shield += 7;
            damage -= 2;
        }
    }private void p(String letter){
        if(letter.equals(letter.toLowerCase())){
            recovery += 10;
            shield -= 5;
        }
        else{
            recovery += 10;
            shield -= 5;
            damage += 3;
        }
    }private void q(String letter){
        if(letter.equals(letter.toLowerCase())){
            shield *= 3;
            damage++;
        }
        else{
            shield *=4;
            damage++;
        }
    }private void r(String letter){
        if(letter.equals(letter.toLowerCase())){
            targets = 50;
            shield -= 10;
        }
        else{
            targets = 90;
            shield -= 10;
            damage ++;
        }
    }private void s(String letter){
        if(letter.equals(letter.toLowerCase())){
            shield++;
            damage++;
        }
        else{
            shield++;
            damage+=2;
        }
    }private void t(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage += 2;
        }
        else{
            damage += 3;
            shield ++;
        }
    }private void u(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage -= 5;
            shield += 10;
        }
        else{
            damage--;
            shield += 10;
        }
    }private void v(String letter){
        if(letter.equals(letter.toLowerCase())){
            shield -= 5;
            damage += 10;
        }
        else{
            damage += 10;
            shield--;
        }
    }private void w(String letter){
        if(letter.equals(letter.toLowerCase())){
            targets += 10;
            damage-=5;
        }
        else{
            targets += 10;
            damage--;
        }
    }private void x(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage += 15;
            shield -= 5;
            recovery -= 5;
        }
        else{
            damage += 15;
            shield --;
            recovery--;
        }
    }private void y(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage *= 2;
        }
        else{
            damage++;
            damage *= 2;
        }
    }private void z(String letter){
        if(letter.equals(letter.toLowerCase())){
            damage++;
            targets++;
            recovery++;
            shield++;
        }
        else{
            damage+=3;
            targets+=3;
            recovery+=3;
            shield+=3;
        }
    }
    private void reset(){
        damage = 0;
        targets = 1;
        recovery = 0;
        shield = 0;
    }

}
