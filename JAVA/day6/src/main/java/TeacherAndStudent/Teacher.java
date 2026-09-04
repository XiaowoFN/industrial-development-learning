package TeacherAndStudent;

public class Teacher extends Human{
    /*public String name;
    public String age;

    public Teacher() {
    }

    public Teacher(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
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
    public Teacher(){}
    public Teacher(String name, String age) {
       /* this.name = name;
        this.age =age;*/
        super(name, age);

    }
    public void teach() {
        System.out.println("哎教教书吧");
    }
}


