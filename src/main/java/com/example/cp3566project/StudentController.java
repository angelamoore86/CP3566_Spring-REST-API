package com.example.cp3566project;

import com.example.cp3566project.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/api/cna/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

   @PostMapping
    public @ResponseBody Student addNewStudent(@RequestBody Student student ){
         return studentRepository.save(student);
    }
    @GetMapping
    public @ResponseBody Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Student> getStudentById(@PathVariable(value="id") Integer id){
        return studentRepository.findById(id);
    }
    @PutMapping(path="/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Integer id,@RequestBody Student student) {
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exist with id:" + id));
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setAddress(student.getAddress());
        updateStudent.setCity(student.getCity());
        updateStudent.setPostal(student.getPostal());
        updateStudent.setPhone(student.getPhone());
        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }


    @DeleteMapping(path="/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id){
        Student deletedStudent =  studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exist with id" + id));
        studentRepository.deleteById(id);
        return ResponseEntity.ok(deletedStudent);
    }
}
