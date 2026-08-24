package hw;

import org.jetbrains.annotations.NotNull;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class fangfa {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(sum(5, 5));
        System.out.println(sum((double) 5, (double) 5));
        System.out.println(sum(1, 2, 3));
        isEvenNumber();
        System.out.println(getMax(9, 8));
        int i = 100;
        System.out.println(i);
        changeNumber(i);
        System.out.println(i);

        int[] arr = {11, 22, 33, 44, 55};
        viewArray(arr);


    }

    public static int sum(int a, int b) {
        return a + b;


    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static int getMax(int a, int b) {
        return Math.max(a, b);
    }

    public static void changeNumber(int a) {
        a = 200;
    }

    public static void viewArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }

        }
        System.out.println("]");
    }


    public static void isEvenNumber() {
        while (true) {

            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            if (a % 2 == 0) {
                System.out.println("true");
            } else {
                System.out.println("false");
                break;
            }
        }


    }
}


/*
 * 方法的参数传递
 * 对于基本数据类型的参数，形式参数的改变，不影响实际参数的值
 * 引用类型的参数，形式参数的改变，影响实际参数的值  数组
 *
 * !!注意：Java 的方法参数永远都是“值传递”。基本类型传递的是数据副本，引用类型传递的是引用的副本。
 * */
/*
 * 形参和实参
 * 形参是方法定义中的参数
 * 实参是方法调用中的参数
 * 一个是方法内的前者
 * 后者是调用的时候括号里写的 我这样理解
 *
 *
 * */

/*
 * 方法重载
 * 一定是要同一类中
 * 重点看参数和方法名，如果方法名相同参数相同，那么两个方法构成重载
 * jvm虚拟机会根据参数不同调用不同的方法
 *
 * */

/*
 * 方法不能嵌套定义
 * void代表没有返回值，可以不用加return，如果加return，后面不要加数据
 * 方法的通用格式
 * 明确返回值类型
 * 明确参数
 *
 * */

/*
 * 方法  是将具有独立功能的代码块组织成一个整体，使其拥有特殊的功能
 *
 * 方法要先创建  这叫定义
 * 方法创建后不直接运行，需要手动使用后才可以执行，这叫调用
 *
 * */