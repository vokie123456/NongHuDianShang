package com.farmerec.entity.user;
/**
 * 用户账户表
 * @author Administrator
 *
 */
public class User_Account {
	private String account_id;				//主键
	private String user_id;			//外键，指向用户表
	private String balance;				//余额，double
	private String alipay;		//支付宝帐号
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getAlipay() {
		return alipay;
	}
	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}
	
}
