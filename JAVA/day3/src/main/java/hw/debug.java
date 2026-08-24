package hw;

import java.util.Scanner;

public class debug {
    public static void main(String[] args) {
        /*System.out.println("Hello World");
        System.out.println("Hello World");
        int i = 10;
        int j = 20;
        int sum = i+j;
        System.out.println(sum);*/
//循环求偶数和
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(getMax(n, m));


    }

    public static int getMax(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

}




/*
 * 是程序调试工具，可以查看程序的执行流程，追踪程序执行过程来调试程序
 * 断点调试
 *
 * */
