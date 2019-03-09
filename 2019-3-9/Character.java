package rpg;

abstract class Character{
    protected String name;
    protected int hp, atk, def, spd, sp_atk, sp_def;
    protected int evade_rate; //回避率
    protected int criti_rate; //急所率
    protected String description; //紹介文
    protected boolean live; //生きているかどうか
    
    protected int hp_max;
    protected int atk_max;
    protected int def_max;
    protected int spd_max;
    protected int sp_atk_max;
    protected int sp_def_max;
    protected int evade_rate_max;
    protected int criti_rate_max;
    
    
    Character(String name, int hp, int atk, int def, int spd, int sp_atk, int sp_def, int evade_rate, int criti_rate, String description){
        this.name = name; this.hp = hp; this.atk = atk; this.def = def; this.spd = spd; this.sp_atk = sp_atk; this.sp_def = sp_def; this.evade_rate = evade_rate;
        this.criti_rate = criti_rate; this.description = description; this.live = true;
        
        this.hp_max = hp; this.atk_max = atk; this.def_max = def; this.spd_max = spd; this.sp_atk_max = sp_atk;
        this.sp_def_max = sp_def; this.evade_rate_max = evade_rate; this.criti_rate_max = criti_rate;
    }
    
    //最大ダメージ<=HP
    public int physicalAttack(Character target, int power) { //powerは100で等倍
        int damage = (this.atk * power / 100) - target.def;
        
        if(damage <= 0) { //1ダメージしか与えられない
            damage = 1;
        }
        if(target.hp < damage) { //deferが倒れるとき
            damage = target.hp;
        }
        target.hp -= damage;
        return damage;
    }
    
    public int specialAttack(Character target, int power) { //powerは100で等倍
        int damage = (this.sp_atk * power / 100) - target.sp_def;
        
        if(damage <= 0) { //1ダメージしか与えられない
            damage = 1;
        }
        if(target.hp < damage) { //deferが倒れるとき
            damage = target.hp;
        }
        target.hp -= damage;
        return damage;
    }
    
    public int damaged(Character target, int damage_point) { //固定ダメージ
        if(target.hp >= damage_point) {
            target.hp -= damage_point;
        }else {
            damage_point = target.hp;
            target.hp = 0;
        }
        return damage_point;
    }
    
    public int recoverHp(int recovery_point) {
        int recovery;
        if(this.hp == this.hp_max) {
            recovery = 0;
        }else if(this.hp + recovery_point > this.hp_max) {
            recovery = this.hp_max - this.hp;
            this.hp = this.hp_max;
        }else {
            recovery = recovery_point;
        }
        return recovery;
    }
    
    public int recoverHp(Character target, int recovery_point) {
        int recovery;
        if(target.hp == target.hp_max) {
            recovery = 0;
        }else if(target.hp + recovery_point > target.hp_max) {
            recovery = target.hp_max - target.hp;
            target.hp = target.hp_max;
        }else {
            recovery = recovery_point;
        }
        return recovery;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getHp() {
        return this.hp;
    }
    
    public int getAtk() {
        return this.atk;
    }
    
    public int getDef() {
        return this.def;
    }
    
    public void normalAttack(Character target) {
        System.out.println(this.name + "の通常攻撃!!");
        System.out.println(target.name + "に" + this.physicalAttack(target, 100) + "のダメージ");
    }
    
}