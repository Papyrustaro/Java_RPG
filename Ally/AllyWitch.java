package rpg;

/*職業: 魔法使い
 *特徴: 強力な魔法を持つ。ステータスは低め
 * */

class AllyWitch extends Ally{
    
    AllyWitch(String name){
        super(name, 30, 45, 5, 10, 13, 50, 50, 0, 0, "ウィッチ。強力な魔法を放つ。");
    }
    
    AllyWitch(){
        super("ウィッチ", 30, 45, 5, 10, 13, 50, 50, 0, 0, "ウィッチ。強力な魔法を放つ。");
    }
}