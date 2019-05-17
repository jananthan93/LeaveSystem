package com.sgic.hrm.par;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgic.hrm.commons.dto.par.ScheduleParAppraisorsDtoPost;
import com.sgic.hrm.commons.dto.par.ScheduleParContentDtoPost;
import com.sgic.hrm.commons.dto.par.ScheduleParDtoPost;
import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.par.serviceCombined.ParScheduleService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParScheduleServiceTest {

	@Autowired
	ParScheduleService parScheduleService;

	@Test
	public void createParScheduleService1() {
		
		ScheduleParDtoPost scheduleParDtoPost=new ScheduleParDtoPost();
		//scheduleParDtoPost.setEmpId("E001");
		//scheduleParDtoPost.setEmpId("EM001");
		scheduleParDtoPost.setScheduleDate(new Date());
		
		List<ScheduleParAppraisorsDtoPost> scheduleParAppraisorList = new ArrayList<ScheduleParAppraisorsDtoPost>();
		scheduleParAppraisorList.add(new ScheduleParAppraisorsDtoPost(1));
		scheduleParAppraisorList.add(new ScheduleParAppraisorsDtoPost(2));

		List<ScheduleParContentDtoPost> scheduleParContentList = new ArrayList<ScheduleParContentDtoPost>();
		scheduleParContentList.add(new ScheduleParContentDtoPost(1));
		scheduleParContentList.add(new ScheduleParContentDtoPost(2));
		scheduleParContentList.add(new ScheduleParContentDtoPost(3));

		scheduleParDtoPost.setScheduleParAppraisorsList(scheduleParAppraisorList);
		scheduleParDtoPost.setScheduleParContentList(scheduleParContentList);
		parScheduleService.createSchedulePar(scheduleParDtoPost);
	}
	
	@Test
	public void createParScheduleService2() {
		
		ScheduleParDtoPost scheduleParDtoPost=new ScheduleParDtoPost();
		//scheduleParDtoPost.setEmpId("E002");
		//scheduleParDtoPost.setEmpId("EM002");
		scheduleParDtoPost.setScheduleDate(new Date());
		
		List<ScheduleParAppraisorsDtoPost> scheduleParAppraisorList = new ArrayList<ScheduleParAppraisorsDtoPost>();
		scheduleParAppraisorList.add(new ScheduleParAppraisorsDtoPost(1));
		scheduleParAppraisorList.add(new ScheduleParAppraisorsDtoPost(2));

		List<ScheduleParContentDtoPost> scheduleParContentList = new ArrayList<ScheduleParContentDtoPost>();
		scheduleParContentList.add(new ScheduleParContentDtoPost(1));
		scheduleParContentList.add(new ScheduleParContentDtoPost(2));
		scheduleParContentList.add(new ScheduleParContentDtoPost(3));

		scheduleParDtoPost.setScheduleParAppraisorsList(scheduleParAppraisorList);
		scheduleParDtoPost.setScheduleParContentList(scheduleParContentList);
		parScheduleService.createSchedulePar(scheduleParDtoPost);
	}
	
	@Test
	public void createParScheduleService3() {
		
		ScheduleParDtoPost scheduleParDtoPost=new ScheduleParDtoPost();
		//scheduleParDtoPost.setEmpId("E003");
		//scheduleParDtoPost.setEmpId("EM003");
		scheduleParDtoPost.setScheduleDate(new Date());
		
		List<ScheduleParAppraisorsDtoPost> scheduleParAppraisorList = new ArrayList<ScheduleParAppraisorsDtoPost>();
		scheduleParAppraisorList.add(new ScheduleParAppraisorsDtoPost(3));
		scheduleParAppraisorList.add(new ScheduleParAppraisorsDtoPost(4));

		List<ScheduleParContentDtoPost> scheduleParContentList = new ArrayList<ScheduleParContentDtoPost>();
		scheduleParContentList.add(new ScheduleParContentDtoPost(1));
		//scheduleParContentList.add(new ScheduleParContentDtoPost("c2"));
		scheduleParContentList.add(new ScheduleParContentDtoPost(3));

		scheduleParDtoPost.setScheduleParAppraisorsList(scheduleParAppraisorList);
		scheduleParDtoPost.setScheduleParContentList(scheduleParContentList);
		parScheduleService.createSchedulePar(scheduleParDtoPost);
	}
	
	@Test
	public void createParScheduleService4() {
		parScheduleService.deleteSchedulePar(3);
	}
	
	@Test
	public void createParScheduleService5() {
		parScheduleService.deleteSchedulePar(2);
	}
}