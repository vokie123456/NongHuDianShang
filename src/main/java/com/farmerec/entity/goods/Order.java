package com.farmerec.entity.goods;

public class Order {

	private String order_id;
	private String user_id;
	private int goodsQuantity;
	private int ordersStatus;
	/**
	 * @return the order_id
	 */
	public String getOrder_id() {
		return order_id;
	}
	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the goodsQuantity
	 */
	public int getGoodsQuantity() {
		return goodsQuantity;
	}
	/**
	 * @param goodsQuantity the goodsQuantity to set
	 */
	public void setGoodsQuantity(int goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}
	/**
	 * @return the ordersStatus
	 */
	public int getOrdersStatus() {
		return ordersStatus;
	}
	/**
	 * @param ordersStatus the ordersStatus to set
	 */
	public void setOrdersStatus(int ordersStatus) {
		this.ordersStatus = ordersStatus;
	}
	
}
