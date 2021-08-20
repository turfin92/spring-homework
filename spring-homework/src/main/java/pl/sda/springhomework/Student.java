package pl.sda.springhomework;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter

public class Student {

    private final String name;
    private Gender realGender;
    private final short age;



    public Student(String name, int age, Gender realGender) {
        this.name = name;
        this.realGender = realGender;
        this.age = (short) age;
    }

    @Override
    public String toString() {return "Student name: " + name + " Student age: " + age +  " Student gender: " + realGender;}

    public enum Gender {
        MALE,
        NOIDEA,
        FEMALE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
