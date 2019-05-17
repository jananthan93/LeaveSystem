package com.sgic.hrm.par.serviceCombinedImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.dto.mapper.par.ScheduleParAppraisorsMapper;
import com.sgic.hrm.commons.dto.mapper.par.ScheduleParContentMapper;
import com.sgic.hrm.commons.dto.par.ScheduleParAppraisorsDtoGet;
import com.sgic.hrm.commons.dto.par.ScheduleParAppraisorsDtoPost;
import com.sgic.hrm.commons.dto.par.ScheduleParContentDtoGet;
import com.sgic.hrm.commons.dto.par.ScheduleParContentDtoPost;
import com.sgic.hrm.commons.dto.par.ScheduleParDtoGet;
import com.sgic.hrm.commons.dto.par.ScheduleParDtoPost;
import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.entity.par.ParAppraisor;
import com.sgic.hrm.commons.entity.par.ParContent;
import com.sgic.hrm.commons.entity.par.ScheduleParAppraisor;
import com.sgic.hrm.commons.entity.par.ScheduleParContent;
import com.sgic.hrm.par.service.ParAppraisorService;
import com.sgic.hrm.par.service.ParContentService;
import com.sgic.hrm.par.service.ParService;
import com.sgic.hrm.par.service.ScheduleParAppraisorService;
import com.sgic.hrm.par.service.ScheduleParContentService;
import com.sgic.hrm.par.serviceCombined.ParScheduleService;

@Service
public class ParScheduleServiceImpl implements ParScheduleService {

	@Autowired
	ParService parService;

	@Autowired
	ScheduleParAppraisorService scheduleParAppraisorService;

	@Autowired
	ScheduleParContentService scheduleParContentService;

	@Autowired
	ParAppraisorService parAppraiserService;

	@Autowired
	ParContentService parContentService;

	@Override
	public ScheduleParDtoGet getSchedulePar(Integer parId) {
		// find the par by par id
		Par par = parService.findParById(parId);
		ScheduleParDtoGet scheduleParDtoGet = new ScheduleParDtoGet();
		scheduleParDtoGet.setParId(par.getId());
		scheduleParDtoGet.setEmpId(par.getEmpId());
		scheduleParDtoGet.setScheduleDate(par.getScheduleDate());
		Iterator<ScheduleParAppraisor> iteratorScheduledAppraisor = scheduleParAppraisorService
				.findScheduleParAppraisorByParId(par).iterator();

		// find schedule par Appraiser list
		List<ScheduleParAppraisorsDtoGet> listScheduleParAppraisorDTO = new ArrayList<>();
		while (iteratorScheduledAppraisor.hasNext()) {
			ScheduleParAppraisor scheduleParAppraisors = iteratorScheduledAppraisor.next();
			listScheduleParAppraisorDTO.add(ScheduleParAppraisorsMapper.entityToDto(scheduleParAppraisors));
		}

		// find schedule par content list
		Iterator<ScheduleParContent> iteratorScheduleParContent = scheduleParContentService
				.findScheduleParContentByParId(par).iterator();
		List<ScheduleParContentDtoGet> listScheduleParContentDTO = new ArrayList<>();
		while (iteratorScheduleParContent.hasNext()) {
			ScheduleParContent scheduleParContent = iteratorScheduleParContent.next();
			listScheduleParContentDTO.add(ScheduleParContentMapper.entityToDto(scheduleParContent));
		}

		scheduleParDtoGet.setScheduleParAppraisorsList(listScheduleParAppraisorDTO);
		scheduleParDtoGet.setScheduleParContentList(listScheduleParContentDTO);
		return scheduleParDtoGet;
	}

	@Override
	public void createSchedulePar(ScheduleParDtoPost objScheduleParDTO) {
		Par par = new Par();
		par.setEmpId(objScheduleParDTO.getEmpId());
		par.setScheduleDate(objScheduleParDTO.getScheduleDate());
		// save par object
		Par parObj=parService.createPar(par);
		if (parObj !=null) {

			// save Appraisor List
			List<ScheduleParAppraisorsDtoPost> scheduleParAppraisorList = objScheduleParDTO
					.getScheduleParAppraisorsList();
			Iterator<ScheduleParAppraisorsDtoPost> iteratorScheduledAppraisor = scheduleParAppraisorList.iterator();

			int i = 0;
			while (iteratorScheduledAppraisor.hasNext()) {
				String pk = parObj.getId() + "_" + i;
				ScheduleParAppraisorsDtoPost scheduleParAppraisorsDtoPost = iteratorScheduledAppraisor.next();
				ParAppraisor parAppraisor = parAppraiserService
						.findParAppraisorByAppraiserId(scheduleParAppraisorsDtoPost.getAppraisorId());

				scheduleParAppraisorService.createScheduleParAppraisor(
						ScheduleParAppraisorsMapper.dtoToEntity(pk, parAppraisor, scheduleParAppraisorsDtoPost), par);
				i++;
			}

			// save Content List
			List<ScheduleParContentDtoPost> scheduleParContentList = objScheduleParDTO.getScheduleParContentList();
			Iterator<ScheduleParContentDtoPost> iteratorScheduledContent = scheduleParContentList.iterator();
			int j = 0;
			while (iteratorScheduledContent.hasNext()) {
				String pk = parObj.getId() + "_" + j;
				ScheduleParContentDtoPost scheduleParContentDtoPost = iteratorScheduledContent.next();

				ParContent parContent = parContentService
						.findParContentById(scheduleParContentDtoPost.getParContentId());

				scheduleParContentService.createScheduleParContent(
						ScheduleParContentMapper.dtoToEntity(pk, parContent, scheduleParContentDtoPost), par);
				j++;
			}

		}

	}

	@Override
	public void deleteSchedulePar(Integer parId) {
		// TODO Auto-generated method stub
		Par par = parService.findParById(parId);

		Iterator<ScheduleParAppraisor> iteratorScheduledAppraisor = scheduleParAppraisorService
				.findScheduleParAppraisorByParId(par).iterator();

		while (iteratorScheduledAppraisor.hasNext()) {
			ScheduleParAppraisor scheduleParAppraisors = iteratorScheduledAppraisor.next();
			scheduleParAppraisorService.deleteScheduleParAppraisorById(scheduleParAppraisors.getId());
		}

		// find schedule par content list
		Iterator<ScheduleParContent> iteratorScheduleParContent = scheduleParContentService
				.findScheduleParContentByParId(par).iterator();

		while (iteratorScheduleParContent.hasNext()) {
			ScheduleParContent scheduleParContent = iteratorScheduleParContent.next();
			scheduleParContentService.deleteScheduleParContent(scheduleParContent.getId());
		}
		
		parService.deleteParById(parId);

	}

}