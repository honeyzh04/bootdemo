/**
 * 
 */
package smm.springboot_ftl.service.impl;

import smm.springboot_ftl.bean.ProjectHomeFormMap;
import smm.springboot_ftl.mapper.ProjectHomeMapper;
import smm.springboot_ftl.service.ProjectHomeService;
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
public class ProjectHomeServiceImpl implements ProjectHomeService {
	@Resource
	private ProjectHomeMapper projectHomeMapper;


	//经纪人小程序接口
	@Override
	public List<ProjectHomeFormMap> findAgentProjects(Map searchMapMap) {
		return  projectHomeMapper.findAgentProjects(searchMapMap);
	}

	@Override
	public ProjectHomeFormMap findbyAgentProject(String id) {
		return projectHomeMapper.findbyAgentProject(id);
	}
	@Override
	public void addAgentProjects(HashMap formMap) {

		projectHomeMapper.addAgentProject(formMap);
	}
	@Override
	public void editAgentProject(HashMap formMap) {
		projectHomeMapper.editAgentProject(formMap);
	}

	@Override
	public void deleteAgentEntity(String id) {
		projectHomeMapper.deleteAgentProject(id);
	}

	@Override
	public List<ProjectHomeFormMap> findAgentImg(Map imgForMap) {
		return projectHomeMapper.findAgentImg(imgForMap);
	}

	@Override
	public void addAgentImg(HashMap imgFormMap) {
		projectHomeMapper.addAgentImg(imgFormMap);
	}

	@Override
	public void deleteAgentImg(String id) {
		projectHomeMapper.deleteAgentImg(id);
	}
}
	


	



