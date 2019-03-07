package rpg;


/*職業: 僧侶
 *特徴: 神への信仰から様々な恩恵を受ける。（2ターンで１攻撃など）
 * 
 * */
class AllyMonk extends Ally{
    
    AllyMonk(String name){
        super(name, 30, 30, 10, 15, 15, 30, 35, 5, 10, "モンク。神への信仰から様々な恩恵を受ける。");
    }
    AllyMonk(){
        super("モンク", 30, 30, 10, 15, 15, 30, 35, 5, 10, "モンク。神への信仰から様々な恩恵を受ける。");
    }
}