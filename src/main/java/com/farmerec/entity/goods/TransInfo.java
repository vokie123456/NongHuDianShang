/**
 * 
 */
package com.farmerec.entity.goods;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class TransInfo {

	private String goodsStatusId;
	private String goods_id;
	private Date onlineDate;
	private int buyable;
	
	/**
	 * @return the goodsStatusId
	 */
	public String getGoodsStatusId() {
		return goodsStatusId;
	}
	/**
	 * @param goodsStatusId the goodsStatusId to set
	 */
	public void setGoodsStatusId(String goodsStatusId) {
		this.goodsStatusId = goodsStatusId;
	}
	/**
	 * @return the goods_id
	 */
	public String getGoods_id() {
		return goods_id;
	}
	/**
	 * @param goods_id the goods_id to set
	 */
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	/**
	 * @return the onlineDate
	 */
	public Date getOnlineDate() {
		return onlineDate;
	}
	/**
	 * @param onlineDate the onlineDate to set
	 */
	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}
	/**
	 * @return the buyable
	 */
	public int getBuyable() {
		return buyable;
	}
	/**
	 * @param buyable the buyable to set
	 */
	public void setBuyable(int buyable) {
		this.buyable = buyable;
	}
	
}
