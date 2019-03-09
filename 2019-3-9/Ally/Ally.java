package rpg;

abstract class Ally extends Character{
    protected int mp;
    protected int mp_max;
    protected int level;
    protected long exp; //総獲得exp
    protected long next_exp; //次のレベルアップまで必要なexp
    protected String[] skill_name;
    protected String[] skill_description;
    protected int[] skill_value; //技の威力
    protected int[] skill_mp; //消費mp
    
    Ally(String name, int hp, int mp, int atk, int def, int spd, int sp_atk, int sp_def, int evade_rate, int criti_rate, String description){
        super(name, hp, atk, def, spd, sp_atk, sp_def, evade_rate, criti_rate, description);
        this.mp = mp; this.level = 1; this.exp = 0; this.next_exp = 32; this.mp_max = mp;
        
        
    }
    
    public void levelUp(Enemy enemy) {
        System.out.println("*" + this.name + "のレベルが上がった!");
        this.level++;
        this.next_exp = this.exp * 2;
        System.out.println("*" + this.name + "は" + this.level + "レベルになった!");
        statusUp();
        //System.out.println("*次のレベルアップまであと" + this.next_exp);
    }
    
    public void getExp(Enemy enemy) {
        int get_exp = enemy.exp;
        
        System.out.println("*" + this.name + "は" + get_exp + "の経験値を獲得!");
        while(get_exp > 0) {
            if(this.next_exp <= get_exp) { //レベルアップするとき
                get_exp -= this.next_exp;
                this.exp += this.next_exp;
                levelUp(enemy);
            }else {
                this.next_exp -= get_exp;
                this.exp += get_exp;
                get_exp = 0;
            }
        }
        //System.out.println("*総獲得経験値" + this.exp);
    }
    
    //レベルアップ時のステータスアップ（引数は上昇値)
    public void statusUp(int hp, int mp, int atk, int def, int spd, int sp_atk, int sp_def) {
        this.hp_max += hp; this.mp_max += mp; this.atk_max += atk; this.def_max += def;
        this.spd_max += spd; this.sp_atk_max += sp_atk; this.sp_def_max += sp_def;
        
        this.hp += hp; this.mp += mp; this.atk += atk; this.def += def;
        this.spd += spd; this.sp_atk += sp_atk; this.sp_atk += sp_atk;
        
        
        System.out.println("***" + this.name + "***************");
        System.out.println("HP:"+this.hp_max+"(+"+hp+") "+"MP:"+this.mp_max+"(+"+mp+") "+"ATK:"+this.atk_max+"(+"+atk+")");
        System.out.println("DEF:"+this.def_max+"(+"+def+") "+"SPD:"+this.spd_max+"(+"+spd+") "+"SATK:"+this.sp_atk_max+"(+"+sp_atk+")");
        System.out.println("SDEF:"+this.sp_def_max+"(+"+sp_def+") ");
        
        if(this.level % 10 == 0) {
            this.evade_rate_max++; this.criti_rate_max++;
            System.out.println("回避率:" + this.evade_rate_max + "(+1)");
            System.out.println("会心率:" + this.criti_rate_max + "(+1)");
        }
        System.out.println("****************************");
    }
    
    abstract public void statusUp();
    abstract public void skill0(Character target);
    abstract public void skill1(Character target);
    
    public int getMp() {
        return this.mp;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public long getExp() {
        return this.exp;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}