package jp.ac.uryukyu.ie.e165758.LivingThings;
import jp.ac.uryukyu.ie.e165758.Skills.*;
import jp.ac.uryukyu.ie.e165758.SomeOption;

//戦闘するオブジェクト
public abstract class LivingThing {
    String name;
    private int LV; //レベル
    private int HP; //体力
    private int MHP; //体力の最大値。回復する時の歯止め役。
    private int MP; //魔力。スキルを使用する際に消費する。
    private int MMP; //魔力の最大値。回復する時の歯止め役。
    private int ATK; //攻撃力
    private int LUK; //回避率
    private Skill skills[] = {new Nothing(), new Nothing(), new Nothing() };//スキルは各職業ごとで決める。

    //コンストラクタ
    public LivingThing(String name, int lv){ //職業に応じて、setSkills を追加してスキルを変更してください。
        this.name = name;
        this.LV = lv;
        this.HP = 10*lv + 30;
        this.MHP = this.HP;
        this.MP = 10*lv + 20;
        this.MMP = this.MP;
        this.ATK = 3*lv + 5;
        this.LUK = 3*lv;
    }

    //ここから下はメソッド
    //getter と setter
    public String getName(){return this.name;}
    public void setName(String str){this.name = str;}

    public int getLV(){return this.LV;}
    public void setLV(int lv){this.LV = lv;}

    public int getHP(){return this.HP;}
    public void setHP(int hp){this.HP = hp;}

    public int getMHP(){return this.MHP;}
    public void setMHP(int mhp){this.MHP = mhp;}

    public int getMP(){return this.MP;}
    public void setMP(int mp){this.MP = mp;}

    public int getMMP(){return this.MMP;}
    public void setMMP(int mmp){this.MMP = mmp;}

    public int getATK(){return this.ATK;}
    public void setATK(int atk){this.ATK = atk;}

    public int getLUK(){return this.LUK;}
    public void setLUK(int luk){this.LUK = luk;}

    public Skill[] getSkills(){return this.skills;}
    public void setSkills(Skill skill_0, Skill skill_1, Skill skill_2) {
        this.skills[0] = skill_0;
        this.skills[1] = skill_1;
        this.skills[2] = skill_2;
    }

    //主人公、モンスターの行動を処理するメソッド。
    public abstract int inputCommand(); //Heroは標準入力で、Enemyはランダムで選択。
    public void Action(LivingThing e, int command){
        switch (command) {
            case 0:
                this.getSkills()[0].Excute(this, e); //this は 自分自身(LivingThing)
                break;
            case 1:
                this.getSkills()[1].Excute(this, e); //this は 自分自身(LivingThing)
                break;
            case 2:
                this.getSkills()[2].Excute(this, e); //this は 自分自身(LivingThing)
                break;
        }
    }

    //ダメージを受ける処理。
    public void damaged(int damage) {
        if (avoid() != 0){ //攻撃が当たった場合
            if (critical() == 0) damage *= 2; //クリティカル判定
            SomeOption.print(this.name + "は" + damage + "のダメージを受けた。");
            this.HP -=  damage;
        }
    }

    //LUK依存のランダムでクリティカル判定。発動するなら戻り値は0。
    public int critical(){
        if ((int)(Math.random()*100) + this.LUK >= 90) {
            SomeOption.print("!!!クリティカル発動!!!");
            return 0;
        }else return 1;
    }

    //LUK依存のランダムで攻撃を避けるか判定。避けるなら戻り値は0。
    public int avoid(){
        int n = (int)(Math.random()*100); //0~99
        n += this.LUK;
        if (n >= 90) {
            SomeOption.print(this.name + "は攻撃を回避した!");
            return 0;
        } else return 1;
    }

    // 戦闘不能を確認する。
    public int isDead(){
        if(this.HP <= 0){
            SomeOption.print(this.name + "は倒れた。");
            return 0;
        }
        else return 1;
    }

    //回復でHPがMHPを超えないようにする。
    public void HPOver(){
        if (this.HP > this.MHP) this.HP = this.MHP;
    }
}