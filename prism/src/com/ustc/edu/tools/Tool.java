package com.ustc.edu.tools;


public abstract class Tool {
	public final int WEST = 1;
	public final int EAST = 5;
	public final int SOUTH = 7;
	public final int NORTH = 3;
	public final int NORTH_WEST = 2;
	public final int NORTH_EAST = 4;
	public final int SOUTH_WEST = 8;
	public final int SOUTH_EAST = 6;
	
	protected int[] images = new int[8];
	protected int direction = 5;
	
	private boolean movable = true;
	
	public abstract Laser reflect(Laser laser);
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int[] getImages(int[] images) {
		return images;
	}
	
	public void setImages(int[] images) {
		this.images = images;
	}
	
	public int getImage() {
		return images[direction - 1];
	}

	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	public boolean isMovable() {
		return movable;
	}
}
