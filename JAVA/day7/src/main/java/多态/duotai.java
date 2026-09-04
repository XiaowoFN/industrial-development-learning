package 多态;

/*
 * 多态：同一个对象，在不同时刻表现出来的不同形态
 * 猫可以是猫 ，猫也可以是动物。因此猫在不同的时刻表现出来的不同的状态。这就是多态
 * 多态的前提和体现：有继承/实现关系 有方法重写 父类引用指向子类对象
 * 由父类引用指向子类对象
 * 成员变量：编译看左边，执行看左边
 * 成员方法：编译看左边，执行看右边
 * 为什么不一样？因为方法有重写，成员变量没有
 * 多态的好处和弊端
 * 多态可以复用代码降低代码冗余，提高了程序的扩展性
 * 但是多态不能访问具体的子类中的方法
 *
 * 多态的转型
 * 分为向上转型和向下转型
 * 向上转型为从子到父。父类引用指向子类对象。
 * 向下转型为从父到子。父类引用转为子类对象。
 * */
public class duotai {
    public static void main(String[] args) {
        animal a = new cat();
        System.out.println(a.age);
//        System.out.println(c.weight); 多态定义的变量要看左边 animal类里有才可以
        a.eat();
//        c.playGame();
        use u = new use();
        cat c = new cat();
        dog d = new dog();
        pig p = new pig();
        u.useAnimal(c);
        u.useAnimal(d);
        u.useAnimal(p);
    }
}
