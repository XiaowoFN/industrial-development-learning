package override;

/*
 * 子类中出现了和父类中一模一样的方法声明
 * 当子类需要父类的功能,而功能主体子类有自己的特有内容时。可以重写父类中的方法，这样即沿袭了父类的功能，又定义了子类特有的内容
 * 例如手机类和新手机类
 *
 * 方法重写的注意事项
 * 父类中的私有内容private内容，子类无法继承
 * 方法重写的时候权限一定不能比父类的低
 *
 * 继承的注意事项
 * 继承一次只能继承一个类
 * java中类可以支持多层继承
 *
 * */
public class fangfachongxie {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.call("爱吃是");
        System.out.println("------------------------");
        NewPhone p1 = new NewPhone();
        p1.call("爱吃是");
    }
}
