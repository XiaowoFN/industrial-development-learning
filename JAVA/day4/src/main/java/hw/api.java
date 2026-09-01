package hw;

import java.util.Scanner;

/*
 * api又叫Application Programming Interface:应用程序编程接口
 * 就是java中有很多已经封装好的类和方法我们管它叫做官方java的api所以我们就可以i直接用这些方法
 * 具体他是怎么实现的我们不用懂，只要会用就好了。
 *
 *
 * nextLine 获取输入的字符串数据
 * == 基本类型比较的是数据值是否相同
 * 引用类型比较的是地址值是否相同
 * 用equals来比较字符串的值是否相同
 *
 *
 * */
public class api {
    public static void main(String[] args) {
        System.out.println("Hello World");
        //创建对象i
        Scanner sc = new Scanner(System.in);
        //接收数据
        // String line = sc.nextLine();
//        System.out.println(line);
        String s1 = new String();
        System.out.println(s1);
        char[] chs = {'a', 'b', 'c'};
        String s2 = new String(chs);
        System.out.println(s2);
        byte[] b = {97, 98, 99};
        String s3 = new String(b);
        System.out.println(s3);
    }
}
