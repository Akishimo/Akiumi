package com.akiumi.common.util;

import java.util.List;

public class Pager<T> {

	/**
	 * 默认设定每页显示记录数为10
	 */
	public static final int DEFAULT_PAGE_SIZE = 10;
	/**
	 * 默认当前为第一页.
	 */
	public static final int DEFAULT_CURRENT_PAGE = 1;
	/**
	 * 总记录数
	 */
	private int totalItems = -1;
	/**
	 * 每页行数
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;
	/**
	 * 当前页码
	 */
	private int currentPage = DEFAULT_CURRENT_PAGE;
	/**
	 * 总页数
	 */
	private int totalPages = -1;
	/**
	 * 是否第一页
	 */
	private boolean isFirstPage;
	/**
	 * 是否最后一页
	 */
	private boolean isLastPage;
	/**
	 * 是否有下一页
	 */
	private boolean hasNext;
	/**
	 * 是否有前一页
	 */
	private boolean hasPrevious;
	/**
	 * 数据集
	 */
	private List<T> list;

	/**
	 * 构造方法
	 */
	public Pager() {
		super();
	}

	/**
	 * @param totalItems
	 * @param list
	 */
	public Pager(int totalItems, List<T> list) {
		this(totalItems, DEFAULT_PAGE_SIZE, DEFAULT_CURRENT_PAGE);
		this.list = list;
	}

	/**
	 * @param totalItems
	 * @param currentPage
	 */
	public Pager(int totalItems, int currentPage) {
		this(totalItems, DEFAULT_PAGE_SIZE, currentPage);
	}

	/**
	 * @param totalItems
	 * @param pageSize
	 * @param currentPage
	 */
	public Pager(int totalItems, int pageSize, int currentPage) {
		super();
		setTotalItems(totalItems);
		setPageSize(pageSize);
		setCurrentPage(currentPage);

		setTotalPages();
		setHasNext();
		setHasPrevious();
		setFirstPage();
		setLastPage();
	}

	// /////////////////////////////////////////////////////
	// ////////////////////构造方法结束/////////////////////////////////
	// /////////////////////////////////////////////////////

	/**
	 * 总数
	 * 
	 * @param totalItems
	 */
	public void setTotalItems(int totalItems) {
		if (totalItems < 0) {
			System.out.println("totalItems should >= 0.");
			this.totalItems = 0;
		} else {
			this.totalItems = totalItems;
		}
	}

	/**
	 * 每页的数目，默认10
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		if (pageSize <= 0) {
			System.out.println("pageSize should > 0.");
			this.pageSize = DEFAULT_PAGE_SIZE;
		} else {
			this.pageSize = pageSize;
		}
	}

	/**
	 * 修正计算当前页
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 总页数
	 */
	public void setTotalPages() {
		if (totalItems != 0 && pageSize != 0) {
			this.totalPages = (totalItems % pageSize == 0) ? //
					totalItems / pageSize
						: (totalItems / pageSize) + 1;
		} else {
			this.totalPages = 0;
		}
	}

	/**
	 * 是否有下一页
	 */
	public void setHasNext() {
		this.hasNext = (currentPage < this.totalPages);
	}

	/**
	 * 是否有前一页
	 */
	public void setHasPrevious() {
		this.hasPrevious = currentPage > 1;
	}

	/**
	 * 是否是第一页
	 */
	public void setFirstPage() {
		this.isFirstPage = (currentPage == 1);
	}

	/**
	 * 是否是最后一页
	 */
	public void setLastPage() {
		this.isLastPage = currentPage >= this.totalPages;
	}

	// ///////////////////////////////////////////////
	// ///////////set方法结束////////////////////////////////////
	// ///////////////////////////////////////////////

	/**
	 * @return 获取开始的索引
	 */
	public int getBeginIndex() {
		return (currentPage - 1) * pageSize;
	}

	/**
	 * 获取下一页的页码 如果不是会讲curPage + 1
	 * 
	 * @return 下一页的页码
	 */
	public int getNextPage() {
		if (currentPage + 1 >= this.totalPages) {
			return this.totalPages;
		} else {
			return currentPage + 1;
		}
	}

	/**
	 * @return 前一页的页码 如果存在
	 */
	public int getPreviousPage() {
		if (currentPage - 1 <= 1) {
			return 1;
		} else {
			return currentPage - 1;
		}
	}

	/**
	 * @return 总页数
	 */
	public int getTotalPages() {
		if (totalPages == -1) {
			setTotalPages();
		}
		return totalPages;
	}

	/**
	 * @return 总条数
	 */
	public int getTotalItems() {
		return totalItems;
	}

	/**
	 * @return 每页的数目
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @return 获取当前页码
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @return 数据
	 */
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public boolean isLastPage() {
		return isLastPage;
	}
}
