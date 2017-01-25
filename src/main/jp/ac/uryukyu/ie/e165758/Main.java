package jp.ac.uryukyu.ie.e165758;

/**
 * Created by e165758 on 2017/01/25.
 */
public class Main {
    public static void main(String args[]) {
        LivingThing hero = new LivingThing("勇者", 10);
        LivingThing slime = new LivingThing("モンスター", 10);
        Battle battle = new Battle(hero, slime);
    }
}