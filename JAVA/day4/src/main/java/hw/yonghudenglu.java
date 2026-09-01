package hw;

import java.util.Scanner;

public class yonghudenglu {
    public static void main(String[] args) {
        String userName = "cyr";
        String password = "cyr20020803";



        for (int i = 1; i <= 3; i++) {
//            switch (i)
//            {
//                case 1:{
//                    System.out.println("这是第一次输入");
//            }
//                case 2:{
//                    System.out.println("这是第二次输入");
//                }
//                case 3:{
//                    System.out.println("这是第三次输入");
//                }
            System.out.println("请输入用户名和密码");
            Scanner sc = new Scanner(System.in);
            String userName1 = sc.nextLine();
            String password1 = sc.nextLine();
            if (userName.equals(userName1) && password.equals(password1)) {
//                System.out.println("这是第"+i+"次输入，你一共还有"+(3-i)+"次机会");
                System.out.println("登录成功");
                break;
            }
            else {
                System.out.println("这是第"+(i)+"次输入，你一共还有"+(3-i)+"次机会");
                System.out.println("请重新输入");
            }

        }
    }
}

