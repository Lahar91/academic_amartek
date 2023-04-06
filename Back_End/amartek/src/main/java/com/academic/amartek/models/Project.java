// package com.academic.amartek.models.user_management;

// import java.sql.Date;

// import javax.annotation.Generated;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToMany;

// @Entity
// @Table (name ="tb_m_Project")
// public class Project {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

//     @Column(name ="user_id")
//     private String user_id;

//     @Column(name ="name")
//     private String name;

//     @Column(name = "project_start")
//     private Date project_start;

//     @Column(name = "project_end")
//     private Date project_end;

//     @Column(name = "project_desc")
//     private Date project_desc;

//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private Users users;

//     public String getUserId() {
//         return user_id;
//     }
//     public void setUserId(String user_id) {
//         this.user_id = user_id;
//     }

//     public String getName() {
//         return name;
//     }
//     public void setName(String name) {
//         this.name = name;
//     }

//     public Date getProjectStart() {
//         return project_start;
//     }
//     public void setProjectStart(Date project_start) {
//         this.project_start = project_start;
//     }

//     public Date getProjectEnd() {
//         return project_end;
//     }
//     public void setProjectEnd(Date project_end) {
//         this.project_end = project_end;
//     }

//     public Date getProjectDesc() {
//         return project_desc;
//     }
//     public void setProjectDesc(Date project_desc) {
//         this.project_desc = project_desc;
//     }
    
//     public Role getUsers(){
//         return users;
//     }
        
//     public void setUsers(Users users){
//         this.users = users;
//     }
// }
