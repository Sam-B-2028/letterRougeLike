public class main {

    public static void main(String[] args){
        letter l = new letter();
        int [] packet = l.action("hellO");
        for(int p: packet)
        System.out.println(p);

    }
}
