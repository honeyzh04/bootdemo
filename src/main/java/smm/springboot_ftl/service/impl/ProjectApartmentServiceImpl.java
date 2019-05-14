/**
 * 
 */
package smm.springboot_ftl.service.impl;


import smm.springboot_ftl.bean.ProjectApartmentFormMap;
import smm.springboot_ftl.mapper.ProjectApartmentMapper;

import smm.springboot_ftl.service.ProjectApartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月24日
   @version 1.00
 */
@Service
public class ProjectApartmentServiceImpl implements ProjectApartmentService {
	@Resource
	private ProjectApartmentMapper projectApartmentMapper;



	//经纪人小程序接口
	@Override
	public List<ProjectApartmentFormMap> findAgentProjects(Map searchMapMap) {
		return  projectApartmentMapper.findAgentProjects(searchMapMap);
	}

	@Override
	public ProjectApartmentFormMap findbyAgentProject(String id) {
		return projectApartmentMapper.findbyAgentProject(id);
	}
	@Override
	public void addAgentProjects(HashMap formMap) {

		projectApartmentMapper.addAgentProject(formMap);
	}
	@Override
	public void editAgentProject(HashMap formMap) {
		projectApartmentMapper.editAgentProject(formMap);
	}

	@Override
	public void deleteAgentEntity(String id) {
		projectApartmentMapper.deleteAgentProject(id);
	}

	@Override
	public List<ProjectApartmentFormMap> findAgentImg(Map imgForMap) {
		return projectApartmentMapper.findAgentImg(imgForMap);
	}

	@Override
	public void addAgentImg(HashMap imgFormMap) {
		projectApartmentMapper.addAgentImg(imgFormMap);
	}

	@Override
	public void deleteAgentImg(String id) {
		projectApartmentMapper.deleteAgentImg(id);
	}
}
	


	



