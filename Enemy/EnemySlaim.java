package rpg;

class EnemySlaim extends Enemy{
    EnemySlaim(){
        super("スライム", 20, 10, 7, 10, 0, 5, 5, 5, "どこにでもいる敵。たまにウホウホする", 100, 6);
    }
    
    //なにもしない
    public void skill1(Enemy enemy, Ally ally) {
        System.out.println(this.name + "はこちらの様子を伺っている");
    }
    
    //通常攻撃
    public void skill2(Enemy enemy, Ally ally) {
        enemy.attackNormal(enemy, ally);
    }
    
    //ウホウホしている
    public void skill3(Enemy enemy, Ally ally) {
        System.out.println(this.name + "はウホウホしている!!");
    }
    
    //強攻撃
    public void skill4(Enemy enemy, Ally ally) {
        System.out.println(this.name + "は、のしかかってきた!");
        System.out.println(ally.name + "は" + ally.damaged(ally.hp, enemy.atk * 3, ally.def) + "のダメージを受けた!");
    }
    
    //魔法攻撃
    public void skill5(Enemy enemy, Ally ally) {
        System.out.println(this.name + "の魔法攻撃!!");
        System.out.println(ally.name + "は" + ally.damaged(ally.hp, 30) + "のダメージを受けた!");
    }
    
    //うほうほ！！！
    public void skill6(Enemy enemy, Ally ally) {
        System.out.println(this.name + "のウホウホッ!!!!!!!!!!!!");
        System.out.println(ally.name + "は" + ally.damaged(ally.hp, 9999, ally.def) + "のダメージを受けたウホ!!");
    }
}