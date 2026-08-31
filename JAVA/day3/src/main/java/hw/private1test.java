package hw;

public class private1test {
    public static void main(String[] args) {
        private1 p = new private1();
        p.setAge(100);
        p.getAge();
        p.setName("cyr");
        p.showName();
        private1 p2 = new private1(32,"yuanshen");
        p2.show();
    }
}
/*
* 如果没有定义构造方法，系统就会给一个默认的无参数构造方法
* 但是要是给出了构造方法就必须写一个自己的默认构造方法要不默认调用会报错
*
*
* */