package org._233Latiao.Lytine.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org._233Latiao.Lytine.ssm.entity.User;
import org._233Latiao.Lytine.ssm.service.IUserService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	//使用指定类初始化日志对象，在日志输出的时候，可以打印楚日志信息所在类
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Resource
	private IUserService userService;

	 // /user/test?id=1
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("userId:值为" + userId);
		User user = new User();
		if (userId == 1) {
			user = new User();
			user.setAge(18);
			user.setId(2);
			user.setPassword("123");
			user.setUserName("辣条");
		}
		log.debug(user.toString());
		model.addAttribute("user", user);
		return "index";
	}

	 // /user/showUser?id=1
	@RequestMapping(value = "/showUser1", method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("userId:" + userId);
		User user = this.userService.getUserById(userId);
		log.debug(user.toString());
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView toIndex2(HttpServletRequest request) {
		/*int userId  = Integer.parseInt(request.getParameter("id"));
		System.out.println("userId:"+userId);
		User user = this.userService.getUserById(userId);
		log.debug(user.toString());*/
		request.setAttribute("data", "第二个方法测试");
		ModelAndView mv = new ModelAndView("showUser");
		return mv;
	}

	// /user/showUser2?id=1
	@RequestMapping(value = "/showUser2", method = RequestMethod.GET)
	public String toIndex3(@RequestParam("id") String id,Model model) {
		int userId  = Integer.parseInt(id);
		System.out.println("userId"+userId);
		User user = this.userService.getUserById(userId);
		log.debug(user.toString());
		model.addAttribute("user",user);
		return "showUser";
	}
	
	 // /user/showUser3/{id}
    @RequestMapping(value="/showUser3/{id}",method=RequestMethod.GET)  
    public String toIndex3(@PathVariable("id")String id,Map<String, Object> model){  
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);  
        log.debug(user.toString());
        model.put("user", user);  
        return "showUser";  
    }  
	
 // /user/{id}
    @RequestMapping(value="/{id}",method=RequestMethod.GET) 
    @ResponseBody
    public User getUserInJson(@PathVariable String id,Map<String, Object> model){  
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);  
        log.info(user.toString());
        return user;  
    }  
    
    // /user/{id}
    @RequestMapping(value="/jsontype/{id}",method=RequestMethod.GET)  
    public ResponseEntity<User>  getUserInJson2(@PathVariable String id,Map<String, Object> model){  
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);  
        log.info(user.toString());
        return new ResponseEntity<User>(user,HttpStatus.OK);  
    } 
    
    //文件上传、
    @RequestMapping(value="/upload")
    public String showUploadPage(){
        return "/WEB-INF/jsp/file";
    }
    
    @RequestMapping(value="/doUpload",method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file")MultipartFile file) throws IOException{
        if (!file.isEmpty()) {
            log.info("Process file:{}",file.getOriginalFilename());
        }
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File("G:\\",System.currentTimeMillis()+file.getOriginalFilename()));
        return "success";
    }
	

}
