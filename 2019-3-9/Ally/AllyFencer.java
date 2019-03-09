package rpg;


/*職業: 剣士(AllyFencer)
 *特徴: バランスのとれた職業。平均的
 *初期ステ: hp.50, mp.15, atk.30, def.20, spd.20, sp_atk.15, sp_def.15, evade_rate.5, criti_rate.5
 * 
 * 
 * 
 * */
class AllyFencer extends Ally implements AllyInterface{
    //String[] skill_name = {"連続切り", "ヒール"};
    //String[] skill_description = {"2回連続攻撃", "HPを30回復する"};
    //int[] skill_value = {80, 30}; //技の威力
    //int[] skill_mp = {3, 5}; //消費mp
    
    
    AllyFencer(String name){
        super(name, 50, 15, 30, 20, 20, 15, 15, 5, 5, "フェンサー。バランスの取れた職業。");
        this.skill_name = new String[]{"連続切り", "ヒール"};
        this.skill_description = new String[]{"2回連続攻撃", "HPを30回復する"};
        this.skill_value = new int[]{80, 30};
        this.skill_mp = new int[]{3, 5};
    }
    AllyFencer(){
        super("フェンサー", 50, 15, 30, 20, 20, 15, 15, 5, 5, "フェンサー。バランスの取れた職業。");
    }
    
    //レベルアップ時のステータスアップ
    @Override
    public void statusUp() {
        statusUp(10, 3, 5, 4, 4, 3, 3);
    }
    
    public void skill0(Character target) {
        System.out.println(this.name + "は連続切りをはなった!!");
        System.out.println(target.name + "に" + this.physicalAttack(target, 80) + "のダメージ!");
        System.out.println(target.name + "に" + this.physicalAttack(target, 80) + "のダメージ!");
    }
    
    public void skill1(Character target) {
        System.out.println(this.name + "はヒールを発動した!");
        System.out.println(this.name + "はHPを" + this.recoverHp(30) + "回復した!");
    }
}