package com.farmerec.mapper;

import java.util.List;

import com.farmerec.entity.user.Users;
import com.tlh.entity.User;
import com.tlh.system.mapper.BaseMapper;

public interface UserMapper1 extends BaseMapper{
	public int saveUserInfo(Users user) throws Exception;

	public int deleteUserInfo(int id) throws Exception;

	public int updateLoginInfo(Users user) throws Exception;

	public int updatePassword(Users user) throws Exception;

	public int updateUserName(Users user) throws Exception;

	// 登录验证
	public Users validateUserInfo(Users user) throws Exception;

	// easui查询
	public int getTotalCount(Users t) throws Exception;

	public List<Users> queryUsers(Users t) throws Exception;
}
