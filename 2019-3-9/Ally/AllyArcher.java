package rpg;


/*職業: アーチャー(AllyArcher)
 *特徴: スピードが速い、クリティカル率高い、状態異常や属性攻撃が器用、打たれ弱い
 *hp.35, mp.20, atk.30, def.15, spd.30, sp_atk.20, sp_def.12, evade_rate.10, criti_rate.10
 * */
class AllyArcher extends Ally{
    
    
    AllyArcher(String name){
        super(name, 35, 20, 30, 15, 30, 20, 12, 10, 10, "アーチャー。足が速く技も多彩だが打たれ弱い。");
    }
    AllyArcher(){
        super("アーチャー", 35, 20, 30, 15, 30, 20, 12, 10, 10, "アーチャー。足が速く技も多彩だが打たれ弱い。");
    }
    
    @Override
    public void statusUp() {
        ;
    }
}