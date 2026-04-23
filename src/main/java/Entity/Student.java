package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
    @Id
    private int roll;
    private String name;
    private int age;
    @OneToOne
    private Laptop laptop;

    public  Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Student(int roll, String name, int age, Laptop laptop) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.laptop = laptop;
    }

    Student(int roll, String name, int age) {
        this.age = age;
        this.roll = roll;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", laptop=" + laptop +
                '}';
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public Student()
    {

    }
}
