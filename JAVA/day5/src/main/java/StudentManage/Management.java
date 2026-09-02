package StudentManage;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    public static void main(String[] args) {
        ArrayList<Student> studentArray = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while (true) {

            {
                System.out.println("学生管理系统");
                System.out.println("请输入要使用的功能");
                System.out.println("                    1.添加学生信息                    ");
                System.out.println("                    2.删除学生信息                    ");
                System.out.println("                    3.查看所有学生信息                    ");
                System.out.println("                    4.查看所有学生信息                    ");
                System.out.println("                    5.退出                   ");
                int i = Integer.parseInt(input.nextLine());
                switch (i) {
                    case 1: {
                        insertStudent(studentArray, input);
                        break;
                    }
                    case 2: {
                        deleteStudent(studentArray, input);
                        break;
                    }
                    case 3: {
                        viewStudent(studentArray);
                        break;
                    }
                    case 4: {
                        changeStudent(studentArray, input);
                        break;
                    }
                    case 5:
                    {
                        System.out.println("谢谢使用");
                        return;
                    }
                }
            }
        }

    }

    //添加学生信息
    public static void insertStudent(ArrayList<Student> array, Scanner sc) {
        System.out.println("请输入学生id");
        String id = sc.nextLine();
        System.out.println("请输入学生姓名");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄");
        String age = sc.nextLine();
        System.out.println("请输入学生地址");
        String address = sc.nextLine();
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
    }

    //删除学生信息
    public static void deleteStudent(ArrayList<Student> array, Scanner sc) {
        System.out.println("请输入想要删除学生的id");
        String id = sc.nextLine();
        for (int i = 0; i < array.size(); i++) {
            if (id.equals(array.get(i).getId())) {
                array.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("未找到该学生");

    }

    //修改学生信息
    public static void changeStudent(ArrayList<Student> array, Scanner sc) {
        System.out.println("请输入想要修改的学生的ID");
        String id = sc.nextLine();
        for (int i = 0; i < array.size(); i++) {
            if (id.equals(array.get(i).getId())) {
                System.out.println("请输入修改之后的学生姓名");
                String name = sc.nextLine();
                array.get(i).setName(name);
                System.out.println("请输入修改之后的学生年龄");
                String age = sc.nextLine();
                array.get(i).setAge(age);
                System.out.println("请输入修改之后的学生地址");
                String address = sc.nextLine();
                array.get(i).setAddress(address);
            }
        }
    }

    //查看所有的学生信息
    public static void viewStudent(ArrayList<Student> array) {
        System.out.println("ID" + "   " + "姓名" + "    " + "年龄" + "    " + "地址");
        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            System.out.println(student.getId() + "    " + student.getName() + "    " + student.getAge() + "     2" + student.getAddress());
        }
    }
}
