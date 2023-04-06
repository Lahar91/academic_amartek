package com.academic.amartek.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_m_skill")
public class Skill {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(name = "skill_name", nullable = false)
    private String skillName;

    // penghubung ke FK
    @OneToMany(mappedBy = "skill")
    public Set<UserSkill> userSkill;
}
