package com.academic.amartek.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.amartek.dto.JobDto;
import com.academic.amartek.dto.ResponseHandler;
import com.academic.amartek.models.Job;
import com.academic.amartek.services.IJobService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class RestJobController {
    private IJobService iJobService;

    public RestJobController(IJobService iJobService) {
        this.iJobService = iJobService;
    } 

    @GetMapping("job")
    public ResponseEntity<Object> get(){
        List<Job> jobs = iJobService.Get();                          
        return ResponseHandler.generateResponse("data ditemukan", HttpStatus.OK, jobs);
    }

    @GetMapping("job/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        Job job = iJobService.Get(id);                
        return ResponseHandler.generateResponse("data ditemukan", HttpStatus.OK, job);        
    }

    @PostMapping("job")
    public ResponseEntity<Object> post(@RequestBody JobDto job){                  
        Job setJob = new Job();
        setJob.setTitleJob(job.titleJob);
        setJob.setLocation(job.location);
        setJob.setOpenDate(job.openDate);
        setJob.setCloseDate(job.closeDate);
        setJob.setJobDesc(job.jobDesc);
        setJob.setJobRequire(job.jobRequire);
        setJob.setJobBenefit(job.jobBenefit);
        Boolean result = iJobService.Save(setJob);

        if(result){
            return ResponseHandler.generateResponse("data berhasil tersimpan", HttpStatus.OK);            
        }else{            
            return ResponseHandler.generateResponse("data gagal tersimpan", HttpStatus.BAD_REQUEST);   
        }
    }

    @PutMapping("job/{id}")
    public ResponseEntity<Object> put(@RequestBody JobDto job, @PathVariable(required = true) Integer id){
        Job jobById = iJobService.Get(id);
        jobById.setTitleJob(job.titleJob);
        jobById.setLocation(job.location);
        jobById.setOpenDate(job.openDate);
        jobById.setCloseDate(job.closeDate);
        jobById.setJobDesc(job.jobDesc);
        jobById.setJobRequire(job.jobRequire);
        jobById.setJobBenefit(job.jobBenefit);
        Boolean result = iJobService.Save(jobById);
                
        if(result){
            return ResponseHandler.generateResponse("data berhasil diupdate", HttpStatus.OK);
        }else{
            return ResponseHandler.generateResponse("data gagal diupdate", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("job/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id){        
        Boolean result = iJobService.Delete(id);
        if(result){
            return ResponseHandler.generateResponse("data berhasi terhapus", HttpStatus.OK);
        }else{
            return ResponseHandler.generateResponse("data gagal terhapus", HttpStatus.BAD_REQUEST);
        } 
    }  
}
