package com.farmerec.entity.user;
/**
 * 银行卡信息表
 * @author Administrator
 *
 */
public class Bank_Card {
		private String bankCardId;			//主键
	private String account_id;			//外键，指向用户帐户表主键
	private String cardNumber;			//银行卡号
	public String getBankCardId() {
		return bankCardId;
	}
	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
}
