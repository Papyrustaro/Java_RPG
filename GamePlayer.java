package rpg;

import java.util.*;
import java.io.*;

class GamePlayer{
    public static void main(String[] args) {
        Fencer fencer = new Fencer("Frisk", 100, 30, 10, 5);
        Slaim slaim = new Slaim();
        
        System.out.println("*" + slaim.name + "が出現した!");
        while(!(isEnd(fencer, slaim))) {
            printStatus(fencer);
            
            switch(menu(fencer)) {
            case 1:
                fencer.attackNormal(fencer, slaim);
                break;
            case 2:
                if(!fencer.skillHeal()) continue; //スキルが発動できなかったら
                break;
            }
            
            if(isEnd(fencer, slaim)) break;
            
            slaim.skill(slaim, fencer, slaim.skill_num);
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
        while(input_menu <= 0 || 3 <= input_menu){
            System.out.println("1.通常攻撃  2.ヒール");
            try {
                input_menu = Integer.parseInt(br.readLine());
            }catch(Exception e) {
                System.out.println("数字を入力してください");
            }
        }
        return input_menu;
    }
}