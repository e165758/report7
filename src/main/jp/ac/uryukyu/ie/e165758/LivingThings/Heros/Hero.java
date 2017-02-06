package jp.ac.uryukyu.ie.e165758.LivingThings.Heros;
import java.util.Scanner;
import jp.ac.uryukyu.ie.e165758.LivingThings.LivingThing;
import jp.ac.uryukyu.ie.e165758.Skills.*;
import jp.ac.uryukyu.ie.e165758.SomeOption;

public class Hero extends LivingThing {
    //コンストラクタ
    public Hero(String name, int lv) {super(name, lv);}

    public void printCommands() {
        System.out.println("0 -> " + this.getSkills()[0].getName() + " MP" + this.getSkills()[0].getUseMP() + "消費");
        System.out.println("1 -> " + this.getSkills()[1].getName() + " MP" + this.getSkills()[1].getUseMP() + "消費");
        System.out.println("2 -> " + this.getSkills()[2].getName() + " MP" + this.getSkills()[2].getUseMP() + "消費");
    }

    public int inputCommand() {
        int command = 0;
        int inputSuccess = 0;
        System.out.println("コマンド(0, 1, 2)を入力してください。");
        do {
            try {
                printCommands();
                Scanner scan = new Scanner(System.in);
                String str = scan.next();
                command = Integer.parseInt(str);
                    Skill skill = this.getSkills()[command];
                    if (skill.getUseMP() <= this.getMP()) inputSuccess = 0;
                    else{
                        SomeOption.print("MPが不足しています。");
                        SomeOption.print("残りMP -> " + this.getMP());
                        inputSuccess = 1;
                    }
            }
            catch(NumberFormatException e) {inputSuccess = 1;}
            catch(ArrayIndexOutOfBoundsException e) {inputSuccess = 1;}
            if (inputSuccess == 1) {SomeOption.print("もう一度入力してください。");}
        } while (inputSuccess == 1);
        return command;
    }
}