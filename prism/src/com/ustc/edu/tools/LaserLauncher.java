package com.ustc.edu.tools;

import com.ustc.edu.R;

import android.view.View;

public class LaserLauncher extends Tool {
	private int color;

	public LaserLauncher(int color) {
		this.color = color;
		setImages(new int[] { -1, -1, -1, -1, R.drawable.red_launcher, -1, -1, -1 });
	}

	@Override
	protected void reflect(View lazerView, Laser laser) {

	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
