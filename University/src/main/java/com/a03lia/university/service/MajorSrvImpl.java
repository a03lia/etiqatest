package com.a03lia.university.service;

import com.a03lia.university.model.Major;
import com.a03lia.university.repository.MajorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a03lia
 */
@Service
public class MajorSrvImpl implements MajorSrv
{
    @Autowired
    private MajorRepository majorRepository;
    
    @Override
    public void create(Major major)
    {
        majorRepository.save(major);
    }

    @Override
    public void update(Major major)
    {
        majorRepository.save(major);
    }

    @Override
    public void delete(String id)
    {
        Optional<Major> major = majorRepository.findById(id);
        
        if (major.isPresent())
        {
            Major m = major.get();
            m.setIsActive(false);
            majorRepository.save(m);
        }
    }

    @Override
    public List<Major> all()
    {
        return majorRepository.findAll();
    }
    
}
