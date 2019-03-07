package rpg;

/*職業: ガーディアン
 *特徴: 防御系スキル多彩。足は遅い。
 * */

class AllyGurdian extends Ally{
    AllyGurdian(String name){
        super(name, 100, 12, 10, 40, 10, 5, 40, 0, 0, "ガーディアン。守りに徹した職業。");
    }
    AllyGurdian(){
        super("ガーディアン", 100, 12, 10, 40, 10, 5, 40, 0, 0, "ガーディアン。守りに徹した職業。");
    }
}