package com.academic.amartek.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.amartek.dto.CurriculumVitaeDTO;
import com.academic.amartek.dto.ResponseHandler;
import com.academic.amartek.models.Degree;
import com.academic.amartek.models.Education;
import com.academic.amartek.repositories.BiodataRepository;
import com.academic.amartek.repositories.CurriculumVitaeRepository;
import com.academic.amartek.repositories.DegreeRepository;
import com.academic.amartek.repositories.EducationRepository;
import com.academic.amartek.repositories.MajorRepository;
import com.academic.amartek.repositories.ProjectRepository;
import com.academic.amartek.repositories.SkillRepository;
import com.academic.amartek.repositories.UnivRepository;
import com.academic.amartek.repositories.UserSkillRepository;
import com.academic.amartek.services.CurriculumVitaeService;
import com.academic.amartek.services.EducationService;


@RestController
@RequestMapping("api")
public class RestCurriculumVitae {
    // @Autowired
    // private CurriculumVitaeService curriculumVitaeService;

    // @Autowired
    // public RestCurriculumVitae(CurriculumVitaeService curriculumVitaeService) {
    //     this.curriculumVitaeService = curriculumVitaeService;
    // }

    // @GetMapping("curriculumvitae/{userId}")
    // public ResponseEntity<Object> GetCurriculumVitae(@PathVariable(required = true) String userId){
    //    // CurriculumVitaeDTO getcurriculumeVitaeDTO = curriculumVitaeService.getCurriculumVitaeDTO("USR001");
    //     return ResponseHandler.getResponse("Data Ditemukan", HttpStatus.OK, curriculumVitaeService.getCurriculumVitaeDTO(userId));
    //        // return new ResponseEntity<>(customResponse, HttpStatus.OK);
    //     }

    private EducationService educationService;
    private EducationRepository educationRepository;
    private UnivRepository univRepository;
    private DegreeRepository degreeRepository;
    private CurriculumVitaeRepository curriculumVitaeRepository;
    private SkillRepository skillRepository;
    private UserSkillRepository userSkillRepository;
    private BiodataRepository biodataRepository;
    private ProjectRepository projectRepository;
    private MajorRepository majorRepository;

    @Autowired
    public RestCurriculumVitae(EducationService educationService, UnivRepository univRepository, EducationRepository educationRepository, DegreeRepository degreeRepository, SkillRepository skillRepository, UserSkillRepository userSkillRepository,
    BiodataRepository biodataRepository, ProjectRepository projectRepository, MajorRepository majorRepository) {
        this.educationService = educationService;
        this.univRepository = univRepository;
        this.educationRepository = educationRepository;
        this.degreeRepository = degreeRepository;
        this.skillRepository = skillRepository;
        this.userSkillRepository = userSkillRepository;
        this.biodataRepository = biodataRepository;
        this.projectRepository = projectRepository;
        this.majorRepository = majorRepository;
    }
    @GetMapping("cv/assemble/{userId}")
    public ResponseEntity<Object> GetCurriculumVitae(@PathVariable(required = true) String userId){
        // Map<String, Object> testdata= new HashMap<>();
        // List<Education> educate = educationService.GetAll();
        // testdata.put("educate", educate);
        // List<Degree> degrees = degreeRepository.findAll();
        // testdata.put("degree", degrees);
      
        return ResponseHandler.getResponse("Data Ditemukan", HttpStatus.OK, educationRepository.getCV(userId));
    }
    @GetMapping("cv/userskill/{userId}")
    public ResponseEntity<Object> getUserSkill(@PathVariable(required = true) String userId){
        return ResponseHandler.getResponse("Data Ditemukan", HttpStatus.OK, userSkillRepository.getUserSkill(userId));
    }

    @GetMapping("cv/biodata/{userId}")
    public ResponseEntity<Object> getBiodata(@PathVariable(required = true) String userId){
        return ResponseHandler.getResponse("Data Ditemukan", HttpStatus.OK, biodataRepository.getBiodata(userId));
    }

    @GetMapping("cv/education/{userId}")
    public ResponseEntity<Object> getEducation(@PathVariable(required = true) String userId){
        return ResponseHandler.getResponse("Data Ditemukan", HttpStatus.OK, educationRepository.getEducations(userId));
    }
    @GetMapping("cv/project/{userId}")
    public ResponseEntity<Object> getProject(@PathVariable(required = true) String userId){
        return ResponseHandler.getResponse("Data Ditemukan", HttpStatus.OK, projectRepository.getProject(userId));
    }
    @GetMapping("cv/skill")
    public ResponseEntity<Object> GetSkill(){
        return ResponseHandler.getResponse("Data Ditemukan", HttpStatus.OK, skillRepository.getSkill());
    }

    @GetMapping("cv/degree")
    public ResponseEntity<Object> GetDegree(){
        return ResponseHandler.getResponse("Data Ditemukan", HttpStatus.OK, degreeRepository.GetDegree());
    }
    @GetMapping("cv/univ")
    public ResponseEntity<Object> GetUniv(){
        return ResponseHandler.getResponse("Data Ditemukan", HttpStatus.OK, univRepository.GetUniv());
    }
    @GetMapping("cv/major")
    public ResponseEntity<Object> GetMajor(){
        return ResponseHandler.getResponse("Data Ditemukan", HttpStatus.OK, majorRepository.GetMajor());
    }
    
}
