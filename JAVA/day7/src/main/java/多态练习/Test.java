package 多态练习;

/*
 * 测试类
 * */
public class Test {
    public static void main(String[] args) {
        //创建猫类对象进行测试
        Animal c = new Cat();
        c.setName("依依");
        c.setAge(1);
        System.out.println(c.getName() + c.getAge());
        c.eat();
        c = new Cat("小安", 2);
        System.out.println(c.getName() + c.getAge());
        c.eat();
        Animal d = new Dog();
        d.setName("wangwang");
        d.setAge(3);
        System.out.println(d.getName() + d.getAge());
        d.eat();
        d = new Dog("wangwang",3);
        System.out.println(d.getName() + d.getAge());
        d.eat();

    }
}
