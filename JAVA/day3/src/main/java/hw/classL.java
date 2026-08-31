package hw;

/*
 * ！！从这个文档开始说明和笔记会放在文件的上面！！
 *
 * 什么是对象？
 * 什么是面向对象
 * 类是对现实生活中一类具有共同属性和行为的事物的抽象
 * 类是对象的数据类型
 * 是具有相同属性和行为的一组对象的集合
 *
 * 对象的属性：
 * 属性：对象具有的各种特征，每个对象的每个属性都拥有特性的值
 *
 * 对象的行为
 * 对象能够执行的操作
 * 比如手机是个类：打电话发短信都是对象
 *
 * 对现实生活中一类具有共同属性和行为的事物的抽象
 * 对象时能够看得到的摸得着的真实存在的实体
 *
 * 类是对象的抽象
 * 对象是类的实体
 *
 * 类的定义
 * 类是java程序的基本组成单位
 *
 * 类的组成有属性和行为
 * 属性：在类中通过成员变量来体现
 * 行为：在类中通过成员方法来体现
 * 定义步骤：
 * 编写变量
 * 编写方法
 *
 *
 * 成员变量和局部变量
 * 成员变量就是你定义一个类的时候写的要素就是成员变量
 * 然后你在类写的方法那就是局部变量了（如果是你的方法里面有变量的话）
 *
 *
 *
 * */

public class classL {
    public static void main(String[] args) {
//        System.out.println("hello world");
        //创建对象
        phone p = new phone();//new出来的东西在堆内存
        p.brand = "huawei";
        System.out.println(p.brand);
        p.price = 10245;
        p.sendMessage();
        p.call();
        student s = new student();

        System.out.println(s.age + " " + s.name);
//        System.out.println(s.name);
        s.name = "shide";
        s.doHomework();
        s.study();


        student g = s;
        System.out.println(g.name);
        g.name = "genshi";
        System.out.println(g.name);
        System.out.println(s.name);
        g.doHomework();
        System.out.println(s);
        System.out.println(g);
    }


}


/*
 * 对象内存图
 * student s是在栈内存   new student()是堆内存
 *
 *
 *
 *
 *
 * */



