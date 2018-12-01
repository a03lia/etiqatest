package com.a03lia.university.repository;

import com.a03lia.university.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author a03lia
 */
public interface FacultyRepository extends JpaRepository<Faculty, String>
{
    
}
