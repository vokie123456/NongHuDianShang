package com.farmerec.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farmerec.entity.user.Users;
import com.farmerec.service.UserService;
import com.tlh.view.ParameterObject;
/**
 * 用户登录模块
 * @author Administrator
 *包含页面跳转功能
 */
@Controller
@RequestMapping("/loginController")
public class LoginController {

	@Resource(name="userserviceImpl")
	UserService userserviceImpl;

	public void setUserService(UserService userserviceImpl) {
		this.userserviceImpl = userserviceImpl;
	}
	@RequestMapping("login")
	public String login(){
		return "jsp/login";
	}
	//订单跳转
	@RequestMapping("/order")
	public String order(){
		return "jsp/order";
	}
	//购物车跳转
	@RequestMapping("/shopCar")
	public String shopCar(){
		return "jsp/shopCar";
	}
	@RequestMapping("/branchClassify")
	public String branchClassify(){
		return "jsp/branchClassify";
	}

	@RequestMapping("/classify")
	public String classify(){
		return "jsp/classify";
	}

	@RequestMapping("/loginUser")
	public String loginUser(Users user,HttpSession session,String valCode) throws Exception{
		Users user1=this.userserviceImpl.checkLogin(user);
		if(user1!=null){
			session.setAttribute("user", user1);
			System.out.println("-----------++++++++++++++++");
			return "jsp/index";
		}
		return "jsp/login";
	}

	@RequestMapping("/index")
	public String index(){
		System.out.println("主页--------------");
		return "jsp/index";
	}
	@RequestMapping("/regist")
	public String regist(){
		return "jsp/regist";
	}


	@RequestMapping("/quit")
	public String quit(HttpSession session){
		session.invalidate();
		return "jsp/login";
	}
}
