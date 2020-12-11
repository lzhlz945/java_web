package pojo;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: pojo
 * @date:2020/12/11
 */
public class Student {
    private String num;
    private String name;
    private Integer age;
    private String addr;

    public Student() {
    }

    public Student(String num, String name, Integer age, String addr) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
