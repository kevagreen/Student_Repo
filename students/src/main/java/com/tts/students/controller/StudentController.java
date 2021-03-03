package com.tts.students.controller;

import com.tts.students.model.Student;
import com.tts.students.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/")
@RestController
@Api(value = "Student Information", description = "Operations pertaining to Students")
public class StudentController {


    StudentService studentService;

    @Autowired
    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully retrieved student using the student's id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the student information")
    })
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
      return studentService.getStudent(id);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully retrieved all students"),
            @ApiResponse(code = 401, message = "You are not authorized to view the list of students")
    })
    @GetMapping("/all")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/new/student")
    public void createNewStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
    }

//    @PatchMapping("/student/{id}")
//    public Optional<Student> updateStudent(@RequestParam Long id, @RequestParam(required = false) String email){
//       Student student;
//       student.g
//
//    }
//
//    private void setStudentEmail(Long id, String email){
//        Student student = s
//    }


}
