package com.ustc.edu.tools.impl;

import com.ustc.edu.R;
import com.ustc.edu.components.Laser;
import com.ustc.edu.tools.Tool;

import android.graphics.Color;

public class Lamp extends Tool {
	private int color;
	private int accumulateColor = -1;
	private int line;
	private int column;
	private Laser[] lasers = new Laser[4];

	public Lamp(int color) {
		this.setColor(color);
		if (color == Color.RED) {
			setImages(new int[] { R.drawable.red_lamp_dim,
					R.drawable.red_lamp_light, R.drawable.red_lamp_dim,
					R.drawable.red_lamp_light, R.drawable.red_lamp_dim,
					R.drawable.red_lamp_light, R.drawable.red_lamp_dim,
					R.drawable.red_lamp_light });
		} else if (color == Color.BLUE) {
			setImages(new int[] { R.drawable.blue_lamp_dim,
					R.drawable.blue_lamp_light, R.drawable.blue_lamp_dim,
					R.drawable.blue_lamp_light, R.drawable.blue_lamp_dim,
					R.drawable.blue_lamp_light, R.drawable.blue_lamp_dim,
					R.drawable.blue_lamp_light });
		} else if (color == Color.rgb(255, 0, 255)) {
			setImages(new int[] { R.drawable.purple_lamp_dim,
					R.drawable.purple_lamp_light, R.drawable.purple_lamp_dim,
					R.drawable.purple_lamp_light, R.drawable.purple_lamp_dim,
					R.drawable.purple_lamp_light, R.drawable.purple_lamp_dim,
					R.drawable.purple_lamp_light });
		} else if (color == Color.GREEN) {
			setImages(new int[] { R.drawable.green_lamp_dim,
					R.drawable.green_lamp_light, R.drawable.green_lamp_dim,
					R.drawable.green_lamp_light, R.drawable.green_lamp_dim,
					R.drawable.green_lamp_light, R.drawable.green_lamp_dim,
					R.drawable.green_lamp_light });
		} else if (color == Color.YELLOW) {
			setImages(new int[] { R.drawable.yellow_lamp_dim,
					R.drawable.yellow_lamp_light, R.drawable.yellow_lamp_dim,
					R.drawable.yellow_lamp_light, R.drawable.yellow_lamp_dim,
					R.drawable.yellow_lamp_light });
		} else if (color == Color.CYAN) {
			setImages(new int[] { R.drawable.cyan_lamp_dim,
					R.drawable.cyan_lamp_light, R.drawable.cyan_lamp_dim,
					R.drawable.cyan_lamp_light, R.drawable.cyan_lamp_dim,
					R.drawable.cyan_lamp_light, R.drawable.cyan_lamp_dim,
					R.drawable.cyan_lamp_light });
		} else if (color == Color.WHITE) {
			setImages(new int[] { R.drawable.white_lamp_dim,
					R.drawable.white_lamp_light, R.drawable.white_lamp_dim,
					R.drawable.white_lamp_light, R.drawable.white_lamp_dim,
					R.drawable.white_lamp_light, R.drawable.white_lamp_dim,
					R.drawable.white_lamp_light });
		} 
	}

	@Override
	public Laser reflect(Laser laser) {
		int d = laser.getDirection();
		if (d > 4) {
			d -= 4;
		}
		lasers[d - 1] = laser;

		if (check()) {
			open();
		} else {
			close();
		}
		return laser;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getColor() {
		return color;
	}

	public void open() {
		System.out.println("lamp open");
		super.direction = 3;
	}

	public void close() {
		super.direction = 2;
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

	private boolean check() {
		boolean isOpen = true;
		for (int i = 0; i < 4; i++) {
			if (lasers[i] != null) {
				accumulateColor = colorMingle(accumulateColor, lasers[i].getColor());
				if (lasers[i].getColor() != this.color) {
					isOpen = false;
				}
			}
		}
		if(accumulateColor == this.color)
			isOpen = true;
		return isOpen;
	}

	public void clearLaser() {
		for (int i = 0; i < 4; i++) {
			lasers[i] = null;
		}
		accumulateColor = -1;
	}
}
