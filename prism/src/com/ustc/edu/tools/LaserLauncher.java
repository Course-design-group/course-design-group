package com.ustc.edu.tools;

import android.graphics.Color;

import com.ustc.edu.R;

public class LaserLauncher extends Tool {
	private int color;
	private int line = -1;
	private int column = -1;
	private Laser laser = null;

	public LaserLauncher(int color) {
		this.color = color;
		if (color == Color.RED) {
			setImages(new int[] { R.drawable.red_launcher1,
					R.drawable.red_launcher2, R.drawable.red_launcher3,
					R.drawable.red_launcher4, R.drawable.red_launcher5,
					R.drawable.red_launcher6, R.drawable.red_launcher7,
					R.drawable.red_launcher8 });
		}
		laser = new Laser(color, getCurrentImageIndex());
	}

	@Override
	public void reflect(Laser laser) {

	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getColumn() {
		return column;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getLine() {
		return line;
	}

	public Laser emitLaser() {
		laser.setDirection(getCurrentImageIndex());
		return laser;
	}
}
