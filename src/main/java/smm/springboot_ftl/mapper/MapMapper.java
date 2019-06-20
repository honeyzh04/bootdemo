package smm.springboot_ftl.mapper;

import org.apache.ibatis.annotations.Mapper;

import smm.springboot_ftl.bean.User;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MapMapper {

	public void insert(User user);

	public void update(User user);
	
	public void delete(int id);
	
	public User find(int id);
	public void addMap(HashMap map);

	public List<HashMap> findMap(HashMap map);
    public List<String>   findDepart(HashMap map);
    public List<HashMap> findMark(HashMap map);
    public List<String>  findGroupBy(HashMap map);

}
