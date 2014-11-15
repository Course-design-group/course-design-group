package com.ustc.edu.tools;

import com.ustc.edu.components.Laser;

import android.graphics.Color;

public abstract class Tool {
	protected static final int RED = Color.RED;
	protected static final int GREEN = Color.GREEN;
	protected static final int BLUE = Color.BLUE;
	protected static final int YELLOW = Color.YELLOW;
	protected static final int CYAN = Color.CYAN;
	protected static final int PURPLE = -65281;
	protected static final int WHITE = Color.WHITE;

	protected int[][] colorMatrix = new int[][] {
			{ RED, YELLOW, PURPLE, YELLOW, PURPLE, WHITE, WHITE },
			{ YELLOW, GREEN, CYAN, YELLOW, WHITE, CYAN, WHITE },
			{ PURPLE, CYAN, BLUE, WHITE, PURPLE, CYAN, WHITE },
			{ YELLOW, YELLOW, WHITE, YELLOW, WHITE, WHITE, WHITE },
			{ PURPLE, WHITE, PURPLE, WHITE, PURPLE, WHITE, WHITE },
			{ WHITE, CYAN, CYAN, WHITE, WHITE, CYAN, WHITE },
			{ WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE } };

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

	protected int colorMingle(int color1, int color2) {
		if (color1 == -1) {
			return color2;
		}
		
		int index1 = -1;
		switch (color1) {
		case RED:
			index1 = 0;
			break;
		case GREEN:
			index1 = 1;
			break;
		case BLUE:
			index1 = 2;
			break;
		case YELLOW:
			index1 = 3;
			break;
		case PURPLE:
			index1 = 4;
			break;
		case CYAN:
			index1 = 5;
			break;
		case WHITE:
			index1 = 6;
			break;
		}

		int index2 = -1;
		switch (color2) {
		case RED:
			index2 = 0;
			break;
		case GREEN:
			index2 = 1;
			break;
		case BLUE:
			index2 = 2;
			break;
		case YELLOW:
			index2 = 3;
			break;
		case PURPLE:
			index2 = 4;
			break;
		case CYAN:
			index2 = 5;
			break;
		case WHITE:
			index2 = 6;
			break;
		}
		return colorMatrix[index1][index2];
	}
}
