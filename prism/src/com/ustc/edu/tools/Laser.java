package com.ustc.edu.tools;

public class Laser {
	private int color;
	private int direction;
	
	public Laser(int color, int direction) {
		this.direction = direction;
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}
}
