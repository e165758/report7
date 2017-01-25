package jp.ac.uryukyu.ie.e165758;

/**
 * Created by e165758 on 2017/01/25.
 */
public class LivingThing {
    String name;
    int LV; //レベル
    int HP; //体力
    int ATK; //攻撃力
    int LUK; //回避率

    LivingThing(String name, int n){ //職業に応じて、Overrideして下さい。
        this.name = name;
        this.LV = n;
        this.HP = 20*n;
        this.ATK = 3*n;
        this.LUK = 1*n;
    }

    void attack(LivingThing e){ //ダメージを与える。
        System.out.println(this.name + "の攻撃!");
        int damage = (this.ATK - 2) + (int)(Math.random()*5); // damageはATKの+-2の範囲
        e.damaged(damage);
    }
    void damaged(int damage) { //ダメージを受ける。
        if (avoid() != 0){ //回避しない場合
            if (critical() == 0) damage *= 2; //クリティカル判定
            System.out.println(this.name + "は" + damage + "のダメージを受けた。");
            this.HP -= damage;
        }
    }
    int critical(){ //5分の1の確率でダメージを2倍にする。 発動するなら戻り値は0。
        if ((int)(Math.random()*5) == 0) {
            System.out.println("!!!クリティカル発動!!!");
            return 0;
        }else return 1;
    }

    int avoid(){ //LUK依存のランダムで攻撃を避けるか決める。避けるなら戻り値は0。
        int n = (int)(Math.random()*100); //0~99
        n += this.LUK;
        if (n >= 90) {
            System.out.println(this.name + "は攻撃を回避した!");
            return 0;
        } else return 1;
    }

    int isDead(){// 戦闘不能を確認する。
        if(this.HP <= 0){
            System.out.println(this.name + "は倒れた。");
            return 0;
        }
        else return 1;
    }
}
