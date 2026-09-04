package TeacherAndStudent;

public class Test {
    public static void main(String[] args) {
        //创建老师类对象进行测试
        Teacher teacher = new Teacher();
        teacher.setName("尘垢求");
        teacher.setAge("51");
        System.out.println(teacher.getName() + teacher.getAge());
        teacher.teach();
        Student student = new Student();
        student.setName("爱吃是");
        student.setAge("23");
        System.out.println(student.getName() + student.getAge());
        student.study();
        Teacher teacher2 = new Teacher("咕噜蛋", "48");
        System.out.println(teacher2.getName() + teacher2.getAge());
        Student student1 = new Student("拉拉帮", "45");
        System.out.println(student1.getName() + student1.getAge());
    }
}
