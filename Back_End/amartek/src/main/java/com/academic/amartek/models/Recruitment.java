package com.academic.amartek.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_tr_recruitment")
public class Recruitment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private int applicant_id;
    private int hr_id;
    private int trainer_id;
    private int job_id;
    
    
    // fk

    @OneToOne
    @JoinColumn(name="id", nullable = false)
    private Users user;
    
    @OneToOne
    @JoinColumn(name="id", nullable = false)
    private Job job;

    @Column(name="date_interview_trainer")
    private Date dateinterviewtrainer;
   
    @Column(name="status_trainer")
    private String statustrainer;
    
    @Column(name="data_interview_hr")
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
    public int getApplicant_id() {
        return applicant_id;
    }
    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }
    public int getHr_id() {
        return hr_id;
    }
    public void setHr_id(int hr_id) {
        this.hr_id = hr_id;
    }
    public int gettrainer_id() {
        return trainer_id;
    }
    public void settrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }
    public int getJob_id() {
        return job_id;
    }
    public void setJob_id(int job_id) {
        this.job_id = job_id;
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
