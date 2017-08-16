package com.farmerec.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.xml.ws.spi.http.HttpContext;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.HttpServletBean;

import com.farmerec.entity.user.Users;
import com.farmerec.mapper.UserMapper1;
import com.farmerec.service.UserService;
import com.tlh.view.QueryResult;


@Service("userserviceImpl")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper1 userMapper1;

	public void setUserMapper1(UserMapper1 userMapper1) {
		this.userMapper1 = userMapper1;
	}

	@Override
	public boolean saveEntity(Users t) throws Exception {
		t.setPassword(DigestUtils.md5DigestAsHex(t.getPassword().getBytes()));		//对密码进行加密
		return  userMapper1.saveUserInfo(t)>0;
	}

	@Override
	public boolean deleteEntity(Users t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Users t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users getEntity(Users t) throws Exception {
		return userMapper1.validateUserInfo(t);
	}
	@Override
	public Users checkLogin(Users t) throws Exception{
		t.setPassword(DigestUtils.md5DigestAsHex(t.getPassword().getBytes()));
		Users users = this.getEntity(t);
		System.out.println(users+"-----------------");
		if(users!=null&&users.getPassword().equals(t.getPassword())){
			return users;
		}
		return null;

	}

	@Override
	public List<Users> findEntity(Users t) throws Exception {

		return null;
	}

	@Override
	public QueryResult<Users> getDataGrid(Users t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateLoginInfo(Users user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassword(Users user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(Users t) throws Exception {
		Users user=getEntity(t);				//判断有没有这个用户
		if(user==null||!user.getPhonenumber().equals(t.getPhonenumber()))
			return saveEntity(t);			//没有，添加用户到数据库，并返回结果
		else
			return false;				//如果用户已经存在就直接返回
	}

	@Override
	public Users checkUser(Users u) throws Exception {
		return userMapper1.validateUserInfo(u);
	}


}
