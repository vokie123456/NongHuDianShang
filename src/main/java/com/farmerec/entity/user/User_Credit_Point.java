package com.farmerec.entity.user;
/**
 * 用户信用积分表
 * @author Administrator
 *
 */
public class User_Credit_Point {
	
	private String creditPoint_id;			//主键
	private String user_id;					//外键，指向用户表
	private int creditPoint;			//信用积分，int
	public String getCreditPoint_id() {
		return creditPoint_id;
	}
	public void setCreditPoint_id(String creditPoint_id) {
		this.creditPoint_id = creditPoint_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getCreditPoint() {
		return creditPoint;
	}
	public void setCreditPoint(int creditPoint) {
		this.creditPoint = creditPoint;
	}
	
}
