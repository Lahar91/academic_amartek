package com.academic.amartek.models;

// import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_m_job")
public class Job {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(name = "title_job", nullable = false)
    private String titleJob;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "open_date", nullable = false)
    private String openDate;

    @Column(name = "close_date", nullable = false)
    private String closeDate;

    @Column(name = "job_desc", nullable = false)
    private String jobDesc;

    @Column(name = "job_require", nullable = false)
    private String jobRequire;

    @Column(name = "job_benefit", nullable = false)
    private String jobBenefit;

    // penghubung ke FK
    // @JsonIgnore
    @OneToOne (mappedBy = "job")    
    public Recruitment recruitment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleJob() {
        return titleJob;
    }

    public void setTitleJob(String titleJob) {
        this.titleJob = titleJob;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobRequire() {
        return jobRequire;
    }

    public void setJobRequire(String jobRequire) {
        this.jobRequire = jobRequire;
    }

    public String getJobBenefit() {
        return jobBenefit;
    }

    public void setJobBenefit(String jobBenefit) {
        this.jobBenefit = jobBenefit;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

}