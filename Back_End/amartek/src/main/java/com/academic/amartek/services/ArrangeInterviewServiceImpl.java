package com.academic.amartek.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academic.amartek.models.Recruitment;
import com.academic.amartek.repositories.IArrangeInterviewRepository;


/**
 * ArrangeInterviewServiceImpl
 */
@Service
public class ArrangeInterviewServiceImpl implements IArrangeInterviewService{
    @Autowired
    private IArrangeInterviewRepository iArrangeInterviewRepository;

    public ArrangeInterviewServiceImpl(IArrangeInterviewRepository iArrangeInterviewRepository){
        this.iArrangeInterviewRepository = iArrangeInterviewRepository;
    }

    @Override
    public List<Recruitment> GetAll() {
        return iArrangeInterviewRepository.findAll();
    }

    @Override
    public Recruitment Get(Integer id) {
        return iArrangeInterviewRepository.findById(id).orElseThrow(() -> new IllegalStateException("data not found"));
    }

    @Override
    public Boolean Save(Recruitment recruitment) {
        iArrangeInterviewRepository.save(recruitment);
        return iArrangeInterviewRepository.findById(recruitment.getId()).isPresent();
    }
    
}