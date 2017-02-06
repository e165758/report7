package jp.ac.uryukyu.ie.e165758;

import jp.ac.uryukyu.ie.e165758.Skills.*;
import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;
import jp.ac.uryukyu.ie.e165758.LivingThings.Heros.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class SoldierTest {
    @Test
    public void Action() {
        LivingThing a = new Soldier("テスト戦士1", 3);
                Skill skill_1 = a.getSkills()[1];
        String skillName = skill_1.getName();
        assertEquals("吸血剣", skillName);
    }
}