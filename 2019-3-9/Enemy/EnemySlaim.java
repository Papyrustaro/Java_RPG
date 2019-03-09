package rpg;

class EnemySlaim extends Enemy{
    EnemySlaim(){
        super("スライム", 50, 10, 7, 10, 5, 5, 5, 5, "どこにでもいる敵。たまにウホウホする", 1000, 6);
    }
    
    //なにもしない
    public void skill1(Character target) {
        System.out.println(this.name + "はこちらの様子を伺っている");
    }
    
    //通常攻撃
    public void skill2(Character target) {
        this.normalAttack(target);
    }
    
    //ウホウホしている
    public void skill3(Character target) {
        System.out.println(this.name + "はウホウホしている!!");
    }
    
    //強攻撃
    public void skill4(Character target) {
        System.out.println(this.name + "は、のしかかってきた!");
        System.out.println(target.name + "は" + this.physicalAttack(target, 200) + "のダメージを受けた!");
    }
    
    //魔法攻撃
    public void skill5(Character target) {
        System.out.println(this.name + "の魔法攻撃!!");
        System.out.println(target.name + "は" + this.specialAttack(target, 100) + "のダメージを受けた!");
    }
    
    //うほうほ！！！
    public void skill6(Character target) {
        System.out.println(this.name + "のウホウホッ!!!!!!!!!!!!");
        System.out.println(target.name + "は" + this.damaged(target, 9999) + "のダメージを受けたウホ!!");
    }
}