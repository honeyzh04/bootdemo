/**
 * 
 */
package smm.springboot_ftl.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import smm.springboot_ftl.bean.ProjectShopsFormMap;
import smm.springboot_ftl.bean.User;

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
public interface MapService {



    public void insert(User user);


    public void update(User user);

    public User find(int id);

    public void delete(int id);
    public void addMap(HashMap map);
    public List<HashMap> findMap(HashMap map);
    public List<String>   findDepart(HashMap map);
    public List<HashMap> findMark(HashMap map);
    public List<String>  findGroupBy(HashMap map);
}
