package rpg;

class Ally extends Character{
    protected int hp_max = hp;
    protected int mp;
    protected int mp_max = mp;
    protected int level = 1;
    protected int exp = 0;
    
    Ally(String name, int hp, int mp, int atk, int def){
        super(name, hp, atk, def);
        this.mp = mp;
    }
    
    
    public boolean skillHeal() {
        if(this.hp == this.hp_max) {
            System.out.println("*体力は満タンだ");
            return false;
        }else if(this.mp < 5) {
            System.out.println("*MPが足りない!");
            return false;
        }else if(this.hp + 30 > this.hp_max) {
            this.mp -= 5;
            System.out.println("*体力を全回復した");
            this.hp = this.hp_max;
            return true;
        }else {
            this.mp -= 5;
            System.out.println("*体力を30回復した");
            this.hp += 30;
            return true;
        }
    }
    public int getMp() {
        return this.mp;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public int getExp() {
        return this.exp;
    }
}