package com.farmerec.entity.user;
/**
 * 用户信息表
 * @author Administrator
 *
 */
public class User_Info {
	private String userInfo_id;			//主键
	private String user_id;					//外键，指向users表
	private String idNumber;						//身份证号码
	private String realName;		//真实姓名
	private String realAddress;			//户籍地址
	private int sex;			//性别 int，1：男，0：女
	public String getUserInfo_id() {
		return userInfo_id;
	}
	public void setUserInfo_id(String userInfo_id) {
		this.userInfo_id = userInfo_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getRealAddress() {
		return realAddress;
	}
	public void setRealAddress(String realAddress) {
		this.realAddress = realAddress;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}

}
