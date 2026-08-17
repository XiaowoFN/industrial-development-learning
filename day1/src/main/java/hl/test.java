package hl;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入成绩");
        while(true){
            int a = sc.nextInt();
            if(a >=0 &&a<80)
        {
            System.out.println("胖揍一顿");
        } else if (80 <= a && a < 90) {
            System.out.println("变形金刚玩具一个");
        }else  if (90<=a && a < 95)
        {
            System.out.println("游乐场玩一次");
        }else if(95<=a && a <= 100)
        {
            System.out.println("山地自行车一辆");
        }else {
            System.out.println("输入的成绩不合法");
        }}


    }
}
