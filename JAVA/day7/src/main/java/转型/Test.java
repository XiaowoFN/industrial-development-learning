package 转型;

/*
 * 多态的转型
 * 分为向上转型和向下转型
 * 向上转型为从子到父。父类引用指向子类对象。
 * 向下转型为从父到子。父类引用转为子类对象。
 *
 * */
public class Test {
    public static void main(String[] args) {
        Animal a = new Cat();//向上转型
        a.eat();//编译看左边执行看右边
//        a.playGame;//报错是因为编译看的是a里的方法也就是Animal里的方法。而这个类里没有这个方法所以就会报错。
       /* Cat c=new Cat();
        c.playGame();*///这样虽然可以实现调用猫中的方法但是很冗余。如何声明一个对象就可以调用两个方法呢？
        Cat c = (Cat) a;
        c.playGame();
        c.eat();
        a = new Dog();
        a.eat();
        Dog d=(Dog)a;
        d.playGame();
        a.eat();
        a=new Cat();
        a.eat();
    }
}
