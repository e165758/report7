package jp.ac.uryukyu.ie.e165758.Skills;

import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;
import jp.ac.uryukyu.ie.e165758.SomeOption;

/*スキル名 -> ???  Nameのこと
 *ダメージ　-> ???  Excuteで決める
 *消費MP -> ???  useMPのこと
 *特殊効果 -> ???  Excuteで決める
 */
public abstract class Skill {
    private String Name;
    private int useMP;

    //スキル使用での効果
    public abstract void Excute(LivingThing m, LivingThing e);

    public String getName(){return this.Name;}
    public void setName(String name){this.Name = name;}

    public int getUseMP(){return this.useMP;}
    public void setUseMP(int n){this.useMP = n;}

    // "◯◯の△△△!!!" と出力
    public void printSkill(LivingThing m){SomeOption.print(m.getName() + "の" + this.Name + "!!!");}

    // スキルを使った時に、MPを減らす。
    public void decreaseMP(LivingThing m){m.setMP(m.getMP() - this.useMP);}
}