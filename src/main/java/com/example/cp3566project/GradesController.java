package com.example.cp3566project;

import com.example.cp3566project.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/api/cna/grades")

public class GradesController {
    @Autowired
    private GradesRepository gradesRepository;

    @PostMapping
    public @ResponseBody Grades addNewGrade(@RequestBody Grades grades){
        return gradesRepository.save(grades);
    }
    @GetMapping
    public @ResponseBody Iterable<Grades> getAllGrades(){
        return gradesRepository.findAll();
    }
    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Grades> getGradesById(@PathVariable Integer id){
        Grades grades =  gradesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The grade does not exist with id:" + id));
        return Optional.ofNullable(grades);
    }
    @PutMapping(path="/{id}")
    public ResponseEntity<Grades> updateGradesById(@PathVariable Integer id, @RequestBody Grades grades) {
        Grades updatedGrades = gradesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The grade does not exist with id:" + id));
        updatedGrades.setStudentId(grades.getStudentId());
        updatedGrades.setCourseId(grades.getCourseId());
        updatedGrades.setGrade(grades.getGrade());
        gradesRepository.save(updatedGrades);
        return ResponseEntity.ok(updatedGrades);
    }


    @DeleteMapping(path="/{id}")
    public ResponseEntity<Grades> deleteGradesById(@PathVariable Integer id){
        Grades deleteGrades = gradesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The Grade does not exist with id" + id));
        gradesRepository.deleteById(id);
        return ResponseEntity.ok(deleteGrades);
    }
}
