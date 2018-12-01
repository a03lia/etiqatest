package com.a03lia.university.model;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author a03lia
 */
public class StudentForm
{
    private Long id;

    @NotEmpty
    private String studentId;

    @NotEmpty
    private String studentName;

    private String address;

    private String country;

    private String city;

    private String zipCode;

    private boolean isActive;

    private String majorId;

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

    public boolean isIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public String getMajorId()
    {
        return majorId;
    }

    public void setMajorId(String majorId)
    {
        this.majorId = majorId;
    }
    
    
}
