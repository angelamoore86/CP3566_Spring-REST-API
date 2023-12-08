package com.example.cp3566project;

import com.example.cp3566project.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/api/cna/course")

public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    @PostMapping
    public @ResponseBody Course addNewCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }
    @GetMapping
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Course> getCourseById(@PathVariable Integer id){
        return courseRepository.findById(id);
    }
    @PutMapping(path="/{id}")
    public ResponseEntity<Course> updateCourseById(@PathVariable Integer id, @RequestBody Course course) {
        Course updatedCourse = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course does not exist with id:" + id));
        updatedCourse.setCourseName(course.getCourseName());
        updatedCourse.setCourseNumber(course.getCourseNumber());
        updatedCourse.setCapacity(course.getCapacity());
        updatedCourse.setYear(course.getYear());
        updatedCourse.setSemester(course.getSemester());
        updatedCourse.setPid(course.getPid());
        courseRepository.save(updatedCourse);
        return ResponseEntity.ok(updatedCourse);
    }


    @DeleteMapping(path="/{id}")
    public ResponseEntity<Course> deleteCourseById(@PathVariable Integer id){
        Course deletedCourse =  courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course does not exist with id" + id));
        courseRepository.deleteById(id);
        return ResponseEntity.ok(deletedCourse);
    }
}
