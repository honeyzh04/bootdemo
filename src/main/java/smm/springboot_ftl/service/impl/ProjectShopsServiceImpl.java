/**
 * 
 */
package smm.springboot_ftl.service.impl;

import smm.springboot_ftl.bean.ProjectShopsFormMap;
import smm.springboot_ftl.mapper.ProjectShopsMapper;
import smm.springboot_ftl.service.ProjectShopsService;
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
public class ProjectShopsServiceImpl implements ProjectShopsService {
	@Resource
	private ProjectShopsMapper projectShopsMapper;



	//经纪人小程序接口
	@Override
	public List<ProjectShopsFormMap> findAgentProjects(Map searchMapMap) {
		return  projectShopsMapper.findAgentProjects(searchMapMap);
	}

	@Override
	public ProjectShopsFormMap findbyAgentProject(String id) {
		return projectShopsMapper.findbyAgentProject(id);
	}
	@Override
	public void addAgentProjects( HashMap formMap) {

			projectShopsMapper.addAgentProject(formMap);
	}
	@Override
	public void editAgentProject( HashMap formMap) {
		projectShopsMapper.editAgentProject(formMap);
	}

	@Override
	public void deleteAgentEntity(String id) {
		projectShopsMapper.deleteAgentProject(id);
	}

	@Override
	public List<ProjectShopsFormMap> findAgentImg(Map imgForMap) {
		return projectShopsMapper.findAgentImg(imgForMap);
	}

	@Override
	public void addAgentImg(HashMap imgFormMap) {
		projectShopsMapper.addAgentImg(imgFormMap);
	}

	@Override
	public void deleteAgentImg(String id) {
		projectShopsMapper.deleteAgentImg(id);
	}
}
	


	



