package com.sjprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sjprogramming.restapi.entity.Student; // Ensure you import your Student entity class

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
