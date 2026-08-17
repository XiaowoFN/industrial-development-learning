package hl;

import java.util.Scanner;

public class sw {
    public static void main(String[] args) {
        System.out.println("请输入成绩");
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("星期一");
                    break;
                case 2:
                    System.out.println("星期二");
                    break;
                case 3:
                    System.out.println("星期三");
                    break;
                case 4:
                    System.out.println("星期四");
                    break;
                case 5:
                    System.out.println("星期五");
                    break;
                case 6:
                    System.out.println("星期六");
                    break;
                case 7:
                    System.out.println("星期天");
                    break;
                default:
                    System.out.println("情况不存在");
                    break;
            }
        }


    }
}
