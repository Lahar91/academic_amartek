package com.academic.amartek.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_biodata")
public class Biodata {
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name="id", nullable = false)
    private Users user;

    @Column(name = "fullname")
    private String fullname;
    
    @Column(name = "datebirth")
    private Date datebirth;

    @Column(name = "address")
    private String address;

    @Column(name = "summary")
    private String summary;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public Date getDatebirth() {
        return datebirth;
    }
    public void setDatebirth(Date datebirth) {
        this.datebirth = datebirth;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
}
