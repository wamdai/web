package login.utils;

import java.util.List;

public class PageBean<T> {
	private Integer pageSize; //一页数据数
	private Integer pageNos;//当前页码
	private Integer count; //总的记录数
	private Integer page; //总页数
	private List<T> list;
	private Integer start; 
	private Integer end;
	public PageBean() {
	
	}
	

	public PageBean(Integer pageSize, Integer pageNos, Integer count) {
		super();
		this.pageSize = pageSize;
		this.pageNos = pageNos;
		this.count = count;
		
		//通过总记录数算出总页数
		this.page= this.count%this.pageSize ==0? 
				this.count/this.pageSize : this.count/this.pageSize+1;
		
		if(this.page<1){
			this.page=1;
			
		}
		//判断页码是否合法
		if(this.pageNos ==null ){
			this.pageNos=1;
		}
		if (this.pageNos <= 1 ) {
			pageNos=1;
		}
	
		this.start=1;
		this.end=10;
		
		//如果总页数小于10  按实际页数显示
		if(this.page <10){
			this.start=1;
			this.end=this.page;
		}else{ //如果页数大于10  
			//开始和结束页面会根据当前页码进行改变
			this.start =this.pageNos-5;
			this.end =this.pageNos+4;
			
			//start不能小于1 此情况下为前几页
			if(this.start<1){
				this.start=1;
				this.end=10;
			}
			
			//end也不能大于总页数  此情况下为后几页
			if(this.end>this.page){
				this.start=this.page-9;
				this.end=this.page;
			}
		}
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNos() {
		return pageNos;
	}
	public void setPageNos(Integer pageNos) {
		this.pageNos = pageNos;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}

	
	
}
