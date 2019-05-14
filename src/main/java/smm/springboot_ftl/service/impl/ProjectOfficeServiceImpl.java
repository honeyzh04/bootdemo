/**
 * 
 */
package smm.springboot_ftl.service.impl;

import smm.springboot_ftl.bean.ProjectOfficeFormMap;
import smm.springboot_ftl.mapper.ProjectOfficeMapper;
import smm.springboot_ftl.service.ProjectOfficeService;
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
public class ProjectOfficeServiceImpl implements ProjectOfficeService {
	@Resource
	private ProjectOfficeMapper projectOfficeMapper;


	//经纪人小程序接口
	@Override
	public List<ProjectOfficeFormMap> findAgentProjects(Map searchMapMap) {
		return  projectOfficeMapper.findAgentProjects(searchMapMap);
	}

	@Override
	public ProjectOfficeFormMap findbyAgentProject(String id) {
		return projectOfficeMapper.findbyAgentProject(id);
	}
	@Override
	public void addAgentProjects( HashMap formMap) {

		projectOfficeMapper.addAgentProject(formMap);
	}
	@Override
	public void editAgentProject( HashMap formMap) {
		projectOfficeMapper.editAgentProject(formMap);
	}

	@Override
	public void deleteAgentEntity(String id) {
		projectOfficeMapper.deleteAgentProject(id);
	}

	@Override
	public List<ProjectOfficeFormMap> findAgentImg(Map imgForMap) {
		return projectOfficeMapper.findAgentImg(imgForMap);
	}

	@Override
	public void addAgentImg(HashMap imgFormMap) {
		projectOfficeMapper.addAgentImg(imgFormMap);
	}

	@Override
	public void deleteAgentImg(String id) {
		projectOfficeMapper.deleteAgentImg(id);
	}
}
	


	



