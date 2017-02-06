package jp.ac.uryukyu.ie.e165758.Skills;
import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;
import jp.ac.uryukyu.ie.e165758.SomeOption;
/*ダメージ　->0
 *消費MP ->0
 *特殊効果 -> 自分のHPの1/4 回復する
 */
public class Rest extends Skill{
    public Rest(){
        setName("休む");
        setUseMP(10);
    }

    public void Excute(LivingThing m, LivingThing e) {
        printSkill(m);
        decreaseMP(m);
        int amount = (int)(m.getMHP()/4);
        SomeOption.print(m.getName() + "は" + amount + "体力を回復した!!!");
        m.setHP(m.getHP() + amount);
        m.HPOver();
    }
}
