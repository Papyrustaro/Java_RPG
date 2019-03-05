package rpg;

/*職業: 魔法使い
 *特徴: 強力な魔法を持つ。ステータスは低め
 * */

class AllyWitch extends Ally{
    AllyWitch(String name, int hp, int mp, int atk, int def){
        super(name, hp, mp, atk, def);
    }
}