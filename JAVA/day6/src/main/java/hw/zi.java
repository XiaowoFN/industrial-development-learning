package hw;

public class zi extends fu {
    public int height = 175;
    public int age = 20;

    public void method() {

        System.out.println("method方法被调用");

    }

    public void show() {
        int age = 30;
        System.out.println(age);
        System.out.println(height);
        //System.out.println(weight); 报错
        System.out.println(this.age);//加了this之后就能访问上面了。要不就只能访问这个方法中的age
        System.out.println(super.age);//加了super关键字之后就会访问父类中的age
    }
}
