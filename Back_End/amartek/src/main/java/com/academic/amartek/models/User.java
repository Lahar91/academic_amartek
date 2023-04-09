package com.academic.amartek.models;

import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_m_user")
public class User {
    @Id
    // @GeneratedValue(generator = "custom-id")
    // @GenericGenerator(name = "custom-id", strategy = "com.academic.amartek.config.CustomIdGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name ="password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    public Set<UserSkill> userSkill;

    @OneToMany(mappedBy = "user")
    public Set<Project> project;

    @OneToMany(mappedBy = "user")
    public Set<Education> education;

    @OneToOne (mappedBy = "user")
    private Biodata biodata;

    @OneToOne(mappedBy = "applicant")
    private Recruitment applicat;

    @OneToOne(mappedBy = "trainer")
    private Recruitment trainer;

    @OneToOne(mappedBy = "hr")
    private Recruitment hr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<UserSkill> getUserSkill() {
        return userSkill;
    }

    public void setUserSkill(Set<UserSkill> userSkill) {
        this.userSkill = userSkill;
    }

    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }

    public Set<Education> getEducation() {
        return education;
    }

    public void setEducation(Set<Education> education) {
        this.education = education;
    }

    public Biodata getBiodata() {
        return biodata;
    }

    public void setBiodata(Biodata biodata) {
        this.biodata = biodata;
    }

    public Recruitment getApplicat() {
        return applicat;
    }

    public void setApplicat(Recruitment applicat) {
        this.applicat = applicat;
    }

    public Recruitment getTrainer() {
        return trainer;
    }

    public void setTrainer(Recruitment trainer) {
        this.trainer = trainer;
    }

    public Recruitment getHr() {
        return hr;
    }

    public void setHr(Recruitment hr) {
        this.hr = hr;
    }

}