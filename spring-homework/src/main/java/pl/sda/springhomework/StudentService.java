package pl.sda.springhomework;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StudentService {
    private final Repo repo;

    public StudentService(Repo repo) {this.repo=repo;}

    public List<Student> findAll(){ return repo.findAll();}
    public Student getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id.toString()));

    }

    public Student getRandomStudent() {
        Integer randomInteger = new Random().nextInt(findAll().size());
        return getById(randomInteger);
    }

    public void  addNewStudent(Student student) {
        if (student != null)
        repo.save(student);

    }

    public void deleteStudent(Student student) {
        if(student != null)
            repo.delete(student);
    }

    public void updateStudent(Student student) {
        if(student != null)
            repo.save(student); //normalnie by trzeba było wyciagnać z bazy studenta i przypisać mu pola ale na potrzebe zadania pomijam
    }
}
