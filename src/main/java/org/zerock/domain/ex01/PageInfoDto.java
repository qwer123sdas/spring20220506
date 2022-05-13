package org.zerock.domain.ex01;


public class PageInfoDto {
	private int current;

	private int end;
	
	public void setCurrent(int current) {
		this.current = current;
	}
	
	public int getCurrent() {
		return current;
	}
	
	private int left ;
	public void setLeft() {
		this.left = current - 3;
	}
	public int getLeft() {
		if(current < 4 ) {
			return 1;
		}
		return Math.max(current - 3, 1);
	}
	
	public int getRight() {
		if(current < 4) {
			return 7;
		}
		return Math.min(current + 3, end);

	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getEnd() {
		return end;
	}
}
