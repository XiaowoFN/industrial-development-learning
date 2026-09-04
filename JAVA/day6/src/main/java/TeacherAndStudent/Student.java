package TeacherAndStudent;

public class Student extends Human{
    /*public String name;
    public String age;*/

    /*public Student() {
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }*/

   /* public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }*/
    public Student() {}
    public Student(String name, String age) {
        super(name, age);
    }
    public void study()
    {
        System.out.println("好好学习，天天向上");
    }
}
