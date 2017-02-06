package jp.ac.uryukyu.ie.e165758.Skills;
import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;

/*ダメージ　-> 通常
 *消費MP -> 0
 *特殊効果 -> なし
 */
public class NormalAttack extends Skill{
    //コンストラクタ
    public NormalAttack(){
        setName("攻撃");
    }

    public void Excute(LivingThing m, LivingThing e) { //通常攻撃でダメージを与える。
        printSkill(m);
        int damage = (m.getATK() - 2) + (int) (Math.random() * 5); // damageはATKの+-2の範囲
        e.damaged(damage);
    }
}