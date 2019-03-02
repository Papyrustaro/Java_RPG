package rpg;

import java.util.*;

class GamePlayer{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fencer fencer = new Fencer("Frisk", 100, 30, 10, 5);
        Enemy enemy = new Enemy("Slaim", 30, 3, 3);
        
        
        fencer.hp -= 30;
        
        System.out.println("*" + enemy.name + "が出現した!");
        printStatus(fencer);
        while(!(isEnd(fencer, enemy))) {
            printStatus(fencer);
            
            switch(menu(fencer, sc)) {
            case 1:
                attackNormal(fencer, enemy);
                break;
            case 2:
                if(!fencer.skillHeal()) continue; //スキルが発動できなかったら
                break;
            }
            
            if(isEnd(fencer, enemy)) break;
            
            attackNormal(enemy, fencer);
        }
        
        sc.close();
    }
    
    public static void printStatus(Ally ally) {
        System.out.println("***" + ally.name + "**********");
        System.out.println("HP: " + ally.hp + "   MP: " + ally.mp);
        System.out.println("******************");
    }
    
    public static void attackNormal(Character attacker, Character defender) {
        System.out.println(attacker.name + "の通常攻撃");
        System.out.println(defender.name + "に" + defender.damaged(defender.hp, attacker.atk, defender.def) + "のダメージ");
    }
    
    public static boolean isEnd(Ally ally, Enemy enemy) {
        if(ally.hp <= 0) {
            System.out.println(ally.name + "は倒れた");
            System.out.println(ally.name + "は敗北した");
            return true;
        }else if(enemy.hp <= 0) {
            System.out.println(enemy.name + "は倒れた");
            System.out.println(ally.name + "の勝利!!");
            return true;
        }
        return false;
    }
    
    public static int menu(Ally ally, Scanner sc) {
        int input_menu = 0;
        System.out.println(ally.name + "はどうする?");
            while(input_menu <= 0 || 3 <= input_menu){
                System.out.println("1.通常攻撃  2.ヒール");
                input_menu = Integer.parseInt(sc.nextLine());
            }
        return input_menu;
    }
}