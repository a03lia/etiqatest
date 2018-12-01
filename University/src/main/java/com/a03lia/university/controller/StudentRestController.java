package com.a03lia.university.controller;

import com.a03lia.university.model.Response;
import com.a03lia.university.model.Student;
import com.a03lia.university.model.StudentForm;
import com.a03lia.university.service.StudentSrv;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Collections;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a03lia
 */
@RestController
@RequestMapping("/student")
public class StudentRestController
{
    private static final Logger log = Logger.getLogger(StudentRestController.class);
    
    @Autowired
    private StudentSrv studentSrv;

    @GetMapping("/all")
    @JsonView(DataTablesOutput.View.class)
    public DataTablesOutput<Student> all(DataTablesInput input)
    {
        return studentSrv.allDt(input);
    }

    @PostMapping("/create")
    public ResponseEntity<Response> add(@Valid StudentForm studentForm)
    {
        studentSrv.create(studentForm);
        
        Response response = new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Response> update(@Valid StudentForm studentForm)
    {
        studentSrv.update(studentForm);
        
        Response response = new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @DeleteMapping("/deactive/{id}")
    public ResponseEntity<Response> deactive(@PathVariable("id") String id)
    {
        studentSrv.delete(Long.valueOf(id));
        
        Response response = new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("/id")
    public ResponseEntity<Response> byId(String id)
    {
        Student student = studentSrv.getbyId(Long.valueOf(id));
        
        Response response = new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), Collections.singletonList(student));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
