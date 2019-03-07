package rpg;

class EnemyGoblin extends Enemy{
    protected int skill_num = 3;
    
    EnemyGoblin(){
        super("ゴブリン", 30, 12, 3, 10, 0, 5, 5, 5, "最近の趣味は虫取り", 4, 3);
    }
    
    //通常攻撃
    public void skill1(Enemy enemy, Ally ally) {
        enemy.attackNormal(enemy, ally);   
    }
    
    //武器を振りかざす
    public void skill2(Enemy enemy, Ally ally) {
        System.out.println(enemy.name + "は武器を振りかざしてきた!!");
        System.out.println(ally.name + "は" + ally.damaged(ally.hp, enemy.atk * 2, ally.def) + "のダメージを受けた!");
    }
    
    //連続攻撃
    public void skill3(Enemy enemy, Ally ally) {
        System.out.println(enemy.name + "の連続攻撃!");
        System.out.println(ally.name + "は" + ally.damaged(ally.hp, enemy.atk / 2, ally.def) + "のダメージを受けた!");
        System.out.println(ally.name + "は" + ally.damaged(ally.hp, enemy.atk / 2, ally.def) + "のダメージを受けた!");
        
    }
}