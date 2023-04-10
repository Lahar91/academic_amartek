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
import com.academic.amartek.services.IRecService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class RestRecController {
    
    private IRecService iRecService;

    public RestRecController(IRecService iRecService) {
        this.iRecService = iRecService;
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
        setRecruitment.setApplicant(recruitment.applicant);
        setRecruitment.setHr(recruitment.hr);
        setRecruitment.setTrainer(recruitment.trainer);
        setRecruitment.setJob(recruitment.job);
        setRecruitment.setDateInterviewTrainer(recruitment.dateInterviewTrainer);
        setRecruitment.setStatusTrainer(recruitment.statusTrainer);
        setRecruitment.setDateInterviewHr(recruitment.dateInterviewHr);
        setRecruitment.setStatusHr(recruitment.statusHr);
        setRecruitment.setStatusApplicant(recruitment.statusApplicant);
        Boolean result = iRecService.Save(setRecruitment);        

        if(result){
            return ResponseHandler.generateResponse("data berhasil tersimpan", HttpStatus.OK);            
        }else{            
            return ResponseHandler.generateResponse("data gagal tersimpan", HttpStatus.BAD_REQUEST);   
        }
    }

}
