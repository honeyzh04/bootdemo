package smm.springboot_ftl.action;

import java.util.*;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import smm.springboot_ftl.bean.User;
import smm.springboot_ftl.service.UserService;
/**
 * 在定义一个Rest接口时，我们通常会使用GET，POST，PUT，DELETE几种方式来完成我们所需要进行CRUD的一些操作，
 * 我们在这里罗列和教大家在实际开发中的使用，一些基本概念我们就不再赘述，例如使用POST的优缺点，可使用参数的大小限制等地：

    GET：一般用于查询数据，不办函数据的更新以及插入操作。由于明文传输的关系，我们一般用来获取一些无关用户的信息。

    POST：一般用于数据的插入操作，也是使用最多的传输方式，但是在H5调用时会有跨域的问题，一般使用JSONP来解决。

    PUT：我们使用PUT方式来对数据进行更新操作。

    DELETE：用于数据删除，注意在数据库内是逻辑删除（改变数据状态，用户不再查询得到，但还保留在数据库内）还是物理删除（真删了）。

@RestController
@EnableAutoConfiguration
@ComponentScan({"smm.springboot_ftl.service"})
@SpringBootApplication 
@MapperScan("smm.springboot_ftl.mapper")
 * @author Administrator
 *
 */
@Controller
@ComponentScan({"smm.springboot_ftl.service"})
@MapperScan("smm.springboot_ftl.mapper")
@RequestMapping("/map")
public class UserController {
	
	@Resource
	private UserService userService;
	
	 @RequestMapping("/say")  
     public String say(){  
         return "springboot-a"+userService;
     }  
	
	@RequestMapping("/find")
	public String find(){
		User user =  userService.find(1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user","sadf");
		return "HelloWord"+"fasdf--"+user.getUsername()+"--"+user.getPassword();
	}
	
	
	@RequestMapping("/ajax")
	public String find1(){
		return "[''message':'123dfx']";
	}

	@RequestMapping("/addMapUI")
	public String addMapUI(){
	 	return "add";
	}

	@RequestMapping(value = "/addMap",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String addMap(String lng ,String lat,String color,String address,String department,String num,String group){
	 	HashMap<String ,Object> map=new HashMap<>();
	 	map.put("department",department);
		map.put("lng",lng);
		map.put("lat",lat);
		map.put("address","1");
		map.put("color",color);
		map.put("createDate",new Date());
		map.put("state","1");
		map.put("num",num);
		map.put("group",group);
		userService.addMap(map);
		return "success";
	}


	@RequestMapping("/findMapUI")
	public String findMapUI(){
		return "list";
	}

	@RequestMapping("/findMap")
	@ResponseBody
	public List<HashMap> findMap(String address,String department){
		HashMap<String ,Object> map=new HashMap<>();
		map.put("department",department);
		map.put("address",address);
		map.put("state","1");
		List<HashMap> listMap=userService.findMap(map);
		return listMap;
	}
	@RequestMapping("/findMark")
	@ResponseBody
	public List<HashMap> findMark(String department){
		HashMap<String ,Object> mark=new HashMap<>();
		mark.put("department",department);
		List<HashMap> listMark=userService.findMark(mark);
		System.err.println(listMark);
		return listMark;
	}

	@RequestMapping("/findDepart")
	@ResponseBody
	public List<String> findDepart(String department){
		HashMap<String ,Object> map=new HashMap<>();
		map.put("department",department);
		List<String> listMap=userService.findDepart(map);
		return listMap;
	}
	@RequestMapping("/findMaps")
	@ResponseBody
	public List<List<HashMap>> findMaps(String address,String department){
	 	List list=new ArrayList();
		HashMap<String ,Object> map=new HashMap<>();
		map.put("department",department);
		List<String> listMap=userService.findGroupBy(map);
		for (String groupBy:listMap){
			map.put("groupBy",groupBy);
			List<HashMap> listMap1=userService.findMap(map);
			list.add(listMap1);
		}
		System.err.println(list);

		return list;
	}

}
