package com.academic.amartek.models;

import javax.persistence.GenerationType;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tb_m_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "Role")
    public Set<Users> users;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Users> getUsers() {
        return users;
    }
    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}