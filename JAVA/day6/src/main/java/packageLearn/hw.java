package packageLearn;
import TeacherAndStudent.Teacher;

import java.util.ArrayList;

/*
* 包其实就是文件夹，他的作用就是对类进行分类管理
* 导入包
* 状态修饰符
* final关键字是最终的意思，可以修饰成员方法，成员变量，类
* final方法作为父方法的话是不能被重写的
* final修饰的变量可看作常量，不能再被修改了
* 如果一个类被final修饰，那么他就是最终类，就不能被其他类继承了。
* final修饰引用类型的话，地址值不能修改，但是地址值对应的内容可以修改
*
* static：这个关键字是静态的意思，可以修饰成员方法，成员变量
* 修饰的成员变量所有对象全部共享，比如我在new一个s1给他赋值了之后，s2也会相应地进行改变。
* 被所有对象共享的成员变量我们用静态修饰
* 静态成员方法只能访问静态成员
*
*
* */
public class hw {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("12","拉杜古");
        teacher.teach();
        System.out.println(teacher.getName()+teacher.getAge());




    }
}
