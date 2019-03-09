package rpg;

/*職業: 踊り子
 *特徴: 各種バフが豊富
 *hp.35, mp.25, atk.15, def.17, spd.26, sp_atk.15, sp_def.22, evade_rate.5, criti_rate.0
 * */

class AllyDancer extends Ally{
    AllyDancer(String name){
        super(name, 35, 25, 15, 17, 26, 15, 22, 5, 0, "ダンサー。支援系スキルが豊富。");
    }
    AllyDancer(){
        super("ダンサー", 35, 25, 15, 17, 26, 15, 22, 5, 0, "ダンサー。支援系スキルが豊富。");
    }
    
    @Override
    public void statusUp() {
        ;
    }
}