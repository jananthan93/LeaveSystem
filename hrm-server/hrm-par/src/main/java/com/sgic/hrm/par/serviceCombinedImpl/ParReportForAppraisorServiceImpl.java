package com.sgic.hrm.par.serviceCombinedImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.dto.mapper.par.ScoreParAppraiserMapper;
import com.sgic.hrm.commons.dto.par.ParAppraisorDto;
import com.sgic.hrm.commons.dto.par.ReportParAppraisorDtoGet;
import com.sgic.hrm.commons.dto.par.ReportParAppraisorDtoPost;
import com.sgic.hrm.commons.dto.par.ScoreParAppraiserDtoGet;
import com.sgic.hrm.commons.dto.par.ScoreParAppraiserDtoPost;
import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.entity.par.ParAppraisor;
import com.sgic.hrm.commons.entity.par.ParContent;
import com.sgic.hrm.commons.entity.par.ReportParAppraisor;
import com.sgic.hrm.commons.entity.par.ScoreParAppraisor;
import com.sgic.hrm.par.service.ParAppraisorService;
import com.sgic.hrm.par.service.ParContentService;
import com.sgic.hrm.par.service.ParService;
import com.sgic.hrm.par.service.ReportParAppraisorService;
import com.sgic.hrm.par.service.ScoreParAppraisorService;
import com.sgic.hrm.par.serviceCombined.ParReportForAppraisorService;

@Service
public class ParReportForAppraisorServiceImpl implements ParReportForAppraisorService {
	@Autowired
	ParService parService;
	@Autowired
	ReportParAppraisorService reportParAppraisorService;
	@Autowired
	ScoreParAppraisorService scoreParAppraisorService;
	@Autowired
	ParAppraisorService parAppraisorService;
	@Autowired
	ParContentService parContentService;

	

	@Override
	public String saveReportAndScoreAppraisor(ReportParAppraisorDtoPost reportParAppraisorDtoPost,Integer parId) {
		String msg = null;
		
		Par parObj = parService.findParById(parId);
		// sequence of steps goes here with proper validation
		if (parObj != null) {
			int reportsize=reportParAppraisorService.findReportParAppraiserByPar(parObj).size();
			int newReportNo=reportsize+1;
			String pkreport=parObj.getId()+"_"+newReportNo;
			
			if (reportParAppraisorService.findReportParAppraisorById(pkreport) == null) {
				ReportParAppraisor reportParAppraisor = new ReportParAppraisor();
				// Mapping goes here
				ParAppraisor parAppraisor=parAppraisorService.findParAppraisorByAppraiserId(reportParAppraisorDtoPost.getAppraisedById());
				reportParAppraisor.setId(pkreport);
				reportParAppraisor.setParAppraisor(parAppraisor);
				
				
				reportParAppraisorService.createReportParAppraise(reportParAppraisor, parObj);
				Iterator<ScoreParAppraiserDtoPost> iteratorDTO = reportParAppraisorDtoPost.getScoreParAppraiserList()
						.iterator();
				int i = 0;
				while (iteratorDTO.hasNext()) {
					String pk = reportParAppraisor.getId() + "_" + i;
					ScoreParAppraiserDtoPost scoreParAppraiserDtoPost=iteratorDTO.next();
					ParContent parContent=parContentService.findParContentById(scoreParAppraiserDtoPost.getParContentId());
					scoreParAppraisorService.createScoreParAppraisor(
							ScoreParAppraiserMapper.dtoToEntity(pk, parContent,scoreParAppraiserDtoPost), reportParAppraisor);
					i++;
				}

		
			} else {
				msg = "report id is already exist";
			}

		} else {
			msg = "par id is not found";
		}
		return msg;
	}

	@Override
	public List<ReportParAppraisorDtoGet> getParReportForAppraiserByParId (Integer parId) {

		// find par by id
		Par par = parService.findParById(parId);
		// set the par id at dto

		// find the report by par id and the dto
		List<ReportParAppraisor> reportParAppraiserList = reportParAppraisorService.findReportParAppraiserByPar(par);
		
		List<ReportParAppraisorDtoGet> reportParAppraisorDtoGetList=new ArrayList<>();
		
		for (ReportParAppraisor reportParAppraisor : reportParAppraiserList) {
			ReportParAppraisorDtoGet reportParAppraisorDtoGet = new ReportParAppraisorDtoGet();
			//to be in mapper
			ParAppraisor parAppraisor=parAppraisorService.findParAppraisorByAppraiserId(reportParAppraisor.getParAppraisor().getAppraiserId());
			//to be in dto map appraisor
			ParAppraisorDto parAppraisorDto=new ParAppraisorDto();
			parAppraisorDto.setAppraiserId(parAppraisor.getAppraiserId());
			parAppraisorDto.setAppraiserEmpId(parAppraisor.getEmpId());
			parAppraisorDto.setAppraiserName(parAppraisor.getEmpName());
			
			reportParAppraisorDtoGet.setAppraisedBy(parAppraisorDto);
			
			

			Iterator<ScoreParAppraisor> iteratorDTO = scoreParAppraisorService.getScore(reportParAppraisor).iterator();

		
			// dto score list
			List<ScoreParAppraiserDtoGet> scoreParAppraiserDtoGetList = new ArrayList<>();
//			
//			// loop to pull values and set to dto list
			while (iteratorDTO.hasNext()) {
				ScoreParAppraiserDtoGet scoreParAppraiserDtoGet = new ScoreParAppraiserDtoGet();

				ScoreParAppraisor scoreParAppraiser = iteratorDTO.next();

				// to be enhance more by finding method
				scoreParAppraiserDtoGet.setParContentId(scoreParAppraiser.getParContent().getId());
				scoreParAppraiserDtoGet.setParContentName(scoreParAppraiser.getParContent().getContentName());
				scoreParAppraiserDtoGet.setScore(scoreParAppraiser.getScore());

				scoreParAppraiserDtoGetList.add(scoreParAppraiserDtoGet);

			}
			reportParAppraisorDtoGet.setScoreParAppraiserList(scoreParAppraiserDtoGetList);
			reportParAppraisorDtoGetList.add(reportParAppraisorDtoGet);
			
		}

		return reportParAppraisorDtoGetList;
	}

}