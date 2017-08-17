package com.farmerec.mapper;

import java.util.List;

import com.farmerec.entity.dto.GoodsDto;
import com.farmerec.entity.goods.Goods;
import com.farmerec.entity.goods.GoodsInfo;
import com.tlh.system.mapper.BaseMapper;

public interface GoodsMapper extends BaseMapper {

	public int addGoods(Goods goods);
	
	public GoodsDto getGoodsById(String goodsId);
	
	public List<GoodsInfo> getGoodsByName(String goodsName);
	
	public void deleteGoods(Goods goods);
	
	public void updateGoods(Goods goods);
}
