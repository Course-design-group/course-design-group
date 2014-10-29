package com.ustc.edu.tools;

import android.view.View;

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
	protected int currentImageIndex = 5;
	
	protected abstract void reflect(View lazerView, Laser laser);
	
	public int getCurrentImageIndex() {
		return currentImageIndex;
	}
	
	public void setCurrentImageIndex(int currentImage) {
		this.currentImageIndex = currentImage;
	}
	
	public int[] getImages(int[] images) {
		return images;
	}
	
	public void setImages(int[] images) {
		this.images = images;
	}
	
	public int getImage() {
		return images[currentImageIndex - 1];
	}
}
