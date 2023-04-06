package com.academic.amartek;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.academic.amartek.models.Skill;
import com.academic.amartek.services.ISkillService;

@SpringBootTest
class AmartekApplicationTests {

	private ISkillService iSkillService;

	@Autowired
	public AmartekApplicationTests(ISkillService iSkillService) {
		this.iSkillService = iSkillService;
	}

	@Test
	void insertSkill(){
		// arrange				
		Skill skill = new Skill();		
		skill.setSkillName("Python Programming");		
		//act
		Boolean result = iSkillService.Save(skill);
		// assert
		Assertions.assertThat(result).isEqualTo(true);
	}

}
