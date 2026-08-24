package hw;

public class pass7 {
    public static void main(String[] args) {
//        System.out.println("hello world");
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0 || i % 10 == 7 || i / 10 % 10 == 7) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);


    }
}
/*
 * 逢七就过，带7的，能被7除尽的
 * */