package org.zerock.domian.ex01;


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
		return Math.max(current - 3, 1);
	}
	
	public int getRight() {
		if(left == -2) {
			return Math.min(current + 5, end);
		}else if(left == -1){
			return current + 4;
		}else if(left == 0){
			return current + 3;
		}else {
			return Math.min(current + 3, end);
		}
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getEnd() {
		return end;
	}
}
