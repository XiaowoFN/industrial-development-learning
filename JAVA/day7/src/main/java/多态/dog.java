package 多态;

public class dog extends animal{
    @Override
    public void eat() {
        System.out.println("小狗爱吃是");
    }
    public void lookDoor()
    {
        System.out.println("狗看门");
    }
}
