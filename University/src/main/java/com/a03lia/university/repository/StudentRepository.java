package com.a03lia.university.repository;

import com.a03lia.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author a03lia
 */
public interface StudentRepository extends JpaRepository<Student, Long>
{
}