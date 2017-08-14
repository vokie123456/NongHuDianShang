package com.farmerec.entity.user;

import java.util.Date;
/**
 * 用户表
 * @author Administrator
 *
 */
public class Users {
	private String user_id;					//主键
	private String creditPoint_id;		//外键指向积分表主键
	private String userInfo_id;							//外键，指向用户信息表主键
	private String account_id;							//外键，指向帐户表主键
	private String trolleyInfoId;							//（外键，指向购物车信息）
	private String email;							//邮箱地址
	private String phonenumber;							//电话号码
	private Integer verifyStatus;							//认证状态 0:未验证、1：已验证、2：认证商家
	private Date loginTime;							//登陆时间
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCreditPoint_id() {
		return creditPoint_id;
	}
	public void setCreditPoint_id(String creditPoint_id) {
		this.creditPoint_id = creditPoint_id;
	}
	public String getUserInfo_id() {
		return userInfo_id;
	}
	public void setUserInfo_id(String userInfo_id) {
		this.userInfo_id = userInfo_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getTrolleyInfoId() {
		return trolleyInfoId;
	}
	public void setTrolleyInfoId(String trolleyInfoId) {
		this.trolleyInfoId = trolleyInfoId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Integer getVerifyStatus() {
		return verifyStatus;
	}
	public void setVerifyStatus(Integer verifyStatus) {
		this.verifyStatus = verifyStatus;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
}
