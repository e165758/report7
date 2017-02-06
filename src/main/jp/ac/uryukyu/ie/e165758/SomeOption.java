package jp.ac.uryukyu.ie.e165758;

import java.util.Scanner;

public class SomeOption {
    static public void pushEnter() {
        System.out.println(" \n --- Push Enter ---");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
    }
    static public void print(String str){
        System.out.println(str);
        pushEnter();
    }
}