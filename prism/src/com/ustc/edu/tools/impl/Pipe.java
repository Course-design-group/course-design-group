package com.ustc.edu.tools.impl;

import com.ustc.edu.R;
import com.ustc.edu.components.Laser;
import com.ustc.edu.tools.Tool;

public class Pipe extends Tool {
	public Pipe() {
		setImages(new int[] { R.drawable.pipe1, R.drawable.pipe2,
				R.drawable.pipe3, R.drawable.pipe4, R.drawable.pipe5,
				R.drawable.pipe6, R.drawable.pipe7, R.drawable.pipe8 });
	}

	@Override
	public Laser reflect(Laser laser) {
		int d = laser.getDirection();
		if (d == this.direction || (d + 3) % 8 + 1 == this.direction) {
			return laser;
		} else {
			return null;
		}
	}
}
