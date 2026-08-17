package hl;

import java.util.Random;

public class Cb {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            if(i%2==0){
                continue;
            }
            System.out.println(i);
        }
        for(int a = 0; a <=24; a++){
            for(int b = 0; b <=60; b++){
                System.out.println("一天有"+a+"小时"+b+"分钟");
            }
        }
        //random
        Random r = new Random();

        for(int c = 1; c <=10; c++){
            int an = r.nextInt(10)+1;
            System.out.println(an);

        }

    }
}
//嵌套循环以及随机数
