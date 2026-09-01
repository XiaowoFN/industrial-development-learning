package hw;

import java.util.ArrayList;

/*
 * 集合基础
 * 什么是集合？
 * 集合概述
 * 考试如果一个人考试那就存储一个人的分数就好了
 * 但是考试不可能只有一个人
 * 那么可以用数组吗？
 * 但是考试当天如果有人来不了呢
 * 数组的长度是不能改变的啊
 * 所以就得用集合
 * 集合类的特点：提供一种存储空间可变的存储模型，存储的数据容量可以发生改变
 * 其实是可变化的数组的实现，
 * ArrayList<E>:
 * 可调整大小的数组实现
 * <E>:是一种特殊的数据类型，泛型。
 * ArrayList<>构造方法和添加方法
 * add(E e) 将指定的元素添加到集合的末尾
 * void add(int index,E element) 指定位置插入元素
 * list.remove删除某特定位置的元素，跟数组位置一样
 * list.set(int e)修改某个特定位置的元素
 *
 * */
public class arraylistbasic {
    public static void main(String[] args) {
//        System.out.println("helloworld");
//        ArrayList<String> array = new ArrayList<String>();
//        ArrayList<String>array=new ArrayList<>();
        ArrayList<String> list=new ArrayList<>();
        System.out.println("Array"+list);
//        add(E e) 将指定的元素添加到集合的末尾
        System.out.println(list.add("hello"));
        list.add("world");
        list.add("java");
        System.out.println(list);
//        void add(int index,E element) 指定位置插入元素
        list.add(1,"javaase");//在1位置添加了javaase，之前的元素往后移动了
//        System.out.println(list);
        list.add(3,"javaee");
        list.add(5,"javaee");
//        list.remove(0);
        list.remove("javaee");//但是要记住是只删除第一个匹配项，如果有两个一样的值，那就删除靠前的那一个
//        list.removeIf("javaee"::equals);//这个的意思就是删除集合中所有等于javaee的值，也就是删除全部
//        list.removeIf("hello"::equals);
        list.set(1,"javaee");//把新元素设定到指定位置
        int i =list.size();//输出一个集合中元素的个数
        System.out.println(i);

        System.out.println(list);



    }
}























