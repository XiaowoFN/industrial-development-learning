package hl;
import java.util.Scanner;
import java.util.logging.Logger;
public class hl1 {

    public static void main(String[] args) {
        System.out.println("Hello World");
        //短路逻辑运算符 &&短路与||短路或  &与|或
        int i =10;
        int j =20;
        int k =30;

        System.out.println((k>i)&&(j>i));
        System.out.println((i>k)&&(j>i));
        //System.out.println((i++ >100)&(j++ >100));
        System.out.println((i++ >100)&&(j++ >100));
        System.out.println(i);
        System.out.println(j);
        //三元运算符
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();
        System.out.println(a +b);
//        if()
//        {
//
//        }else if()
//        {
//
//        }else {
//
//        }



    }
}
