package com.ustc.edu.tools;

import com.ustc.edu.R;

import android.graphics.Color;

public class Lamp extends Tool {
	private int color;

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
	public void reflect(Laser laser) {

	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getColor() {
		return color;
	}
}
