package utils;

public class Pagination {

	/**
	 * 
	 * @param pc //pc
	 *            当前页数
	 * @param pageCount //getTp
	 *            总页数
	 * @param recordCount  ////tr
	 *            总记录数
	 * @param pageUrl
	 *            页面 URL
	 * @return
	 */
	public static String getPagination(int pc, int pageCount,
			int recordCount, String pageUrl) {

		String url = pageUrl.contains("?") ? pageUrl : pageUrl + "?";
		if(!url.endsWith("?") && !url.endsWith("&")){
			url += "&";
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("第 " + pc + "/" + pageCount + " 页 共 " + recordCount
				+ " 记录 ");

		buffer.append(pc == 1 ? " 第一页 " : " <a href='" + url
				+ "pc=1'>第一页</a> ");
		buffer.append(pc == 1 ? " 上一页 " : " <a href='" + url + "pc="
				+ (pc - 1) + "'>上一页</a> ");
		buffer.append(pc == pageCount ? " 下一页 " : " <a href='" + url
				+ "pc=" + (pc + 1) + "'>下一页</a> ");
		buffer.append(pc == pageCount ? " 最后一页 " : " <a href='" + url
				+ "pc=" + pageCount + "'>最后一页</a> ");

		buffer.append(" 到 <input type='text' ");
		buffer.append("  name='helloweenvsfei_goto_input' ");
		buffer.append("  style='width:25px; text-align:center; '> 页 ");
		buffer.append(" <input type='button'");
		buffer.append("  name='helloweenvsfei_goto_button' value='Go'>");

		buffer.append("<script language='javascript'>");
		buffer.append("function helloweenvsfei_enter(){");
		buffer.append("	if(event.keyCode == 13){");
		buffer.append("		helloweenvsfei_goto();");
		buffer.append("		return false;");
		buffer.append("	}");
		buffer.append("	return true;");
		buffer.append("} ");
		buffer.append("function helloweenvsfei_goto(){");
		buffer
				.append("	var numText = document.getElementsByName('helloweenvsfei_goto_input')[0].value;");
		buffer.append("	var num = parseInt(numText, 10);");
		buffer.append("	if(!num){");
		buffer.append("		alert('页数必须为数字');	");
		buffer.append("		return;");
		buffer.append("	}");
		buffer.append("	if(num<1 || num>" + pageCount + "){");
		buffer.append("		alert('页数必须大于 1，且小于总页数 " + pageCount + " ');	");
		buffer.append("		return;");
		buffer.append("	}");
		buffer.append("	location='" + url + "pc=' + num;");
		buffer.append("}");
		buffer
				.append("document.getElementsByName('helloweenvsfei_goto_input')[0].onkeypress = helloweenvsfei_enter;");
		buffer
				.append("document.getElementsByName('helloweenvsfei_goto_button')[0].onclick = helloweenvsfei_goto;");
		buffer.append("</script>");

		return buffer.toString();
	}
}
