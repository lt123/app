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

	public PageResult(int currentPage, int pageSize, int totalCount) {
		// currentPage,pageSize输入负数
		this.currentPage = currentPage < 1 ? 1 : currentPage;
		this.pageSize = pageSize < 1 ? 10 : pageSize;
		this.totalCount = totalCount;
		
		// 计算总的页数
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;

		// 判断当前页码是否大于总的页码
		this.currentPage = this.currentPage > this.totalPage ? this.totalPage
				: this.currentPage;

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
