package com.example.cp3566project;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name="programs")

public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Integer pid;
    @Column(name = "program_name")
    private String programName;
    @Column(name = "campus")
    private String campus;


   public Integer getPid(){
       return pid;
   }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}
