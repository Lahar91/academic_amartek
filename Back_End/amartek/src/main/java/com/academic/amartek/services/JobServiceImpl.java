package com.academic.amartek.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academic.amartek.models.Job;
import com.academic.amartek.repositories.IJobRepository;

@Service
public class JobServiceImpl implements IJobService {

    private IJobRepository iJobRepository;

    public JobServiceImpl(IJobRepository iJobRepository) {
        this.iJobRepository = iJobRepository;
    }
    
    @Override
    public List<Job> Get() {
        return iJobRepository.findAll();
    }

    @Override
    public Job Get(Integer id) {
        return iJobRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Data Employee Tidak Ditemukan"));
    }

    @Override
    public Boolean Save(Job job) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Save'");
    }

    @Override
    public Boolean Delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }
    
}
