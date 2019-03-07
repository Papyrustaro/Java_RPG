package rpg;


/*職業: 剣士(AllyFencer)
 *特徴: バランスのとれた職業。平均的
 *初期ステ: hp.50, mp.15, atk.30, def.20, spd.20, sp_atk.15, sp_def.15, evade_rate.5, criti_rate.5
 * 
 * 
 * 
 * */
class AllyFencer extends Ally{
    AllyFencer(String name){
        super(name, 50, 15, 30, 20, 20, 15, 15, 5, 5, "フェンサー。バランスの取れた職業。");
    }
    AllyFencer(){
        super("フェンサー", 50, 15, 30, 20, 20, 15, 15, 5, 5, "フェンサー。バランスの取れた職業。");
    }
}