package com.bw.utils;


public class PageUtils {
	
	//开始查询的记录数
	private int start;

	//当前页
	private int currentPage=1;
	
	//上一页
	private int prevPage;
	
	//下一页
	private int nextPage;
	
	//最后一页
	private int lastPage;
	
	//总条数
	private long count;
	
	//每页多少条数据
	private int pageSize=4;
	
	private int pageCount;
	
	private String pageStr;
	private String beanName;
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public PageUtils(){
		
	}
	public void setCount(long count) {
				this.count = count;
				//获取上一页，之前必须先获得当前页：原因：如果当前页为第一页，那么上一页，也为第一页，否则：当前页不为第一页，上一页为当前页-1
				//上一页始终和当前页有关系，所以在初始化上一页之前，必须先获得当前页
				initPrevPage();
				//最后一页
				initLastPage();
				//下一页  下一页关系：当前页是否为最后一页,如果是，下一页为最后一页，如果不是，为当前页+1
				//先计算出来最后一页，是多少
				initNextPage();
				initPageCount();
				//设置开始查询的记录数
				this.setStart(this.getlimitIndex());
	}

	//初始化上一页
	private void initPrevPage(){
		this.prevPage = this.currentPage==1?1:this.currentPage-1;
	}
	
	private void initLastPage(){
		//最后一页算法：总条数/每页数据条数。如果能除尽，最后一页为商，如果有余数，那么最后一页为：商+1
		if(this.count%this.pageSize==0){
			this.lastPage = Integer.valueOf(this.count/this.pageSize+"");
		}else{
			this.lastPage = Integer.valueOf(this.count/this.pageSize+1+"");
		}
		this.lastPage = this.lastPage ==0 ? 1:this.lastPage;
		if(this.currentPage>this.lastPage){
			this.currentPage = this.lastPage;
		}
		
	}
	//计算下一页
	private void initNextPage(){
		//判断当前页是否为最后一页，如果是：那么下一页就为最后一页，如果不是，下一页为当前页+1
		if(this.currentPage == this.lastPage){
			this.nextPage = this.lastPage;
		}else{
			this.nextPage = this.currentPage+1;
		}
	}
	//sql语句的算法    （当前页-1）*条数
	private void initPageCount(){
		this.pageCount =  Integer.valueOf(this.count/this.pageSize+(this.count%this.pageSize==0?0:1)+"");
	}
	
	public int getlimitIndex(){
		return Integer.valueOf((this.currentPage-1)*this.pageSize+"");
	}
	

	public String checkSelect(int pageSize){
		if(this.pageSize == pageSize) return "selected";
		return "";
	}
	public String getPageStr() {
	StringBuffer sb = new StringBuffer();
		sb.append(" <tr><td colspan=\"20\"> ");
		sb.append(" 总记录数"+this.count+" 总页数"+this.pageCount+"/第  "+this.currentPage);
		sb.append(" <input type=\"text\" value="+this.currentPage+" style=\"width:20\" id=\"newCp\"> ");
		sb.append(" <input type=\"button\"  onclick=\"goPage()\" value=\"跳转\"> ");
		sb.append(" <input type=\"button\" onclick=\"fenye(1)\" value=\"首页\"> ");
		sb.append(" <input type=\"button\" onclick=\"fenye("+this.prevPage+")\" value=\"上一页\"> ");
		sb.append(" <input type=\"button\" onclick=\"fenye("+this.nextPage+")\" value=\"下一页\"> ");
		sb.append(" <input type=\"button\" onclick=\"fenye("+this.lastPage+")\" value=\"末页\"> ");
		sb.append(" <select onchange=\"resetPageSize(this)\"> ");
		sb.append(" <option "+checkSelect(2)+">2</option>");
		sb.append(" <option "+checkSelect(4)+" >4</option>");
		sb.append(" <option "+checkSelect(6)+">6</option>");
		sb.append(" <option "+checkSelect(8)+">8</option>");
		sb.append(" <option "+checkSelect(10)+" >10</option>");
		sb.append(" <option "+checkSelect(20)+" >20</option>");
		sb.append(" <option "+checkSelect(30)+" >30</option>");
		sb.append(" </select>\n");
		sb.append("<input type=\"hidden\" id=\"cp\" value="+this.currentPage+" name=\""+"currentPage\"/>");
		sb.append("<input type=\"hidden\" id=\"pageSize\" value="+this.pageSize+" name=\""+"pageSize\"/>");
		sb.append("</td></tr>");
		//换页函数
		sb.append("<script type=\"text/javascript\">\n");
		sb.append("function goPage(){");
		sb.append("		var cp = document.getElementById(\"newCp\").value;");
		sb.append("		document.getElementById(\"cp\").value=cp;");
		sb.append("		document.forms[0].submit();");
		sb.append("}");
	  	//页面跳转
		sb.append("function fenye(cp){");
		sb.append("		document.getElementById(\"cp\").value=cp;");
		sb.append("		document.forms[0].submit();");
		sb.append("}");
	  	//重置每页的大小
		sb.append(" function resetPageSize(obj){");
		sb.append("		document.getElementById(\"pageSize\").value=obj.value;");
		sb.append("		document.getElementById(\"cp\").value=1;");
		sb.append("		document.forms[0].submit();");
		sb.append("}");
		sb.append("</script>\n");
		return sb.toString();
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public long getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public long getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public long getCount() {
		return count;
	}

	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

	

	
	
}
