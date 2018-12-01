package com.a03lia.university.controller;

import com.a03lia.university.model.Response;
import com.a03lia.university.service.FacultySrv;
import com.a03lia.university.service.MajorSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a03lia
 */
@RestController
@RequestMapping("/master")
public class MasterRestController
{
    @Autowired
    private FacultySrv facultySrv;
    
    @Autowired
    private MajorSrv majorSrv;
    
    @GetMapping("/faculty/all")
    public ResponseEntity<Response> faculties()
    {
        Response response = new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), facultySrv.all());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping("/major/all")
    public ResponseEntity<Response> majors()
    {
        Response response = new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), majorSrv.all());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
