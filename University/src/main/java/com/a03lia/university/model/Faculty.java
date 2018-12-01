/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a03lia.university.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a03lia
 */
@Entity
@Table(name = "faculty")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f")
    , @NamedQuery(name = "Faculty.findById", query = "SELECT f FROM Faculty f WHERE f.id = :id")
    , @NamedQuery(name = "Faculty.findByTitle", query = "SELECT f FROM Faculty f WHERE f.title = :title")
    , @NamedQuery(name = "Faculty.findByDescriptions", query = "SELECT f FROM Faculty f WHERE f.descriptions = :descriptions")
    , @NamedQuery(name = "Faculty.findByIsActive", query = "SELECT f FROM Faculty f WHERE f.isActive = :isActive")
})
public class Faculty implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 10)
    private String id;
    @Basic(optional = false)
    @Column(name = "title", nullable = false, length = 80)
    private String title;
    @Column(name = "descriptions", length = 255)
    private String descriptions;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @ManyToMany(mappedBy = "facultySet")
    private Set<Major> majorSet;

    public Faculty()
    {
    }

    public Faculty(String id)
    {
        this.id = id;
    }

    public Faculty(String id, String title, boolean isActive)
    {
        this.id = id;
        this.title = title;
        this.isActive = isActive;
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

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    @XmlTransient
    public Set<Major> getMajorSet()
    {
        return majorSet;
    }

    public void setMajorSet(Set<Major> majorSet)
    {
        this.majorSet = majorSet;
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
        if (!(object instanceof Faculty))
        {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.a03lia.university.model.Faculty[ id=" + id + " ]";
    }
    
}
