package com.academic.amartek.dto;

import java.util.Date;

import com.academic.amartek.models.Job;
import com.academic.amartek.models.User;
import com.fasterxml.jackson.annotation.JsonFormat;

public class RecruitmentDto {
    public int id; 
    public User applicant;
    public User hr;   
    public User trainer;
    public Job job; 
    @JsonFormat(pattern = "yyy-MM-dd")
    public Date dateInterviewTrainer;   
    public String statusTrainer; 
    @JsonFormat(pattern = "yyy-MM-dd")
    public Date dateInterviewHr;
    public String statusHr;
    public String statusApplicant;

}
