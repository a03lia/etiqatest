/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a03lia.university.service;

import com.a03lia.university.model.Student;
import com.a03lia.university.model.StudentForm;
import java.util.List;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

/**
 *
 * @author a03lia
 */
public interface StudentSrv
{
    List<Student> all();
    DataTablesOutput<Student> allDt(DataTablesInput input);
    void create(StudentForm student);
    void update(StudentForm student);
    void delete(Long id);
    Student getbyId(Long id);
}
