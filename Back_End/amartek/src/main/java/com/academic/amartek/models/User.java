package com.academic.amartek.models;

import java.util.Set;
import javax.persistence.*;
//test
@Entity
@Table(name = "tb_m_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

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

    @OneToOne(mappedBy = "user")
    private Recruitment recruitment;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public Set<UserSkill> getUserSkill() {
        return userSkill;
    }

    public void setUserSkill(Set<UserSkill> userSkill) {
        this.userSkill = userSkill;
    }

    public Set<Project> getProject(){
        return project;
    }

    public void setProject(Set<Project> project){
        this.project = project;
    }

    public Set<Education> getEducation(){
        return education;
    }

    public void setEducation (Set<Education> education){
        this.education = education;
    }

    public Biodata getBiodata() {
        return biodata;
    }

    public void setBiodata(Biodata biodata) {
        this.biodata = biodata;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruiment) {
        this.recruitment = recruiment;
    }

}
