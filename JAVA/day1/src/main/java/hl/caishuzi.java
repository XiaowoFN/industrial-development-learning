package hl;

import java.util.Random;
import java.util.Scanner;

public class caishuzi {
    public static void main(String[] args) {
        while(true){
            Random rand = new Random();
            int a = rand.nextInt(100)+1;
            System.out.println("请输入数据");
            while(true){
                {
                    Scanner sc = new Scanner(System.in);
                    int i = sc.nextInt();
                    if(i<a) {
                        System.out.println("输入的数据小了");
                    }else if(i>a){
                        System.out.println("输入的数据大了");
                    }else
                    {
                        System.out.println("猜对了恭喜！");
                        break;
                    }
                }
            }
        }


    }
}
//程序自动生成一个1-100之间的数字，使用程序实现猜出这个数字是多少？