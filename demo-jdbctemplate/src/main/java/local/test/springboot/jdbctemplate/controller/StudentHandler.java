package local.test.springboot.jdbctemplate.controller;

import local.test.springboot.jdbctemplate.entity.Student;
import local.test.springboot.jdbctemplate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentHandler {

    @Autowired
    private StudentRepository studentRepository;

    // http://localhost:8080/findAll
    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

//    http://localhost:8080/findAll/1
    @GetMapping("/findById/{id}")
    public Student get(@PathVariable("id") Long id){
        return studentRepository.findById(id);
    }


    @PostMapping("/save")
    public int save(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/update")
    public int update(@RequestBody Student student){
        return studentRepository.update(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable("id") Long id){
        return studentRepository.deleteById(id);
    }
}
