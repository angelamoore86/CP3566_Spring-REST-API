package com.example.cp3566project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/cna")

public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    @PostMapping(path="/add-course")
    public @ResponseBody String addNewCourse(@RequestParam String  courseName, @RequestParam String courseNumber,
                                             @RequestParam Integer capacity ){
        Course n = new Course();
        n.setCourseName(courseName);
        n.setCourseNumber(courseNumber);
        n.setCapacity(capacity);
        courseRepository.save(n);
        return "Saved";
    }
    @GetMapping(path= "/course")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping(path="/course/{id}")
    public @ResponseBody Optional<Course> getCourse(@PathVariable(value="id") int courseId){
        return courseRepository.findById(courseId);
    }
}
