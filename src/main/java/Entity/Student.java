package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int roll;
    private String name;
    private int age;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    Student(int roll, String name, int age) {
        this.age = age;
        this.roll = roll;
        this.name = name;
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

    public Student(int roll, int age, String name,Address address) {
        this.roll = roll;
        this.age = age;
        this.name = name;
        this.address=address;
    }

    public Student()
    {

    }
}
