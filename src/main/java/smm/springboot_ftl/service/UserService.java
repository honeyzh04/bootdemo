package smm.springboot_ftl.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import smm.springboot_ftl.bean.User;
import smm.springboot_ftl.mapper.UserMapper;

import java.util.HashMap;
import java.util.List;


@ComponentScan({"ssm.springboot_ftl.mapper"})
@Service("userService")
public class UserService implements UserIService{

	@Resource
	private UserMapper userMapper;
	
	@Override
	public void insert(User user) {
		userMapper.insert(user);
	}

	public void update(User user) {
		userMapper.update(user);
	}

	public User find(int id) {
		return userMapper.find(id);
	}
	
	public void delete(int id){
		userMapper.delete(id);
	}
	public void addMap(HashMap map){
		userMapper.addMap(map);
	}

	public List<HashMap> findMap(HashMap map){
		return  userMapper.findMap(map);
	}
	public List<String>   findDepart(HashMap map){
		return  userMapper.findDepart(map);
	}
	public List<HashMap> findMark(HashMap map){
		return  userMapper.findMark(map);
	}
	public List<String>  findGroupBy(HashMap map){
		return  userMapper.findGroupBy(map);
	}
}
