package hw;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 这个部分是对于集合的功能测试
 *
 *
 * */
public class arraylisttest {
    public static void main(String[] args) {
//        System.out.println("helloworld");
        //遍历
        ArrayList<String> list = new ArrayList<>();
        list.add("cyr");
        list.add("wcr");
        list.add("xxy");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //建立学生集合
//        ArrayList<student> list1 = new ArrayList<>();
//        student s1 = new student("cyr", 22);
//        student s2 = new student("wcr", 23);
//        student s3 = new student("xxy", 18);
//        list1.add(s1);
//        list1.add(s2);
//        list1.add(s3);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list1.get(i).getName() + " " + list1.get(i).getAge());
//        }

        /*
        ArrayList<student> array = new ArrayList<student>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入名字");
        String name = sc.nextLine();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        student s1 = new student();
        s1.setAge(age);
        s1.setName(name);
        array.add(s1);//为了提高代码的复用性，如果直接用一个方法来实现写入集合信息的功能的话就可以一直调用这个方法来做到写入信息
        */
        ArrayList<student> array=new ArrayList<student>();
        addArray(array);
        addArray(array);
        addArray(array);
        addArray(array);
        for(int i=0;i<array.size();i++){
            {
                System.out.println(array.get(i).getName()+array.get(i).getAge());
            }
        }

    }
    public static void addArray(ArrayList<student>array)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入");
        String name=sc.next();
        System.out.println("请输入");
        int age=sc.nextInt();
        student s=new student();
        s.setAge(age);
        s.setName(name);
        array.add(s);


    }


    }


