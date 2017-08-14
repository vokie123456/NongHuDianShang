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
		return "jsp/order.htm";
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
	public @ResponseBody ParameterObject loginUser(Users user,HttpSession session,String valCode) throws Exception{

		ParameterObject result=new ParameterObject();

		//验证码验证
		Object objValCode=session.getAttribute("valCode");
		if(objValCode==null ||!objValCode.toString().equals(valCode)){
			result.flag(false);
			result.msg("验证码错误！");
			return result;
		}
		user=this.userserviceImpl.getEntity(user);
		if(user!=null){
			session.setAttribute("user", user);
			result.flag(true);
			result.msg("登录成功！");
		}else{
			result.flag(false);
			result.msg("登录成功");
		}
		return result;
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
