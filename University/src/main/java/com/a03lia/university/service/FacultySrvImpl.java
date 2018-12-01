package com.a03lia.university.service;

import com.a03lia.university.model.Faculty;
import com.a03lia.university.repository.FacultyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a03lia
 */
@Service
public class FacultySrvImpl implements FacultySrv
{
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public void create(Faculty faculty)
    {
        facultyRepository.save(faculty);
    }

    @Override
    public void update(Faculty faculty)
    {
        facultyRepository.save(faculty);
    }

    @Override
    public void delete(String id)
    {
        Optional<Faculty> faOptional = facultyRepository.findById(id);
        
        if (faOptional.isPresent())
        {
            Faculty f = faOptional.get();
            f.setIsActive(false);
            facultyRepository.save(f);
        }
    }

    @Override
    public List<Faculty> all()
    {
        return facultyRepository.findAll();
    }
    
}
