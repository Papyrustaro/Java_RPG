package rpg;

import java.util.*;
import java.io.*;

class GamePlayer{
    public static void main(String[] args) {
        AllyFencer ally = new AllyFencer("Frisk");
        inputAllyName(ally);
        
        while(ally.hp > 0) {
            Enemy enemy = selectEnemy();
            System.out.println("*" + enemy.name + "が出現した!");
            
            while(!(isEnd(ally, enemy))) {
                printStatus(ally);
                
                switch(menu(ally)) {
                case 1:
                    ally.attackNormal(ally, enemy);
                    break;
                case 2:
                    if(!ally.skillHeal()) continue; //スキルが発動できなかったら
                    break;
                case 3:
                    enemy.printInfo();
                    break;
                }
                
                if(isEnd(ally, enemy)) break;
                enemy.skill(enemy, ally, enemy.skill_num);
            }
        }
        
    }
    
    public static Enemy selectEnemy() {
        Random random = new Random();
        int random_num = random.nextInt(2) + 1;
        switch(random_num) {
        case 1:
            return (Enemy)(new EnemySlaim());
        case 2:
            return (Enemy)(new EnemyGoblin());
        }
        
        return (Enemy)(new EnemySlaim());
    }
    
    public static void inputAllyName(Ally ally) {
        String input_name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("主人公の名前を入力してください");
        try {
            input_name = br.readLine();
            ally.setName(input_name);
        }catch(Exception e) {
            System.out.println("入力が正しくありません");
        }
    }
    
    public static void printStatus(Ally ally) {
        System.out.println("***" + ally.name + "************");
        System.out.println("LV: " + ally.level + "  HP: " + ally.hp + "   MP: " + ally.mp);
        System.out.println("********************");
    }
    
    public static boolean isEnd(Ally ally, Enemy enemy) {
        if(ally.hp <= 0) {
            System.out.println(ally.name + "は倒れた");
            System.out.println(ally.name + "は敗北した");
            return true;
        }else if(enemy.hp <= 0) {
            System.out.println(enemy.name + "は倒れた");
            System.out.println(ally.name + "の勝利!!");
            ally.getExp(enemy);
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