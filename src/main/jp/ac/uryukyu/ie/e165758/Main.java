package jp.ac.uryukyu.ie.e165758;

import jp.ac.uryukyu.ie.e165758.LivingThings.Enemys.*;
import jp.ac.uryukyu.ie.e165758.LivingThings.Heros.*;
import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;

public class Main {
    public static void main(String args[]) {
        LivingThing a = new Soldier("ゆうしゃ", 5);
        LivingThing b = new Jelly("スライム", 3);
        Battle battle = new Battle(a, b);
    }
}