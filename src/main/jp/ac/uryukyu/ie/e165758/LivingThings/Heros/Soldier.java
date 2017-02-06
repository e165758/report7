package jp.ac.uryukyu.ie.e165758.LivingThings.Heros;
import jp.ac.uryukyu.ie.e165758.Skills.*;

public class Soldier extends Hero {
    //コンストラクタ
    public Soldier(String name, int lv) {
        super(name, lv);
        setSkills(new NormalAttack(), new AbsorbSord(), new DoubleAttack());
        this.setHP(this.getHP() + 50);
        this.setMHP(this.getMHP() + 50);
        this.setATK(this.getATK() + 10);
    }
}