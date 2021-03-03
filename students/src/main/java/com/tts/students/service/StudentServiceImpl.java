package com.tts.students.service;

import com.tts.students.model.Student;
import com.tts.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{


 StudentRepository studentRepository;

 public StudentServiceImpl(StudentRepository studentRepository){
     this.studentRepository = studentRepository;
 }

    @Override
    public List<Student> getStudents(){
     return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        boolean exist = studentRepository.existsById(id);
        if (!exist){
            throw new IllegalStateException("student with id " + id + "not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> getStudent(Long id){
     return  studentRepository.findById(id);
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student){
   Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());

   if (studentOptional.isPresent()){
       throw  new IllegalStateException("email taken");
   }
   studentRepository.save(student);
    }

//    @Override
//    public Student getStudent(String email){
//     Student student ;
//     student.getStudent(String email);
//    }
}
