package com.ustc.edu.tools;

import com.ustc.edu.R;

import android.graphics.Color;

public class Lamp extends Tool {
	private int color;
	private int line;
	private int column;

	public Lamp(int color) {
		this.setColor(color);
		if (color == Color.RED) {
			setImages(new int[] { R.drawable.red_lamp_dim,
					R.drawable.red_lamp_light, R.drawable.red_lamp_dim,
					R.drawable.red_lamp_light, R.drawable.red_lamp_dim,
					R.drawable.red_lamp_light, R.drawable.red_lamp_dim,
					R.drawable.red_lamp_light });
		}
	}

	@Override
	public Laser reflect(Laser laser) {
		open();
		return laser;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getColor() {
		return color;
	}
	
	public void open() {
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
}
