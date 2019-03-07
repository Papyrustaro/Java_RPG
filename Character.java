package rpg;

class Character{
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
    
    public int damaged(int hp, int atk, int def) {
        int damage;
        if(atk <= def) { //防御力＞攻撃力
            damage = 1;
            this.hp--;
        }else if(hp >= atk - def) {
            damage = atk - def;
            this.hp -= atk - def;
        }else {
            damage = hp;
            this.hp = 0;
        }
        return damage;
    }
    
    public int damaged(int hp, int damage_point) {
        if(hp >= damage_point) {
            this.hp -= damage_point;
        }else {
            damage_point = hp;
            this.hp = 0;
        }
        return damage_point;
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
    
    public void attackNormal(Character atker, Character defer) {
        System.out.println(atker.name + "の通常攻撃!!");
        System.out.println(defer.name + "に" + defer.damaged(defer.hp, atker.atk, defer.def) + "のダメージ");
    }
    
}