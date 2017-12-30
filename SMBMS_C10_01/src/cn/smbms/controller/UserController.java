package cn.smbms.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.smbms.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController{
	private Logger logger = Logger.getLogger(UserController.class);
	private List<User> userList = new ArrayList<User>();
	public UserController(){
		try {
			userList.add(new User(1,"test001","测试用户001","111111",1,
					new SimpleDateFormat("yyyy-MM-dd").parse("1990-12-10"),"13598882222",
					"北京市朝阳区",1,1,new Date(),1,new Date()));
			userList.add(new User(2,"zhaoyan","赵燕","2222222",1,
					new SimpleDateFormat("yyyy-MM-dd").parse("1984-11-10"),"18678786545",
					"北京市海淀区成府路",1,1,new Date(),1,new Date()));
			userList.add(new User(3,"test003","测试用户003","3333333",1,
					new SimpleDateFormat("yyyy-MM-dd").parse("1980-11-11"),"13121334531",
					"北京市通州北苑",1,1,new Date(),1,new Date()));
			userList.add(new User(4,"wanglin","王林","4444444",1,
					new SimpleDateFormat("yyyy-MM-dd").parse("1989-09-10"),"18965652364",
					"北京市学院路",1,1,new Date(),1,new Date()));
			userList.add(new User(5,"zhaojing","赵静","5555555",1,
					new SimpleDateFormat("yyyy-MM-dd").parse("1981-08-01"),"13054784445",
					"北京市广安门",1,1,new Date(),1,new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping({"/welcome","/"})
	public String welcome(String username){
		logger.info("welcome, username:" + username);
		return "index";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model){
		logger.info("list====>");
		model.addAttribute("userList",userList);
		return "user/userlist";
	}
}
