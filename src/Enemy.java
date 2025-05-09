public class Enemy {
    int health = 0;
    int target = 0;
    int damage = 0;
    int recovery = 0;
    boolean alive = true;
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
    public void receive_damage(int pain){
        health -= pain;
        if (health <= 0) alive = false;
    }
    public boolean isAlive(){
        return alive;
    }
}
