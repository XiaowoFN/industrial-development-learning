package hw;

/*
 *
 * 从这里开始学封装
 *
 * this.xxx指代的就是成员变量  成员变量就是指直接在类里定义好的变量，不是在方法里的变量
 *
 * this关键字很重要
 * 面向对象三大特征之一：封装继承和多态
 *
 *
 * */
public class private1 {
    private int age;
    private String name;
    boolean t = true;
    public private1() {}
    public private1(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    public void showAge() {
        System.out.println("age:" + age);
    }

    public void setAge(int age) {
        if (age < 0|| age>120) {
            t = false;
        } else {
                this.age = age;

        }
    }

    public void getAge() {
        if (t) {
            System.out.println(age);
            ;
        } else {
            System.out.println("不存在");
        }
    }


    public void setName(String name) {
        this.name = name;
    }

    public void showName() {
        System.out.println("name:" + name);
    }
    public void show() {
        System.out.println(name + age);
    }

}
