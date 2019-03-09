package rpg;

import java.util.*;
import java.io.*;

class GamePlayer{
    public static void main(String[] args) {
        AllyFencer ally = new AllyFencer("Frisk");
        inputAllyName(ally);
        
        while(ally.hp > 0) {
            int ally_turn = 1000;
            int enemy_turn = 1000;
            
            Enemy enemy = selectEnemy();
            System.out.println("*" + enemy.name + "が出現した!");
            
            boolean flag = true; //どちらかのターンがきたかどうか
            while(flag) {
               ally_turn -= ally.spd;
               enemy_turn -= enemy.spd;
               if(ally_turn <= 0) {
                   ally_turn += 1000;
                   allyTurn(ally, enemy);
                   
                   if(battleEnd(ally, enemy)) break;
               }if(enemy_turn <= 0){
                   enemy_turn += 1000;
                   enemy.skill(ally, enemy.skill_num);
                   
                   if(battleEnd(ally, enemy)) break;
               }
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
    
    public static boolean battleEnd(Ally ally, Enemy enemy) { //勝敗決まったらtrue
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
    
    public static void allyTurn(Ally ally, Enemy enemy) {
        
        boolean flag;
        do {
            flag = false;
            printStatus(ally);
            switch(menu(ally)) {
            case 1:
                ally.normalAttack(enemy);
                break;
            case 2:
                if(!allySkill(ally, enemy)) flag = true; //スキルが発動できなかったら
                break;
            case 3:
                enemy.printInfo();
                break;
            }
        }while(flag);
    }
    
    public static boolean allySkill(Ally ally, Enemy enemy) {
        int select = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int skill_num = ally.level / 5 + 1; //5レベルごとにスキルひとつ覚える
        
        do {
            System.out.println("*************************");
            for(int i = 0; i < skill_num; i++) {
                System.out.println(i + "." + ally.skill_name[i]);
            }
            System.out.println("*************************");
            
            System.out.println("*使うスキルを選択してください");
            try {
                select = Integer.parseInt(br.readLine());
            }catch(Exception e) {
                System.out.println("数字を入力してください");
            }
        }while(select < 0 || skill_num <= select);
        
        if(ally.mp < ally.skill_mp[select]) {
            System.out.println("*MPが足りない!!");
            return false;
        }else { //以下の部分もう少しスマートにしたい
            if(select == 0) {
                ally.mp -= ally.skill_mp[0];
                ally.skill0(enemy);
            }else if(select == 1) {
                ally.mp -= ally.skill_mp[1];
                ally.skill1(enemy);
            }
            return true;
        }
        
    }
}