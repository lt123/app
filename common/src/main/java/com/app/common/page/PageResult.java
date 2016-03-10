package com.app.common.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回的分页对象
 * 
 * @author lt
 * 
 */
public class PageResult<E> {

	/*
	 * 默认当前为第一页
	 */
	private Integer currentPage = 1;

	/*
	 * 默认每页显示10条数据
	 */
	private Integer pageSize = 10;

	/*
	 * 默认总条数为0条
	 */
	private Integer totalCount = 0;

	/*
	 * 总的页数,需要计算
	 */
	private Integer totalPage = 0;

	/*
	 * 当前页码的数据
	 */
	private List<E> rows = new ArrayList<>();// 当前页码的数据

	public PageResult(Integer currentPage, Integer pageSize, Integer totalCount, List<E> rows) {
		// currentPage,pageSize输入负数或null
		this.currentPage = currentPage == null || currentPage <= 0 ? 1 : currentPage; 
		this.pageSize = pageSize == null || pageSize <= 0 ? 10 : pageSize;
		
		// 计算总的页数
		this.totalCount = totalCount;
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;

		// 判断当前页码是否大于总的页码ge
		this.currentPage = this.currentPage > this.totalPage ? this.totalPage
				: this.currentPage;
		
		this.rows = rows;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<E> getRows() {
		return rows;
	}

	public void setRows(List<E> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageResult [currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", rows=" + rows + "]";
	}
}
