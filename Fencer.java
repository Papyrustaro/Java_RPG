package rpg;

class Fencer extends Ally{
    Fencer(String name, int hp, int mp, int atk, int def){
        super(name, hp, mp, atk, def);
    }
    
    @Override
    public int damaged(int hp, int atk, int def) {
        int damage;
        if(atk <= def) {
            damage = 1;
            this.hp--;
        }else if(hp >= atk - def) {
            damage = 2 * (atk - def);
            this.hp -= 2 * (atk - def);
        }else {
            damage = this.hp;
            this.hp = 0;
        }
        return damage;
    }
}