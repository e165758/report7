package jp.ac.uryukyu.ie.e165758;

/*　戦闘中は下のように表示される。下は入力待ち状態。
    戦闘が開始しました。
    1ターン目
    ゆうしゃ HP: 110/110 MP: 38/38
    スライム HP:10000/10000 MP:38/38
    コマンド(0, 1, 2)を入力してください。
    0 -> 攻撃 MP0消費
    1 -> 吸血劍 MP15消費
    2 -> 連続攻撃 MP10消費
*/

import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;

public class Battle {
    Battle(LivingThing a , LivingThing b){
        int a_command;
        int b_command;
        int turn = 1;
        System.out.println("戦闘が開始しました。");
        while(true){
            System.out.println(turn + "ターン目");
            printHP_MP(a, b);
            a_command = a.inputCommand();
            a.Action(b, a_command);
            if (b.isDead() == 0) break;
            b_command = b.inputCommand();
            b.Action(a, b_command);
            if (a.isDead() == 0) break;
            turn += 1;
            System.out.println(" ");
        }
        System.out.println("戦闘が終了しました。");
    }

    void printHP_MP(LivingThing a, LivingThing b){
        System.out.println(a.getName() + " HP: " + a.getHP() + "/" + a.getMHP() +
                                        " MP: " + a.getMP() + "/" + a.getMMP());
        System.out.println(b.getName() + " HP:" + b.getHP() + "/" + b.getMHP() +
                                        " MP:" + b.getMP() + "/" + b.getMMP());
    }
}