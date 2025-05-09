public class Enemy {
    private int health = 0;
    private int target = 0;
    private int damage = 0;
    private int recovery = 0;
    boolean alive = true;
    public Enemy(int health, int target, int damage, int recovery){
        this.health = health;
        this.target = target;
        this.damage = damage;
        this.recovery = recovery;

    }
    public int getHealth(){
        return health;
    }
    public int getTarget(){
        return target;
    }
    public int getDamage(){
        return damage;
    }
    public int getRecovery(){
        return recovery;
    }
    public int action(){
        return damage * target;
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
