package hw;
/*
* .equals就可以直接比较引用数据类型中的内容，如果相同则返回true
*
*
* */
public class equal {
    public static void main(String[] args) {
//        System.out.println("hello world");
        char[] car = {'a','b','c'};

        String a = new String(car);
        String b = new String(car);
        String c = new String(car);
        String d="abc";
        String e="abc";
        System.out.println(a);
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);
        System.out.println(d==e);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
        System.out.println(b.equals(c));


    }
}
