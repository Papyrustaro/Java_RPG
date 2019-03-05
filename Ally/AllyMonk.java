package rpg;


/*職業: 武闘家
 *特徴: スピードが速い、物理攻撃得意、回避率高め、防御低い。不器用。
 * 
 * */
class AllyMonk extends Ally{
    
    
    AllyMonk(String name, int hp, int mp, int atk, int def){
        super(name, hp, mp, atk, def);
    }
}