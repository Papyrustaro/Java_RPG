package rpg;

class Ally extends Character{
    protected int mp;
    protected int mp_max;
    protected int level;
    protected int exp; //総獲得exp
    protected int next_exp; //次のレベルアップまで必要なexp
    
    Ally(String name, int hp, int mp, int atk, int def, int spd, int sp_atk, int sp_def, int evade_rate, int criti_rate, String description){
        super(name, hp, atk, def, spd, sp_atk, sp_def, evade_rate, criti_rate, description);
        this.mp = mp; this.level = 1; this.exp = 0; this.next_exp = 32; this.mp_max = mp;
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
    
    public void levelUp(Enemy enemy) {
        System.out.println("*" + this.name + "のレベルが上がった!");
        this.level++;
        this.next_exp = (this.exp + this.next_exp) * 2;
        System.out.println("*" + this.name + "は" + this.level + "レベルになった!");
    }
    
    public void getExp(Enemy enemy) {
        int get_exp = enemy.exp;
        
        System.out.println("*" + this.name + "は" + get_exp + "の経験値を獲得!");
        while(get_exp > 0) {
            if(this.next_exp <= get_exp) { //レベルアップするとき
                get_exp -= this.next_exp;
                levelUp(enemy);
            }else {
                next_exp -= get_exp;
                get_exp = 0;
            }
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
    
    public void setName(String name) {
        this.name = name;
    }
}