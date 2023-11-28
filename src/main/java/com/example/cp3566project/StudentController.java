package com.example.cp3566project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping(path="/cna")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path="/add-student")
    public @ResponseBody String addNewStudent(@RequestParam String firstName,
                        @RequestParam String lastName, @RequestParam String email, @RequestParam String address,
                        @RequestParam String city, @RequestParam String postal, @RequestParam String phone){
        Student n = new Student();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        n.setEmail(email);
        n.setAddress(address);
        n.setCity(city);
        n.setPostal(postal);
        n.setPhone(phone);
        studentRepository.save(n);
        return "Saved";
    }
    @GetMapping(path="/student")
    public @ResponseBody Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @GetMapping(path="/student/{id}")
    public @ResponseBody Optional<Student> getStudentById(@PathVariable(value="id") Integer id){
        return studentRepository.findById(id);
    }


}
