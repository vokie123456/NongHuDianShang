package com.tlh.util.mybatis;

import java.io.Serializable;

/**
 * 分页实体
 */
public class PageParams implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer page;//当前页
	private Integer pageSize;//每页条数
	private Integer total;//数据总条数
	private Integer totalPage;//总页数
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

}