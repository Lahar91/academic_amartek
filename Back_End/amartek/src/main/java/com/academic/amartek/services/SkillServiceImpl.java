package com.academic.amartek.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academic.amartek.models.Skill;
import com.academic.amartek.repositories.ISkillRepository;

@Service
public class SkillServiceImpl implements ISkillService {

    private ISkillRepository iSkillRepository;

    public SkillServiceImpl(ISkillRepository iSkillRepository) {
        this.iSkillRepository = iSkillRepository;
    }

    @Override
    public List<Skill> Get() {
        return iSkillRepository.findAll();
    }

    @Override
    public Skill Get(Integer id) {
        return iSkillRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Data Skill Tidak Ditemukan"));
    }

    @Override
    public Boolean Save(Skill skill) {
        iSkillRepository.save(skill);
        return iSkillRepository.findById(skill.getId()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        iSkillRepository.deleteById(id);
        return !iSkillRepository.findById(id).isPresent();
    }
    
}
