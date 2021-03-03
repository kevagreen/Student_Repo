package com.tts.students.service;

import com.tts.students.model.Student;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface StudentService {
    Optional<Student> getStudent(Long id);
    Iterable<Student> getAllStudents();
    void addStudent(Student student);
    List<Student> getStudents();
    void deleteById(Long id);
//    Student getStudent(String email);


}
