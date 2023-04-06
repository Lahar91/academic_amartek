package com.academic.amartek.services;

import com.academic.amartek.models.Recruitment;


public interface IArrangeInterviewService {
    
    public Recruitment Get(Integer id);
    public Boolean Save (Recruitment recruitment);
    // public Boolean  Delete(Integer id);
}
