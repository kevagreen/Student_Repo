package com.tts.students.service;

import com.tts.students.model.Student;
import com.tts.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Component
public class Runner{



    @Bean
    CommandLineRunner run( StudentRepository studentRepository) throws Exception {
      return args -> {
          Student student1 = new Student("Maria", "Jones", "mjones@gmail.com", LocalDate.of(1986, Month.MARCH, 25));
          Student student2 = new Student("Marlon", "Wayans", "mWayans@gmail.com", LocalDate.of(1990, Month.APRIL, 3));
          Student student3 = new Student("Martin", "Lawrence", "mmartin@gmail.com", LocalDate.of(2000, Month.AUGUST, 24));
      studentRepository.saveAll(List.of(student1, student2, student3));
      };

    }




}

