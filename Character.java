package rpg;

class Character{
    protected String name;
    protected int hp;
    protected int atk;
    protected int def;
    
    Character(String name, int hp, int atk, int def){
        this.name = name; this.hp = hp; this.atk = atk; this.def = def;
    }
    
    public int damaged(int hp, int atk, int def) {
        int damage;
        if(atk <= def) {
            damage = 1;
            this.hp--;
        }else if(hp >= def - atk) {
            damage = def - atk;
            this.hp -= def - atk;
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
    
}