package com.farmerec.service;

import com.farmerec.entity.user.Users;
import com.tlh.system.service.BaseService;

public interface UserService extends BaseService<Users>{
	public boolean updateLoginInfo(Users user) throws Exception;

	public boolean updatePassword(Users user) throws Exception;

	public boolean register(Users t) throws Exception;

	public Users checkUser(Users u) throws Exception;
}
