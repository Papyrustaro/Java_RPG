package rpg;

import java.util.*;
import java.io.*;

class GamePlayer{
    public static void main(String[] args) {
        Fencer fencer = new Fencer("Frisk", 100, 30, 10, 5);
        Enemy enemy = new Goblin();
        
        Random random = new Random();
        int random_enemy = random.nextInt(2) + 1;
        switch(random_enemy) {
        case 1:
            enemy = new Slaim();
            break;
        case 2:
            enemy = new Goblin();
            break;
        }
        
        System.out.println("*" + enemy.name + "が出現した!");
        while(!(isEnd(fencer, enemy))) {
            printStatus(fencer);
            
            switch(menu(fencer)) {
            case 1:
                fencer.attackNormal(fencer, enemy);
                break;
            case 2:
                if(!fencer.skillHeal()) continue; //スキルが発動できなかったら
                break;
            case 3:
                enemy.printInfo(enemy);
                break;
            }
            
            if(isEnd(fencer, enemy)) break;
            
            enemy.skill(enemy, fencer, enemy.skill_num);
        }
        
    }
    
    public static void printStatus(Ally ally) {
        System.out.println("***" + ally.name + "**********");
        System.out.println("HP: " + ally.hp + "   MP: " + ally.mp);
        System.out.println("******************");
    }
    
    /*public static void attackNormal(Character attacker, Character defender) {
        System.out.println(attacker.name + "の通常攻撃");
        System.out.println(defender.name + "に" + defender.damaged(defender.hp, attacker.atk, defender.def) + "のダメージ");
    }*/
    
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
    
    public static int menu(Ally ally) {
        int input_menu = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(ally.name + "はどうする?");
        while(input_menu <= 0 || 4 <= input_menu){
            System.out.println("1.通常攻撃  2.ヒール 3.調べる");
            try {
                input_menu = Integer.parseInt(br.readLine());
            }catch(Exception e) {
                System.out.println("数字を入力してください");
            }
        }
        return input_menu;
    }
}