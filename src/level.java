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
                    else{
                        break;
                    }
                }
            }
        }

    }
    public void enemy_phase(){

    }
    public void display_enemy(){

    }


}
