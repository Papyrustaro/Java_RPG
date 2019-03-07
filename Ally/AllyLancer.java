package rpg;


/*職業: ランサー
 *特徴: スピードが襲い。耐久力が高い。
 * 
 * */
class AllyLancer extends Ally{
    
    AllyLancer(String name){
        super(name, 90, 12, 30, 30, 10, 15, 25, 0, 0, "ランサー。足は遅いが一撃は強力。");
    }
    AllyLancer(){
        super("ランサー", 90, 12, 30, 30, 10, 15, 25, 0, 0, "ランサー。足は遅いが一撃は強力。");
    }
}