package com.example.cp3566project;

import com.example.cp3566project.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/api/cna/programs")
public class ProgramsController {
    @Autowired
    private ProgramsRepository programsRepository;

    @PostMapping
    public @ResponseBody Programs addNewProgram(@RequestBody Programs programs){
        return programsRepository.save(programs);
    }
    @GetMapping
    public @ResponseBody Iterable<Programs> getAllPrograms(){
        return programsRepository.findAll();
    }
    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Programs> getProgramById(@PathVariable Integer id){
        return programsRepository.findById(id);
    }
    @PutMapping(path="/{id}")
    public ResponseEntity<Programs> updateProgramsById(@PathVariable Integer id, @RequestBody Programs programs) {
        Programs updatedPrograms = programsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Program does not exist with id:" + id));
        updatedPrograms.setProgramName(programs.getProgramName());
        updatedPrograms.setCampus(programs.getCampus());
        programsRepository.save(updatedPrograms);
        return ResponseEntity.ok(updatedPrograms);
    }


    @DeleteMapping(path="/{id}")
    public ResponseEntity<Programs> deleteProgramsById(@PathVariable Integer id){
        Programs deletedProgram =  programsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Program does not exist with id" + id));
        programsRepository.deleteById(id);
        return ResponseEntity.ok(deletedProgram);
    }
}
