package com.a03lia.university.repository;

import com.a03lia.university.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author a03lia
 */
public interface MajorRepository extends JpaRepository<Major, String>
{
    
}
