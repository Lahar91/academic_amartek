package com.academic.amartek.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tb_tr_recruitment")
public class Recruitment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;


    // fks

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="applicant_id", nullable = false)
    private User applicat;

    public User getApplicat() {
        return applicat;
    }
    public void setApplicat(User applicat) {
        this.applicat = applicat;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hr_id", nullable = false)
    private User hr;

    public User getHr() {
        return hr;
    }
    public void setHr(User hr) {
        this.hr = hr;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="trainer_id", nullable = false)
    private User trainer;


    public User getTrainer() {
        return trainer;
    }
    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }

    @OneToOne
    @JoinColumn(name="job_id", nullable = false)
    private Job job;

    // public Job getJob() {
    //     return job;
    // }
    // public void setJob(Job job) {
    //     this.job = job;
    // }

    @Column(name="date_interview_trainer")
    private Date dateinterviewtrainer;
   
    @Column(name="status_trainer")
    private String statustrainer;
    
    @Column(name="date_interview_hr")
    private Date dateinterviewhr;
  

    @Column(name = "status_hr")
    private String statushr;
 
    @Column(name = "status_applicant")
    private String statusapplicant;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    public Date getDateinterviewtrainer() {
        return dateinterviewtrainer;
    }
    public void setDateinterviewtrainer(Date dateinterviewtrainer) {
        this.dateinterviewtrainer = dateinterviewtrainer;
    }
 
    public String getStatustrainer() {
        return statustrainer;
    }
    public void setStatus_trainer(String statustrainer) {
        this.statustrainer = statustrainer;
    }
  
    public Date getDate_interview_hr() {
        return dateinterviewhr;
    }
    public void setDate_interview_hr(Date dateinterviewhr) {
        this.dateinterviewhr = dateinterviewhr;
    }

    public String getStatushr() {
        return statushr;
    }
    public void setStatus_hr(String statushr) {
        this.statushr = statushr;
    }
    
    public String getStatusapplicant() {
        return statusapplicant;
    }
    public void setStatus_applicant(String statusapplicant) {
        this.statusapplicant = statusapplicant;
    }
}
