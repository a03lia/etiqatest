/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a03lia.university.model;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

/**
 *
 * @author a03lia
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries(
        {
            @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
            , @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id")
            , @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId")
            , @NamedQuery(name = "Student.findByStudentName", query = "SELECT s FROM Student s WHERE s.studentName = :studentName")
            , @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address")
            , @NamedQuery(name = "Student.findByCountry", query = "SELECT s FROM Student s WHERE s.country = :country")
            , @NamedQuery(name = "Student.findByCity", query = "SELECT s FROM Student s WHERE s.city = :city")
            , @NamedQuery(name = "Student.findByZipCode", query = "SELECT s FROM Student s WHERE s.zipCode = :zipCode")
            , @NamedQuery(name = "Student.findByIsActive", query = "SELECT s FROM Student s WHERE s.isActive = :isActive")
        })
public class Student implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @JsonView(DataTablesOutput.View.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotEmpty
    @JsonView(DataTablesOutput.View.class)
    @Column(name = "student_id", length = 100)
    private String studentId;
    
    @NotEmpty
    @JsonView(DataTablesOutput.View.class)
    @Column(name = "student_name", length = 100)
    private String studentName;
   
    @Column(name = "address", length = 100)
    private String address;
    
    @Column(name = "country", length = 100)
    private String country;
    
    @Column(name = "city", length = 100)
    private String city;
    
    @Column(name = "zip_code", length = 100)
    private String zipCode;
    
    @JsonView(DataTablesOutput.View.class)
    @Column(name = "is_active")
    private boolean isActive;
    
    @JsonView(DataTablesOutput.View.class)
    @JoinColumn(name = "major_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Major majorId;

    public Student()
    {
    }

    public Student(Long id)
    {
        this.id = id;
    }

    public Student(Long id, String studentId, String studentName, boolean isActive)
    {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.isActive = isActive;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Major getMajorId()
    {
        return majorId;
    }

    public void setMajorId(Major majorId)
    {
        this.majorId = majorId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student))
        {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.a03lia.university.model.Student[ id=" + id + " ]";
    }

}
