package com.farmerec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farmerec.entity.user.Users;
import com.farmerec.service.UserService;
import com.farmerec.service.impl.UserServiceImpl;
import com.farmerec.util.validateUtil;
import com.google.zxing.client.result.WifiParsedResult;
/**
 * 用户注册模块
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/userController")
public class UserController {

	@Resource
	UserService userserviceImpl;

	public void setServiceImpl(UserServiceImpl serviceImpl) {
		this.userserviceImpl = serviceImpl;
	}

	public void setUserserviceImpl(UserService userserviceImpl) {
		this.userserviceImpl = userserviceImpl;
	}
	@RequestMapping("/register")
	public String register(Model model,Users userpo) throws Exception{
		boolean isRegister=userserviceImpl.register(userpo);
		if(isRegister){
			model.addAttribute("user", userpo);
			return "jsp/index";
		}
		else
			return "jsp/regist";
	}
	@RequestMapping("/checkPhone")
	public String checkPhone(HttpServletResponse response,Users u) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		if(u!=null){
			boolean isCorrect=Pattern.compile(validateUtil.VALIDATEPHONE).matcher(u.getPhonenumber()).matches();
			boolean isExist=userserviceImpl.checkUser(u)!=null?true:false;
			if(!isCorrect){
				response.getWriter().println("<font color='red' face='宋体' id='fontEmail'>号码格式错误！</font>");
			}else if(isExist){
				response.getWriter().println("<font color='red' face='宋体' id='fontEmail'>号码已存在！请更换</font>");
			}else{
				response.getWriter().println("<font color='green' face='宋体' id='fontEmail'>号码可以使用！</font>");
			}
		}else{
			response.getWriter().println("<font color='red' face='宋体' id='fontEmail'>号码不能为空！</font>");
		}
		return null;
	}
	@RequestMapping("/checkEmail")
	public String checkEmail(HttpServletResponse response,Users u) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		//校验邮箱
		if(u!=null){
			boolean isCorrect=Pattern.compile(validateUtil.VALIDATEEMAIL).matcher(u.getEmail()).matches();
			boolean isExist=userserviceImpl.checkUser(u)!=null?true:false;
			if(!isCorrect){
				response.getWriter().println("<font color='red' face='宋体' id='fontPhone'>邮箱格式有误！</font>");
			}else if(isExist){
				response.getWriter().println("<font color='red' face='宋体' id='fontPhone'>邮箱已存在！请更换</font>");
			}else{
				response.getWriter().println("<font color='green' face='宋体' id='fontPhone'>邮箱可以使用！</font>");
			}
		}else{
			response.getWriter().println("<font color='red' face='宋体' id='fontPhone'>邮箱不能为空！</font>");
		}
		return null;

	}
	@RequestMapping("/checkCode")
	public String checkCode(HttpServletResponse response,HttpSession session,String checkcode) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		if(checkcode==""||checkcode==null){
			response.getWriter().println("<font color='red' face='宋体' id='fontCode'>请输入验证码！</font>");
		}else{
			String valCode=(String) session.getAttribute("valCode");
			System.out.println(valCode+":"+checkcode);
			if(checkcode.equals(valCode)){
				response.getWriter().println("<font color='green' face='宋体' id='fontCode'>验证码正确！</font>");
			}else{
				response.getWriter().println("<font color='red' face='宋体' id='fontCode'>验证码错误！</font>");
			}
		}
		return null;

	}


}
