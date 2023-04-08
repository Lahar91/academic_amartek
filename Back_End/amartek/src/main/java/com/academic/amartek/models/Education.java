package com.academic.amartek.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_tr_education")
public class Education {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    // @ManyToOne
    // @JoinColumn (name = "user_id")
    // private User user;
    @Column(name = "user_id")
    private String userId;    
    // @Column(name = "degree_id")
    // private Integer degreeId;
    @Column(name = "univ_id")
    private Integer univId;
    @Column(name = "major_id")
    private Integer majorId;

    @ManyToOne
    @JoinColumn (name = "degree_id")
    private Degree degree;
    // @OneToMany(mappedBy = "education")
    // private Set<Degree> degree;
    
    // @ManyToOne
    // @JoinColumn (name = "univ_id")
    // private Univ univ;

    @Column ( name = "gpa")
    private String gpa;

    // @ManyToOne
    // @JoinColumn (name = "major_id")
    // private Major major;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // public User getUser() {
    //     return user;
    // }

    // public void setUser(User user) {
    //     this.user = user;
    // }    

    // public Degree getDegree() {
    //     return degree;
    // }

    // public void setDegree(Degree degree) {
    //     this.degree = degree;
    // }

    // public Univ getUniv() {
    //     return univ;
    // }

    // public void setUniv(Univ univ) {
    //     this.univ = univ;
    // }

    // public String getGpa() {
    //     return gpa;
    // }

    // public void setGpa(String gpa) {
    //     this.gpa = gpa;
    // }

    // public Major getMajor() {
    //     return major;
    // }

    // public void setMajor(Major major) {
    //     this.major = major;
    // }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Integer getUnivId() {
        return univId;
    }

    public void setUnivId(Integer univId) {
        this.univId = univId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    
}
