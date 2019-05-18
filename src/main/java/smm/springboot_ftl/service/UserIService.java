package smm.springboot_ftl.service;

import smm.springboot_ftl.bean.User;

import java.util.HashMap;
import java.util.List;


public interface UserIService {
	
	public void insert(User user);
	public void addMap(HashMap map);

	public List<HashMap> findMap(HashMap map);
    public List<String>   findDepart(HashMap map);
    public List<HashMap> findMark(HashMap map);
    public List<String>  findGroupBy(HashMap map);
}
