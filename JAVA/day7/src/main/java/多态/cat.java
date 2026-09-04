package 多态;

public class cat extends animal {
    public int age = 20;
    public int weight = 10;

    @Override
    public void eat() {
        System.out.println("小猫吃小鱼");
    }

    public void playGame() {
        System.out.println("猫捉迷藏");
    }
}
