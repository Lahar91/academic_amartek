package com.academic.amartek.dto;

import java.util.Date;

public class CurriculumVitaeDTO {
    private String userId;
    private String email;
    private String bId;
    private String fullname;
    private Date birthDate;
    private String noTelp;
    private String address;
    private String summary;
    private String skillName;
    private String projectName;
    private Date projectStart;
    private Date projectEnd;
    private String projectDesc;
    private String degreeName;
    private String univName;
    private String majorName;
    private Double gpa;
    
    public CurriculumVitaeDTO(String userId, String email, String bId, String fullname, Date birthDate, String noTelp,
            String address, String summary, String skillName, String projectName, Date projectStart, Date projectEnd,
            String projectDesc, String degreeName, String univName, String majorName, Double gpa) {
        this.userId = userId;
        this.email = email;
        this.bId = bId;
        this.fullname = fullname;
        this.birthDate = birthDate;
        this.noTelp = noTelp;
        this.address = address;
        this.summary = summary;
        this.skillName = skillName;
        this.projectName = projectName;
        this.projectStart = projectStart;
        this.projectEnd = projectEnd;
        this.projectDesc = projectDesc;
        this.degreeName = degreeName;
        this.univName = univName;
        this.majorName = majorName;
        this.gpa = gpa;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getbId() {
        return bId;
    }
    public void setbId(String bId) {
        this.bId = bId;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
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
    public String getSkillName() {
        return skillName;
    }
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public Date getProjectStart() {
        return projectStart;
    }
    public void setProjectStart(Date projectStart) {
        this.projectStart = projectStart;
    }
    public Date getProjectEnd() {
        return projectEnd;
    }
    public void setProjectEnd(Date projectEnd) {
        this.projectEnd = projectEnd;
    }
    public String getProjectDesc() {
        return projectDesc;
    }
    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }
    public String getDegreeName() {
        return degreeName;
    }
    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
    public String getUnivName() {
        return univName;
    }
    public void setUnivName(String univName) {
        this.univName = univName;
    }
    public String getMajorName() {
        return majorName;
    }
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
    public Double getGpa() {
        return gpa;
    }
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

}