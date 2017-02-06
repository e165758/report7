package jp.ac.uryukyu.ie.e165758.Skills;

import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;
import jp.ac.uryukyu.ie.e165758.SomeOption;
/*ダメージ　-> 通常
 *消費MP ->　15
 *特殊効果 -> 自分のATKを+5する。
 */
public class JellyAttack extends Skill{
    public JellyAttack(){
        setName("ねばねばアタック");
        setUseMP(15);
    }

    public void Excute(LivingThing m, LivingThing e) {
        printSkill(m);
        decreaseMP(m);
        m.setATK(m.getATK() + 5);
        SomeOption.print(m.getName() + "は攻撃力が5上がった!!!");
        int damage = (m.getATK() - 2) + (int) (Math.random() * 5); // damageはATKの+-2の範囲
        e.damaged(damage);
    }
}
