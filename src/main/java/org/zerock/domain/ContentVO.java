package org.zerock.domain;

public class ContentVO {

	private String content;
	private String writer;

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "ContentVO [content=" + content + ", writer=" + writer + "]";
	}
	
	
	
	
}
