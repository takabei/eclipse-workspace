package po;

import java.util.List;

public class PageBean {
	int total;
	int pageCode;//当前页数
	public static int pageSize = 25;
	List<Student> list;
	String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPageTotal() {
		if(total % pageCode == 0){
			return  (total / pageSize);
		}else{
			return  (total / pageSize + 1);
		}
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	@Override
	public String toString() {
		return "PageBean [total=" + total + ", pageCode=" + pageCode + ", list=" + list + ", url=" + url + "]";
	}
	
	
	
}
