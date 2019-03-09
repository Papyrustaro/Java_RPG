package rpg;

class EnemyGoblin extends Enemy {
    protected int skill_num = 3;

    EnemyGoblin() {
        super("ゴブリン", 50, 12, 3, 30, 0, 5, 5, 5, "最近の趣味は虫取り", 4, 3);
    }

    // 通常攻撃
    public void skill1(Character target) {
        this.normalAttack(target);
    }

    // 武器を振りかざす
    public void skill2(Character target) {
        System.out.println(this.name + "は武器を振りかざしてきた!!");
        System.out.println(target.name + "は" + this.physicalAttack(target, 150) + "のダメージを受けた!");
    }

    // 連続攻撃
    public void skill3(Character target) {
        System.out.println(this.name + "の連続攻撃!");
        System.out.println(target.name + "は" + this.physicalAttack(target, 70) + "のダメージを受けた!");
        System.out.println(target.name + "は" + this.physicalAttack(target, 70) + "のダメージを受けた!");

    }
}