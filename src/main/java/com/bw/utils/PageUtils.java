package com.bw.utils;


public class PageUtils {
	
	//��ʼ��ѯ�ļ�¼��
	private int start;

	//��ǰҳ
	private int currentPage=1;
	
	//��һҳ
	private int prevPage;
	
	//��һҳ
	private int nextPage;
	
	//���һҳ
	private int lastPage;
	
	//������
	private long count;
	
	//ÿҳ����������
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
				//��ȡ��һҳ��֮ǰ�����Ȼ�õ�ǰҳ��ԭ�������ǰҳΪ��һҳ����ô��һҳ��ҲΪ��һҳ�����򣺵�ǰҳ��Ϊ��һҳ����һҳΪ��ǰҳ-1
				//��һҳʼ�պ͵�ǰҳ�й�ϵ�������ڳ�ʼ����һҳ֮ǰ�������Ȼ�õ�ǰҳ
				initPrevPage();
				//���һҳ
				initLastPage();
				//��һҳ  ��һҳ��ϵ����ǰҳ�Ƿ�Ϊ���һҳ,����ǣ���һҳΪ���һҳ��������ǣ�Ϊ��ǰҳ+1
				//�ȼ���������һҳ���Ƕ���
				initNextPage();
				initPageCount();
				//���ÿ�ʼ��ѯ�ļ�¼��
				this.setStart(this.getlimitIndex());
	}

	//��ʼ����һҳ
	private void initPrevPage(){
		this.prevPage = this.currentPage==1?1:this.currentPage-1;
	}
	
	private void initLastPage(){
		//���һҳ�㷨��������/ÿҳ��������������ܳ��������һҳΪ�̣��������������ô���һҳΪ����+1
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
	//������һҳ
	private void initNextPage(){
		//�жϵ�ǰҳ�Ƿ�Ϊ���һҳ������ǣ���ô��һҳ��Ϊ���һҳ��������ǣ���һҳΪ��ǰҳ+1
		if(this.currentPage == this.lastPage){
			this.nextPage = this.lastPage;
		}else{
			this.nextPage = this.currentPage+1;
		}
	}
	//sql�����㷨    ����ǰҳ-1��*����
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
		sb.append(" �ܼ�¼��"+this.count+" ��ҳ��"+this.pageCount+"/��  "+this.currentPage);
		sb.append(" <input type=\"text\" value="+this.currentPage+" style=\"width:20\" id=\"newCp\"> ");
		sb.append(" <input type=\"button\"  onclick=\"goPage()\" value=\"��ת\"> ");
		sb.append(" <input type=\"button\" onclick=\"fenye(1)\" value=\"��ҳ\"> ");
		sb.append(" <input type=\"button\" onclick=\"fenye("+this.prevPage+")\" value=\"��һҳ\"> ");
		sb.append(" <input type=\"button\" onclick=\"fenye("+this.nextPage+")\" value=\"��һҳ\"> ");
		sb.append(" <input type=\"button\" onclick=\"fenye("+this.lastPage+")\" value=\"ĩҳ\"> ");
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
		//��ҳ����
		sb.append("<script type=\"text/javascript\">\n");
		sb.append("function goPage(){");
		sb.append("		var cp = document.getElementById(\"newCp\").value;");
		sb.append("		document.getElementById(\"cp\").value=cp;");
		sb.append("		document.forms[0].submit();");
		sb.append("}");
	  	//ҳ����ת
		sb.append("function fenye(cp){");
		sb.append("		document.getElementById(\"cp\").value=cp;");
		sb.append("		document.forms[0].submit();");
		sb.append("}");
	  	//����ÿҳ�Ĵ�С
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
