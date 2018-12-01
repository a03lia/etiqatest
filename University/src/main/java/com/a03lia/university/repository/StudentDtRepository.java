package com.a03lia.university.repository;

import com.a03lia.university.model.Student;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

/**
 *
 * @author a03lia
 */
public interface StudentDtRepository extends DataTablesRepository<Student, Integer>
{
    
}
