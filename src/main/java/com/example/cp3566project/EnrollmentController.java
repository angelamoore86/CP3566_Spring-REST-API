package com.example.cp3566project;

import com.example.cp3566project.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/api/cna/enrollment")

public class EnrollmentController {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @PostMapping
    public @ResponseBody Enrollment addNewEnrollment(@RequestBody Enrollment enrollment){
        return enrollmentRepository.save(enrollment);
    }
    @GetMapping
    public @ResponseBody Iterable<Enrollment> getAllEnrollment(){
        return enrollmentRepository.findAll();
    }
    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Enrollment> getEnrollmentById(@PathVariable Integer id){
        return enrollmentRepository.findById(id);
    }
    @PutMapping(path="/{id}")
    public ResponseEntity<Enrollment> updateEnrollmentById(@PathVariable Integer id, @RequestBody Enrollment enrollment) {
        Enrollment updatedEnrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollement does not exist with id:" + id));
        updatedEnrollment.setCourseId(enrollment.getCourseId());
        updatedEnrollment.setStudentId(enrollment.getStudentId());
        enrollmentRepository.save(updatedEnrollment);
        return ResponseEntity.ok(updatedEnrollment);
    }


    @DeleteMapping(path="/{id}")
    public ResponseEntity<Enrollment> deleteEnrollmentById(@PathVariable Integer id){
        Enrollment deleteEnrollment =  enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The Enrollment does not exist with id" + id));
        enrollmentRepository.deleteById(id);
        return ResponseEntity.ok(deleteEnrollment);
    }

}
