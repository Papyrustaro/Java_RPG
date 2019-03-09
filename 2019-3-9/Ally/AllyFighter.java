package rpg;


/*職業: 武闘家
 *特徴: スピードが速い、物理攻撃得意、回避率高め、防御低い。不器用。
 * 
 * */
class AllyFighter extends Ally{
    
    AllyFighter(String name){
        super(name, 70, 10, 38, 15, 27, 10, 10, 15, 5, "ファイター。素早さ、回避率が高く短期決戦型。");
    }
    AllyFighter(){
        super("ファイター", 70, 10, 38, 15, 27, 10, 10, 15, 5, "ファイター。素早さ、回避率が高く短期決戦型。");
    }
    
    @Override
    public void statusUp() {
        ;
    }
}