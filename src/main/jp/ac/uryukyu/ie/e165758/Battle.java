package jp.ac.uryukyu.ie.e165758;

public class Battle {
    int turn;

    Battle(LivingThing a , LivingThing b){
        turn = 1;
        System.out.println("戦闘が開始しました。");
        while(true){
            System.out.println(turn + "ターン目");
            printHP(a, b);
            a.attack(b);
            if (b.isDead() == 0) break;
            b.attack(a);
            if (a.isDead() == 0) break;
            turn += 1;
            System.out.println(" ");
        }
        System.out.println("戦闘が終了しました。");
    }

    void printHP(LivingThing a, LivingThing b){
        System.out.println(a.name + "のHP : " + a.HP);
        System.out.println(b.name + "のHP : " + b.HP);
    }
}
