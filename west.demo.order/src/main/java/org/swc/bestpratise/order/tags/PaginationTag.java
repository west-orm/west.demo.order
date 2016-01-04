package org.swc.bestpratise.order.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.bucuoa.west.orm.extend.Page;

public class PaginationTag extends TagSupport {

	private static final long serialVersionUID = -45179656954594819L;

	private Page page;
	private int maxSize = 10;

	@Override
	public int doEndTag() {
		int start = 1;
		int end = 10;
		
		StringBuffer html = new StringBuffer();
		JspWriter out = pageContext.getOut();
		try{
				html.append("<div class=\"row\"><div class=\"col-sm-4\" >");
				html.append("<div class=\"dataTables_info\" id=\"sample-table-2_info\">");html.append(page.getPageNo());
				html.append("/");html.append(page.getTotalPage()); html.append(" 每页");html.append(page.getPageSize()).append(" ");html.append("</div></div>");
				html.append("<div class=\"col-sm-6\">");
				html.append("<div class=\"dataTables_paginate paging_bootstrap\">");
				if(page.getTotalPage() >1)
				{
				html.append("<ul class=\"pagination\">");
				html.append("<li><a href=\"?pageNo=").append(1).append("\">");html.append("首页");html.append("</a></li>");
				html.append("<li><a href=\"?pageNo=").append(page.getPrevPageNo()).append("\">");html.append("上页");html.append("</a></li>");
				if(page.getPageNo()>5)
				{
					start = page.getPageNo()-5;
					end = page.getPageNo()+5;
				}
				
				if(page.getPageNo()+5 > page.getTotalPage())
				{
					end = page.getTotalPage();
				}
				
				for(int i = start ; i <= end; i ++)
				{	
					html.append("<li ");
					if(i == page.getPageNo())
					{
						html.append("class=\"active\"");
					}
					html.append("><a href=\"?pageNo=").append(i).append("\">");html.append(i);html.append("</a></li>");
				}

				html.append("<li><a href=\"?pageNo=").append(page.getNextPageNo()).append("\">");html.append("下页");html.append("</a></li>");
				html.append("<li><a href=\"?pageNo=").append(page.getTotalPage()).append("\">");html.append("末页");html.append("</a></li>");
//				html.append("<li class=\"next\"><a href=\"#\"><i class=\"icon-double-angle-right\"></i></a></li>");
				html.append("</ul>");
				}
				html.append("</div>");
				html.append("</div>");
				
				html.append("</div>");
				
				out.print(html.toString());
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return EVAL_PAGE;
	}
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

}
