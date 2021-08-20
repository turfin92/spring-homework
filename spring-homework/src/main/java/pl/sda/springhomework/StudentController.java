package pl.sda.springhomework;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    List<Student> getAllStudents() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    Student getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/random")
    Student getRandomStudent() {
        return service.getRandomStudent();
    }

    @PostMapping()
    void addStudent(@RequestBody Student student){
        service.addNewStudent(student);
    }

    @PutMapping()
    void updateStudent(@RequestBody Student student){
        service.updateStudent(student);
    }

    @DeleteMapping
    void deleteStudent(@RequestBody Student student) {
        service.deleteStudent(student);
    }
}


