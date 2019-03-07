package rpg;

import java.util.*;

abstract class Enemy extends Character{
    protected int exp;
    protected int skill_num;
    
    Enemy(String name, int hp, int atk, int def, int spd, int sp_atk, int sp_def, int evade_rate, int criti_rate, String description, int exp, int skill_num){
        super(name, hp, atk, def, spd, sp_atk, sp_def, evade_rate, criti_rate, description);
        this.exp = exp; this.skill_num = skill_num;
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
    
    public void printInfo() {
        System.out.println("***" + this.name + "************");
        System.out.println("HP: " + this.hp_max + " ATK: " + this.atk_max + " DEF: " + this.def_max);
        System.out.println("SPD: " + this.spd_max + " SATK: " + this.sp_atk + " SDEF: " + this.sp_def);
        System.out.println(this.description);
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