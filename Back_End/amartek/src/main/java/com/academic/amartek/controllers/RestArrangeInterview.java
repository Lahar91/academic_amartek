package com.academic.amartek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.amartek.dto.Response;
import com.academic.amartek.dto.ResponseHandler;
import com.academic.amartek.models.Recruitment;
import com.academic.amartek.services.IArrangeInterviewService;

@CrossOrigin()
@RestController
@RequestMapping("api")
public class RestArrangeInterview {
    @Autowired
    private IArrangeInterviewService iArrangeInterviewService;

    public RestArrangeInterview(IArrangeInterviewService iArrangeInterviewService){
        this.iArrangeInterviewService = iArrangeInterviewService;
    }

    @GetMapping("interview")
    public ResponseEntity<Object> Get() {
        List<Recruitment> recruitment = iArrangeInterviewService.GetAll();
        return ResponseHandler.generateResponse("Data di update", HttpStatus.OK, recruitment);
    }

    @GetMapping("interview/{id}")
    public Recruitment Get(@PathVariable(required = true) Integer id) {
        Recruitment recruitment = iArrangeInterviewService.Get(id);
        return recruitment;
    }

    @PutMapping("interview/{id}")
    public ResponseEntity<Object> Save(@RequestBody Recruitment recruitment, @PathVariable(required = true) Integer id) {
        Recruitment setrecruitment = iArrangeInterviewService.Get(id);
        setrecruitment.setDateInterviewHr(recruitment.getDateInterviewHr());
        if (setrecruitment.getDateInterviewHr() != null) {
            return Response.generateResponse("Data di update", HttpStatus.OK);

        }else{
            return Response.generateResponse("Data gagal di update", HttpStatus.BAD_REQUEST);
        }
    }

}
