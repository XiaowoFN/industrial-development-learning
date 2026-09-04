package override;

/*
 *
 * 新手机类
 * */
public class NewPhone extends Phone {
 /*   public void call(String name) {
        System.out.println("开启视频功能");
//        System.out.println("给" + name + "打电话");
        super.call(name);
    }*/
    @Override//注解，可以帮忙检查一下方法重写的时候方法声明的正确性
    public void call(String name)
    {
        System.out.println("打开视频通话");
        super.call(name);

    }
}
