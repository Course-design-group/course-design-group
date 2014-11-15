package com.ustc.edu.tools.impl;

import android.graphics.Color;

import com.ustc.edu.R;
import com.ustc.edu.components.Laser;
import com.ustc.edu.tools.Tool;

public class ColorSplit extends Tool {
	int color;

	public ColorSplit(int color) {
		this.color = color;
		if (color == Color.RED) {
			setImages(new int[] { R.drawable.red_color_split1,
					R.drawable.red_color_split2, R.drawable.red_color_split3,
					R.drawable.red_color_split4, R.drawable.red_color_split5,
					R.drawable.red_color_split6, R.drawable.red_color_split7,
					R.drawable.red_color_split8 });
		} else if (color == Color.GREEN) {
			setImages(new int[] { R.drawable.green_color_split1,
					R.drawable.green_color_split2,
					R.drawable.green_color_split3,
					R.drawable.green_color_split4,
					R.drawable.green_color_split5,
					R.drawable.green_color_split6,
					R.drawable.green_color_split7,
					R.drawable.green_color_split8 });
		} else if (color == Color.BLUE) {
			setImages(new int[] { R.drawable.blue_color_split1,
					R.drawable.blue_color_split2, R.drawable.blue_color_split3,
					R.drawable.blue_color_split4, R.drawable.blue_color_split5,
					R.drawable.blue_color_split6, R.drawable.blue_color_split7,
					R.drawable.blue_color_split8 });
		}
	}

	@Override
	public Laser reflect(Laser laser) {
		int direction = laser.getDirection();
		int d = this.direction;
		if (direction != d && direction != (d + 3) % 8 + 1) {
			return null;
		}
		switch (laser.getColor()) {
		case RED:
			if (this.color != RED)
				return null;
			break;
		case GREEN:
			if (this.color != GREEN)
				return null;
			break;
		case BLUE:
			if (this.color != BLUE)
				return null;
			break;
		case YELLOW:
			if (color == BLUE)
				return null;
			break;
		case PURPLE:
			if (color == GREEN)
				return null;
			break;
		case CYAN:
			if (color == RED)
				return null;
			break;
		case WHITE:
			break;
		}
		laser.setColor(this.color);
		return laser;
	}

}
