package com.tts.students.repository;

import com.tts.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Long> {


   //@Query("select email from STUDENTS WHERE email=?")
    Optional<Student> findByEmail(String email);
}
