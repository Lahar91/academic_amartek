package com.academic.amartek.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.amartek.services.ISkillService;

@CrossOrigin()
@RestController
@RequestMapping("api")
public class RestSkillController {
    private ISkillService iSkillService;

    public RestSkillController(ISkillService iSkillService) {
        this.iSkillService = iSkillService;
    }

    // GET ALL
    // localhost:8088/api/skill
    @GetMapping("skill")
    public ResponseEntity<Object> get(){
        Map<String, Object> customResponses = new HashMap<String, Object>();
        customResponses.put("statusCode", HttpStatus.OK.value());
        customResponses.put("message", "Data berhasil diterima");
        customResponses.put("data", iSkillService.Get());                         
        return new ResponseEntity<>(customResponses, HttpStatus.OK);
    }

}
