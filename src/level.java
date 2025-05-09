import java.util.ArrayList;

public class level {
    ArrayList<Enemy> combat_encounter;
    String[] rewards;

    public level(ArrayList<Enemy> combat_encounter, String[] rewards){
        this.combat_encounter = combat_encounter;
        this.rewards = rewards;
    }
    public void receive_damage(int index, int damage, int targets){
        if(targets > 0) {
            combat_encounter.get(index).receive_damage(damage);
            if(targets > 1){
                for(int i = 1; i < targets;i++){
                    //you can target another to the right
                    if(index + i< combat_encounter.size()) combat_encounter.get(index + 1).receive_damage(damage);
                    //if not check to the left
                    else if (index - i > 0) combat_encounter.get(index - 1).receive_damage(damage);
                    //if you can't target anyone stop looking for more people
                }
                for(int i = 0; i < combat_encounter.size(); i++){
                    if(!combat_encounter.get(i).isAlive()) combat_encounter.remove(i);
                }
            }
        }

    }
    public int enemy_phase(){
        int d = 0;
        for(int i = 0; i < combat_encounter.size(); i++){
           d += combat_encounter.get(i).action();
           combat_encounter.get(i).heal();
        }
        return d;
    }
    public void display_enemy(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < combat_encounter.size(); j++){
                if(i==0){
                    System.out.print("health: " + combat_encounter.get(j).getHealth());
                }
                else if(i==1){
                    System.out.print("damage: " + combat_encounter.get(j).getDamage());
                }
                else if(i==2){
                    System.out.print("target: " + combat_encounter.get(j).getTarget());
                }
                else{
                    System.out.print("recovery: " + combat_encounter.get(j).getRecovery());
                }
            }
        }
        System.out.println();
    }


}
