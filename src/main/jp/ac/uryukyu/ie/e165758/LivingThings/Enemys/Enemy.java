package jp.ac.uryukyu.ie.e165758.LivingThings.Enemys;

import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;
import jp.ac.uryukyu.ie.e165758.Skills.Skill;

abstract public class Enemy extends LivingThing {
    //コンストラクタ
    public Enemy(String name, int lv){super(name, lv);}
    //commandはランダムで取得。
    public int inputCommand(){
        int command = (int)(Math.random()*3); //0~2
        Skill skill = this.getSkills()[command];
        if (skill.getUseMP() <= this.getMP()) return command;
        else return 0; //通常攻撃を選択する
    }
}