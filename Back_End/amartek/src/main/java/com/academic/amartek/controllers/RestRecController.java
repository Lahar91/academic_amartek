package com.academic.amartek.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.amartek.dto.RecruitmentDto;
import com.academic.amartek.dto.ResponseHandler;
import com.academic.amartek.models.Recruitment;
import com.academic.amartek.services.IJobService;
import com.academic.amartek.services.IRecService;
import com.academic.amartek.services.IUserService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class RestRecController {
    
    private IRecService iRecService;
    private IUserService iUserService;
    private IJobService iJobService;

    public RestRecController(IRecService iRecService, IUserService iUserService, IJobService iJobService) {
        this.iRecService = iRecService;
        this.iUserService = iUserService;
        this.iJobService = iJobService;
    }

    @GetMapping("recruitment")
    public ResponseEntity<Object> get(){
        List<Recruitment> recruitments = iRecService.Get();                          
        return ResponseHandler.getResponse("data ditemukan", HttpStatus.OK, recruitments);
    }

    @GetMapping("recruitment/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        Recruitment recruitment = iRecService.Get(id);                
        return ResponseHandler.getResponse("data ditemukan", HttpStatus.OK, recruitment);        
    }

    @PostMapping("recruitment")
    public ResponseEntity<Object> post(@RequestBody RecruitmentDto recruitment){                  
        Recruitment setRecruitment = new Recruitment();
        setRecruitment.setApplicant(iUserService.getid("USR1"));        
        setRecruitment.setJob(iJobService.Get(recruitment.job));        
        setRecruitment.setStatusTrainer("reviewing");        
        setRecruitment.setStatusHr("reviewing");
        setRecruitment.setStatusApplicant("reviewing");
        // setRecruitment.setApplicant(iUserService.getid(recruitment.applicant));
        // setRecruitment.setHr(null);
        // setRecruitment.setTrainer(null);
        // setRecruitment.setJob(iJobService.Get(recruitment.job));
        // setRecruitment.setDateInterviewTrainer(null);
        // setRecruitment.setStatusTrainer("reviewing");
        // setRecruitment.setDateInterviewHr(null);
        // setRecruitment.setStatusHr("reviewing");
        // setRecruitment.setStatusApplicant("reviewing");
        Boolean result = iRecService.Save(setRecruitment);        

        if(result){
            return ResponseHandler.generateResponse("data berhasil tersimpan", HttpStatus.OK);            
        }else{            
            return ResponseHandler.generateResponse("data gagal tersimpan", HttpStatus.BAD_REQUEST);   
        }
    }

}
