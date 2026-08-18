package hw;

public class shuzu {
    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] arr = new int[5];
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 5;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        int[] arr2 = arr;
        arr2[0] = 199;
        arr2[1] = 299;
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        int[] arr3 = new int[5];
        System.out.println(arr[0]);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        /*arr3 = null;
        System.out.println(arr3[0]);*/



    }

}
//存储的都是同类型数据
/*
 * 栈内存是存储局部变量的
 * 堆内存是存储new出来的内容的（实体，对象）
 * 对象内部的成员变量，跟随对象存在堆中
 * 在数组中修改相同地址对应的内容，所有对应的值都会被修改。
 * 访问的数组已经不再指向堆内存的数据，造成空指针异常
 * */