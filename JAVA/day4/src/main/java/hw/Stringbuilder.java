package hw;

/*
 * StringBuilder是一个可变的的字符串类，我们可以把它看作是一个容器
 * StringBuilder对象中的内容是可变的
 * append方法可以往StringBuilder中添加字符
 * revers方法可以反转字符串
 * 那如何让StringBuilder和String相互转换呢
 * 要想办法把String转换为StringBuilder然后就可以方便的使用这两种方法了
 * 然后用完方法之后还要把StringBuilder转换为String
 *
 *
 *
 * */
public class Stringbuilder {
    public static void main(String[] args) {
//        String s= "hello";
//        s+="world";
//        System.out.println(s);
        //public StringBuilder创建一个可变字符串对象，不含有任何的内容

        StringBuilder sb = new StringBuilder();
        System.out.println(sb);
        System.out.println(sb.length());
//        StringBuilder sb1=new StringBuilder("hello");

        StringBuilder sb1 = sb.append("hello");
//        System.out.println(sb1);
//        System.out.println(sb1.length());
        System.out.println(sb);
//        System.out.println(sb==sb1);;
//        sb1.append("world");
//        System.out.println(sb1);
//        System.out.println(sb);

        sb.append(250);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        //相互转换
        StringBuilder sb2=new StringBuilder();
        sb2.append("hello").append("world").append("cyr");
        //引入一个toString 方法   就是s=sb.toString()
        String s=sb2.toString();
        System.out.println(s);
        System.out.println(s.equals(sb2));
        System.out.println(sb2);
        //String转换为StringBuilder  直接创建一个StringBuilder对象，把字符串的作为参数传进去就好
        String s1= "hello";
        StringBuilder sb3=new StringBuilder(s1);
        System.out.println(sb3);



    }

}
