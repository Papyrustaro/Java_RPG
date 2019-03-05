package rpg;


/*職業: アーチャー(AllyArcher)
 *特徴: スピードが速い、クリティカル率高い、状態異常や属性攻撃が器用、打たれ弱い
 * 
 * */
class AllyArcher extends Ally{
    
    
    AllyArcher(String name, int hp, int mp, int atk, int def){
        super(name, hp, mp, atk, def);
    }
}