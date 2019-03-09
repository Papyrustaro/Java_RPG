package rpg;

import java.util.*;

abstract class Enemy extends Character{
    protected int exp;
    protected int skill_num;
    
    Enemy(String name, int hp, int atk, int def, int spd, int sp_atk, int sp_def, int evade_rate, int criti_rate, String description, int exp, int skill_num){
        super(name, hp, atk, def, spd, sp_atk, sp_def, evade_rate, criti_rate, description);
        this.exp = exp; this.skill_num = skill_num;
    }
    
    
    public void skill(Character target, int skill_num) {
        Random random = new Random();
        int random_num = random.nextInt(skill_num) + 1;
        
        switch(random_num) {
        case 1:
            skill1(target);
            break;
        case 2:
            skill2(target);
            break;
        case 3:
            skill3(target);
            break;
        case 4:
            skill4(target);
            break;
        case 5:
            skill5(target);
            break;
        case 6:
            skill6(target);
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
    
    public void skill1(Character target) {
        ;   
    }
    public void skill2(Character target) {
        ;
    }
    public void skill3(Character target) {
        ;
    }
    public void skill4(Character target) {
        ;
    }
    public void skill5(Character target) {
        ;
    }
    public void skill6(Character target) {
        ;
    }
    
    
}