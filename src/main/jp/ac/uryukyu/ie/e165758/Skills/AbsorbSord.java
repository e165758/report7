package jp.ac.uryukyu.ie.e165758.Skills;
import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;
import jp.ac.uryukyu.ie.e165758.SomeOption;

/*ダメージ　-> 通常
 *消費MP -> 15
 *特殊効果 -> クリティカル判定前のダメージ分回復
 */
public class AbsorbSord extends Skill{
    //コンストラクタ
    public AbsorbSord(){
        setName("吸血剣");
        setUseMP(15);
    }

    public void Excute(LivingThing m, LivingThing e){
        printSkill(m);
        decreaseMP(m);
        int damage = (m.getATK() - 2) + (int)(Math.random()*5);
        int temp = e.getHP();
        e.damaged(damage); //攻撃する。
        if (temp > e.getHP()){ //攻撃が当たっていたら、回復する。
            SomeOption.print(m.getName() + "は" + damage + "回復した。");
            m.setHP( m.getHP() + damage );
            m.HPOver(); // HPの最大値を超えないように調整。
        }
    }
}