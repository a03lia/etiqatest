/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a03lia.university.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

/**
 *
 * @author a03lia
 */
@Entity
@Table(name = "major")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Major.findAll", query = "SELECT m FROM Major m")
    , @NamedQuery(name = "Major.findById", query = "SELECT m FROM Major m WHERE m.id = :id")
    , @NamedQuery(name = "Major.findByTitle", query = "SELECT m FROM Major m WHERE m.title = :title")
    , @NamedQuery(name = "Major.findByDescriptions", query = "SELECT m FROM Major m WHERE m.descriptions = :descriptions")
    , @NamedQuery(name = "Major.findByIsActive", query = "SELECT m FROM Major m WHERE m.isActive = :isActive")
})
public class Major implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 80)
    private String id;
    @Basic(optional = false)
    @Column(name = "title", nullable = false, length = 100)
    @JsonView(DataTablesOutput.View.class)
    private String title;
    @Column(name = "descriptions", length = 255)
    @JsonView(DataTablesOutput.View.class)
    private String descriptions;
    @Column(name = "is_active")
    private Boolean isActive;
    @JoinTable(name = "faculty_major", joinColumns =
    {
        @JoinColumn(name = "major_id", referencedColumnName = "id", nullable = false)
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "faculty_id", referencedColumnName = "id", nullable = false)
    })
    @ManyToMany
    private Set<Faculty> facultySet;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "majorId")
    private Set<Student> studentSet;

    public Major()
    {
    }

    public Major(String id)
    {
        this.id = id;
    }

    public Major(String id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(String descriptions)
    {
        this.descriptions = descriptions;
    }

    public Boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(Boolean isActive)
    {
        this.isActive = isActive;
    }

    @JsonIgnore
    @XmlTransient
    public Set<Faculty> getFacultySet()
    {
        return facultySet;
    }

    public void setFacultySet(Set<Faculty> facultySet)
    {
        this.facultySet = facultySet;
    }

    @JsonIgnore
    @XmlTransient
    public Set<Student> getStudentSet()
    {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet)
    {
        this.studentSet = studentSet;
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
        if (!(object instanceof Major))
        {
            return false;
        }
        Major other = (Major) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString()
    {
        return "com.a03lia.university.model.Major[ id=" + id + " ]";
    }
    
}
