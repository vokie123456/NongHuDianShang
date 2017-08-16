/**
 * 
 */
package com.farmerec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 * 访问到到商品商品详情页
 */
@Controller
@RequestMapping("/GoodsController")
public class GoodsController {

	@RequestMapping("/goodsInfo")
	public ModelAndView goodsInfo(){
		ModelAndView mv = new ModelAndView();
		System.out.println("GoodsController.goodsInfo:............");
		mv.setViewName("jsp/product");
		return mv;
	}
}
