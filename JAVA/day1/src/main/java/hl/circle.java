package hl;

public class circle {
    public static void main(String[] args) {
        int sum = 0;
        for (int a = 1; a <= 10; a++) {
            System.out.println("hello world");
            sum += a;
        }
        System.out.println("sum=" + sum);

        // 求一到一百的偶数和
        int sum1 = 0;
        for (int b = 1; b <= 100; b++) {
            if (b % 2 == 0) {
                sum1 += b;
            }
        }
        System.out.println("sum1=" + sum1);

        int sum2 = 0;
        while (sum2 <= 10) {
            System.out.println("sum2=" + sum2);
            sum2++;
        }

        int sum3 = 1;
        do {
            System.out.println("sum3=" + sum3);
            sum3++;
        } while (sum3 <= 10);
    }
}

// 三种循环区别
/**
 * do...while 至少会执行一次循环体。
 * for 和 while 的区别：while 的计数器声明在循环结构之外时，循环结束后可以继续使用。
 * for (;;) 和 while (true) 都可以表示无限循环。
 */
