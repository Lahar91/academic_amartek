package com.academic.amartek.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academic.amartek.models.Recruitment;
import com.academic.amartek.repositories.IRecRepository;

@Service
public class RecServiceImpl implements IRecService {

    private IRecRepository iRecRepository;

    public RecServiceImpl(IRecRepository iRecRepository) {
        this.iRecRepository = iRecRepository;
    }

    @Override
    public List<Recruitment> Get() {
        return iRecRepository.findAll();
    }

    @Override
    public Recruitment Get(Integer id) {
        return iRecRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Data Recruitment Tidak Ditemukan"));
    }

    @Override
    public Boolean Save(Recruitment job) {
        iRecRepository.save(job);
        return iRecRepository.findById(job.getId()).isPresent();
    }
    
}
