package rpg;

import java.util.*;

class Enemy extends Character{
    protected String info;
    protected int skill_num;
    
    Enemy(String name, int hp, int atk, int def, String info, int skill_num){
        super(name, hp, atk, def);
        this.info = info; this.skill_num = skill_num;
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
    
    public void printInfo(Enemy enemy) {
        System.out.println("***" + enemy.name + "************");
        System.out.println("HP: " + enemy.hp + " ATK: " + enemy.atk + " DEF: " + enemy.def);
        System.out.println(enemy.info);
        System.out.println("********************");
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