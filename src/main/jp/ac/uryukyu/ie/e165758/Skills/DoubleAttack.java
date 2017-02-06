package jp.ac.uryukyu.ie.e165758.Skills;
import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;

/*ダメージ　-> 通常　×　2
 *消費MP -> 10
 *特殊効果 -> なし
 */
public class DoubleAttack extends Skill{
    //コンストラクタ
    public DoubleAttack(){
        setName("連続攻撃");
        setUseMP(10);
    }

    public void Excute(LivingThing m, LivingThing e) {
        printSkill(m);
        decreaseMP(m);
        int damage = (m.getATK() - 2) + (int) (Math.random() * 5); // damageはATKの+-2の範囲
        for (int i = 0; i < 2; i++) {
            e.damaged(damage);
        }
    }
}