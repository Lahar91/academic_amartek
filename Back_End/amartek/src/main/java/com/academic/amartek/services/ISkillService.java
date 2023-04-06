package com.academic.amartek.services;

import java.util.List;

import com.academic.amartek.models.Skill;

public interface ISkillService {
    public List<Skill> Get(); 
    public Skill Get(Integer id); 
    public Boolean Save(Skill skill); 
    public Boolean Delete(Integer id); 
}
