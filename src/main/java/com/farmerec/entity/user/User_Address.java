package com.farmerec.entity.user;
/**
 * 用户地址表
 * @author Administrator
 *
 */
public class User_Address {
	private String address_id;    //主键
	private String user_id;			//外键，指向用户表主键，一个用户可有多个地址
	private String address;				//地址信息
	private String postcode;    					//邮编
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}
