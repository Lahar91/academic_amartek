package com.academic.amartek.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import com.academic.amartek.dto.BiodataRequestDTO;
import com.academic.amartek.dto.CurriculumVitaeDTO;
import com.academic.amartek.dto.EducationRequestDTO;
import com.academic.amartek.dto.ProjectRequestDTO;
import com.academic.amartek.dto.ResponseHandler;
import com.academic.amartek.dto.UserSkillRequest;
import com.academic.amartek.models.Biodata;
import com.academic.amartek.models.Degree;
import com.academic.amartek.models.Education;
import com.academic.amartek.models.Major;
import com.academic.amartek.models.Project;
import com.academic.amartek.models.Skill;
import com.academic.amartek.models.Univ;
import com.academic.amartek.models.User;
import com.academic.amartek.models.UserSkill;
import com.academic.amartek.repositories.BiodataRepository;
import com.academic.amartek.repositories.CurriculumVitaeRepository;
import com.academic.amartek.repositories.DegreeRepository;
import com.academic.amartek.repositories.EducationRepository;
import com.academic.amartek.repositories.MajorRepository;
import com.academic.amartek.repositories.ProjectRepository;
import com.academic.amartek.repositories.SkillRepository;
import com.academic.amartek.repositories.UnivRepository;
import com.academic.amartek.repositories.UserRepository;
import com.academic.amartek.repositories.UserSkillRepository;
import com.academic.amartek.services.CurriculumVitaeService;
import com.academic.amartek.services.EducationService;
import com.academic.amartek.services.UserSkillService;

@CrossOrigin()
@RestController
@RequestMapping("api")
public class RestCurriculumVitae {

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
    private UserRepository userRepository;
    private UserSkillService userSkillService;

    @Autowired
    public RestCurriculumVitae(EducationService educationService, UnivRepository univRepository, EducationRepository educationRepository, DegreeRepository degreeRepository, SkillRepository skillRepository, UserSkillRepository userSkillRepository,
    BiodataRepository biodataRepository, ProjectRepository projectRepository, MajorRepository majorRepository, UserRepository userRepository, UserSkillService userSkillService) {
        this.educationService = educationService;
        this.univRepository = univRepository;
        this.educationRepository = educationRepository;
        this.degreeRepository = degreeRepository;
        this.skillRepository = skillRepository;
        this.userSkillRepository = userSkillRepository;
        this.biodataRepository = biodataRepository;
        this.projectRepository = projectRepository;
        this.majorRepository = majorRepository;
        this.userRepository = userRepository;
        this.userSkillService = userSkillService;
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

    @PostMapping("cv/userskill")
    public ResponseEntity<Object> saveUserSkill(@RequestBody UserSkillRequest userSkillReq){
        User user = userRepository.getById(userSkillReq.getUser());
        Skill skill = skillRepository.getById(userSkillReq.getSkill());
        UserSkill userSkill = new UserSkill();
        userSkill.setUser(user);
        userSkill.setSkill(skill);
        userSkillRepository.save(userSkill);


            return ResponseHandler.generateResponse("Data Berhasil Disimpan", HttpStatus.OK);
        //return ResponseHandler.generateResponse("Data gagal Disimpan", HttpStatus.BAD_REQUEST);
    }
    @PostMapping("cv/project")
    public ResponseEntity<Object> saveProject(@RequestBody ProjectRequestDTO projectRequestDTO){
        User user = userRepository.getById(projectRequestDTO.getUser());
        Project project = new Project();
        project.setUser(user);
        project.setName(projectRequestDTO.getName());
        project.setProjectStart(projectRequestDTO.getProjectStart());
        project.setProjectEnd(projectRequestDTO.getProjectEnd());
        project.setProjectDesc(projectRequestDTO.getProjectDesc());
        projectRepository.save(project);


            return ResponseHandler.generateResponse("Data Berhasil Disimpan", HttpStatus.OK);
        //return ResponseHandler.generateResponse("Data gagal Disimpan", HttpStatus.BAD_REQUEST);
    }
    @PostMapping("cv/education")
    public ResponseEntity<Object> saveEducation(@RequestBody EducationRequestDTO educationRequestDTO){
        User user = userRepository.getById(educationRequestDTO.getUser());
        Degree degree = degreeRepository.getById(educationRequestDTO.getDegreeId());
        Univ univ = univRepository.getById(educationRequestDTO.getUnivId());
        Major major = majorRepository.getById(educationRequestDTO.getMajorId());
        Education education = new Education();
        education.setUser(user);
        education.setDegree(degree);
        education.setUniv(univ);
        education.setGpa(educationRequestDTO.getGpa());
        education.setMajor(major);
        educationRepository.save(education);

            return ResponseHandler.generateResponse("Data Berhasil Disimpan", HttpStatus.OK);
    }
    @PostMapping("cv/biodata")
    public ResponseEntity<Object> saveBiodata(@RequestBody BiodataRequestDTO biodatareq){
        //User user = userRepository.getById(biodatareq.getUser());
       Biodata biodata = new Biodata();
       //biodata.setId("USR001");
       biodata.setId(biodatareq.getUser());
       biodata.setFullname(biodatareq.getFullname());
       biodata.setDatebirth(biodatareq.getDateBirth());
       biodata.setNoTelp(biodatareq.getNoTelp());
       biodata.setAddress(biodatareq.getAddress());
       biodata.setSummary(biodatareq.getSummary());
       biodataRepository.save(biodata);

            return ResponseHandler.generateResponse("Data Berhasil Disimpan", HttpStatus.OK);
    }
    @PutMapping("cv/userskill/{id}")
    public ResponseEntity<Object> editUserSkill(@PathVariable(required = true) Integer id, @RequestBody UserSkillRequest userSkillReq){
        User user = userRepository.getById(userSkillReq.getUser());
        Skill skill = skillRepository.getById(userSkillReq.getSkill());
        UserSkill userskill = new UserSkill();
        userskill.setId(id);
        userskill.setUser(user);
        userskill.setSkill(skill);
        userSkillRepository.save(userskill);
        return ResponseHandler.generateResponse("Data berhasil diubah", HttpStatus.OK);
    }
    @PutMapping("cv/project/{id}")
    public ResponseEntity<Object> editProject(@PathVariable(required = true) Integer id, @RequestBody ProjectRequestDTO projectRequestDTO){
        User user = userRepository.getById(projectRequestDTO.getUser());
        Project project = new Project();
        project.setId(id);
        project.setUser(user);
        project.setName(projectRequestDTO.getName());
        project.setProjectStart(projectRequestDTO.getProjectStart());
        project.setProjectEnd(projectRequestDTO.getProjectEnd());
        project.setProjectDesc(projectRequestDTO.getProjectDesc());
        projectRepository.save(project);
        return ResponseHandler.generateResponse("Data Berhasil Diubah", HttpStatus.OK);
    }
    @PutMapping("cv/education/{id}")
    public ResponseEntity<Object> editEducation(@PathVariable(required = true) Integer id, @RequestBody EducationRequestDTO educationRequestDTO){
        User user = userRepository.getById(educationRequestDTO.getUser());
        Degree degree = degreeRepository.getById(educationRequestDTO.getDegreeId());
        Univ univ = univRepository.getById(educationRequestDTO.getUnivId());
        Major major = majorRepository.getById(educationRequestDTO.getMajorId());
        Education education = new Education();
        education.setId(id);
        education.setUser(user);
        education.setDegree(degree);
        education.setUniv(univ);
        education.setGpa(educationRequestDTO.getGpa());
        education.setMajor(major);
        educationRepository.save(education);

            return ResponseHandler.generateResponse("Data Berhasil Diubah", HttpStatus.OK);
    }
    @PutMapping("cv/biodata/{userId}")
    public ResponseEntity<Object> editbiodata(@PathVariable(required = true) String userId, @RequestBody BiodataRequestDTO biodatareq){
        //User user = userRepository.getById(biodatareq.getUser());
       Biodata biodata = new Biodata();
       //biodata.setId("USR001");
       biodata.setId(userId);
       biodata.setFullname(biodatareq.getFullname());
       biodata.setDatebirth(biodatareq.getDateBirth());
       biodata.setNoTelp(biodatareq.getNoTelp());
       biodata.setAddress(biodatareq.getAddress());
       biodata.setSummary(biodatareq.getSummary());
       biodataRepository.save(biodata);

            return ResponseHandler.generateResponse("Data Berhasil Diubah", HttpStatus.OK);
    }

    @DeleteMapping("cv/userskill/{id}")
    public ResponseEntity<Object> deleteuserskill(@PathVariable(required = true) Integer id){
    userSkillRepository.deleteUserSkill(id);
    return ResponseHandler.generateResponse("Data Berhasil diHapus", HttpStatus.OK);
    }

    @DeleteMapping("cv/project/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable(required = true) Integer id){
    projectRepository.deleteProject(id);
    return ResponseHandler.generateResponse("Data Berhasil diHapus", HttpStatus.OK);
    }

    @DeleteMapping("cv/education/{id}")
    public ResponseEntity<Object> deleteEducation(@PathVariable(required = true) Integer id){
    educationRepository.deleteEducation(id);
    return ResponseHandler.generateResponse("Data Berhasil diHapus", HttpStatus.OK);
    }

    @DeleteMapping("cv/biodata/{userId}")
    public ResponseEntity<Object> deleteBiodata(@PathVariable(required = true) String userId){
    biodataRepository.deleteBiodata(userId);
    return ResponseHandler.generateResponse("Data Berhasil diHapus", HttpStatus.OK);
    }

}
