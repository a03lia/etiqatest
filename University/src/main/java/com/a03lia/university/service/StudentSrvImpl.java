package com.a03lia.university.service;

import com.a03lia.university.exception.CustomException;
import com.a03lia.university.model.Major;
import com.a03lia.university.model.Student;
import com.a03lia.university.model.StudentForm;
import com.a03lia.university.repository.StudentDtRepository;
import com.a03lia.university.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author a03lia
 */
@Service
public class StudentSrvImpl implements StudentSrv
{
    @Autowired
    private StudentDtRepository dtRepository;
    
    @Autowired
    private StudentRepository studentRepository;

    @Transactional()
    @Override
    public void create(StudentForm student)
    {
        Student s = new Student();
        s.setId(null);
        s.setStudentId(student.getStudentId());
        s.setStudentName(student.getStudentName());
        s.setMajorId(new Major( student.getMajorId() ));
        s.setIsActive(true);
        
        studentRepository.save(s);
    }

    @Transactional()
    @Override
    public void update(StudentForm student)
    {
        Optional<Student> s = studentRepository.findById(student.getId());
        
        if (s.isPresent())
        {
            s.get().setStudentId(student.getStudentId());
            s.get().setStudentName(student.getStudentName());
            s.get().setMajorId(new Major( student.getMajorId() ));
    
            studentRepository.save(s.get());
        }
    }

    @Transactional
    @Override
    public void delete(Long id)
    {
        Optional<Student> student = studentRepository.findById(id);
        
        if (!student.isPresent())
        {
            throw new CustomException("Student Not Found");
        }
        else
        {
            Student s = student.get();
            s.setIsActive(false);
            studentRepository.save(s);
        }
    }

    @Override
    public List<Student> all()
    {
        return studentRepository.findAll();
    }

    @Override
    public DataTablesOutput<Student> allDt(DataTablesInput input)
    {
        return dtRepository.findAll(input);
    }

    @Override
    public Student getbyId(Long id)
    {
        Optional<Student> s = studentRepository.findById(id);
        
        if (!s.isPresent())
            throw new CustomException("Student not found");
        else
            return s.get();
    }

}
