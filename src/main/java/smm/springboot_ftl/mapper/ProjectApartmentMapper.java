package smm.springboot_ftl.mapper;

import smm.springboot_ftl.bean.ProjectApartmentFormMap;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公寓项目操作 Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @date 2018年6月2日
 * @version 1.00
 */

public interface ProjectApartmentMapper {

	//经纪人小程序项目接口

	/**
	 * 查看项目列表
	 * @param searchMapMap
	 * @return
	 */
	public List<ProjectApartmentFormMap> findAgentProjects(Map searchMapMap);
	/**
	 * 添加项目
	 */
	public void addAgentProject(HashMap formMap);
	/**
	 * 查看项目
	 *
	 * @return
	 */
	public ProjectApartmentFormMap findbyAgentProject(@Param("id") String id);

	/**
	 * 修改项目
	 */
	public void editAgentProject(HashMap formMap);

	/**
	 * 删除项目
	 *
	 * @param id
	 */
	public void deleteAgentProject(String id);


	List<ProjectApartmentFormMap> findAgentImg(Map imgForMap);

	void addAgentImg(HashMap imgFormMap);

	void deleteAgentImg(String id);
}
