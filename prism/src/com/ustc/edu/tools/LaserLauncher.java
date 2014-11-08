package com.ustc.edu.tools;

import android.graphics.Color;

import com.ustc.edu.R;

public class LaserLauncher extends Tool {

	private int id;
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
		} else if (color == Color.BLUE) {
			setImages(new int[] { R.drawable.blue_launcher1,
					R.drawable.red_launcher2, R.drawable.red_launcher3,
					R.drawable.red_launcher4, R.drawable.blue_launcher5,
					R.drawable.red_launcher6, R.drawable.red_launcher7,
					R.drawable.red_launcher8 });
		}
		laser = new Laser(color, getDirection());
	}

	@Override
	public Laser reflect(Laser laser) {
		int d = laser.getDirection();
		if (d == this.direction)
			return laser;
		d = (d + 3) % 8 + 1;
		System.out.println("*");
		if (d == this.direction && laser.getId() != this.id) {
			System.out.println("**");
			laser.setColor(colorMingle(this.color, laser.getColor()));
			laser.setDirection(d);
			return laser;
		} else {
			System.out.println(laser.getColor() + " ***" + d + " " + this.direction + " "
					+ laser.getId() + " " + this.id);
			return null;
		}
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
		laser.setDirection(getDirection());
		laser.setId(this.id);
		laser.setColor(this.color);
		return laser;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
