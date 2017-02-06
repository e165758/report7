package jp.ac.uryukyu.ie.e165758.LivingThings.Enemys;
import jp.ac.uryukyu.ie.e165758.Skills.*;

public class Jelly extends Enemy {
    //コンストラクタ
    public Jelly(String name, int lv) {
        super(name, lv);
        setSkills(new NormalAttack(), new Rest(), new JellyAttack());
    }
}