package pl.sda.springhomework;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static pl.sda.springhomework.Student.Gender.*;

@Repository
public class Repo {

    private List<Student> studentList;

    @PostConstruct
    void addStudent() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Spiderman", 15, MALE));
        studentList.add(new Student("CptMarvel", 25, FEMALE));
        studentList.add(new Student("MrNobody", 100, NOIDEA));
        studentList.add(new Student("Hulk", 35, MALE));
        studentList.add(new Student("BlackWidow", 33, FEMALE));
    }

    List<Student> findAll() {
        return studentList;
    }

    Optional<Student> findById(Integer index) {
        try {
            return Optional.of(studentList.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }



    }

    public Student getStudentById(int index) {
        return studentList.get(index);
    }

   public Optional<Student> findByName(String name) {
        return studentList.stream().filter(student -> student.getName().equals(name)).findAny();
   }

   public void save (Student input) {
       Optional<Student> optionalStudent = studentList.stream().filter(student -> student.getName().equals(input.getName())).findAny();
       optionalStudent.ifPresent(student -> studentList.remove(student));
       studentList.add(input);

   }

   public void delete(Student student ) {
        studentList.remove(student);
   }


}
