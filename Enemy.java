package rpg;

import java.util.*;

class Enemy extends Character{
    Enemy(String name, int hp, int atk, int def){
        super(name, hp, atk, def);
    }
    
    
    public void skill(Enemy enemy, Ally ally, int skill_num) {
        Random random = new Random();
        int random_num = random.nextInt(skill_num) + 1;
        
        switch(random_num) {
        case 1:
            skill1(enemy, ally);
            break;
        case 2:
            skill2(enemy, ally);
            break;
        case 3:
            skill3(enemy, ally);
            break;
        case 4:
            skill4(enemy, ally);
            break;
        case 5:
            skill5(enemy, ally);
            break;
        case 6:
            skill6(enemy, ally);
            break;
        }
        
    }
    public void skill1(Enemy enemy, Ally ally) {
        ;
    }
    public void skill2(Enemy enemy, Ally ally) {
        ;
    }
    public void skill3(Enemy enemy, Ally ally) {
        ;
    }
    public void skill4(Enemy enemy, Ally ally) {
        ;
    }
    public void skill5(Enemy enemy, Ally ally) {
        ;
    }
    public void skill6(Enemy enemy, Ally ally) {
        ;
    }
    
}