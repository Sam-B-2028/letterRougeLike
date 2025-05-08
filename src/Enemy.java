public class Enemy {
    int health = 0;
    int target = 0;
    int damage = 0;
    int recovery = 0;
    public Enemy(int health, int target, int damage, int recovery){
        this.health = health;
        this.target = target;
        this.damage = damage;
        this.recovery = recovery;

    }
    public int action(){
        return damage;
    }
    public void heal(){
        health += recovery;
    }

}
