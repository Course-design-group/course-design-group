package com.ustc.edu.tools.impl;

import com.ustc.edu.R;
import com.ustc.edu.components.Laser;
import com.ustc.edu.tools.Tool;

public class DoubleMirror extends Tool {
	public DoubleMirror() {
		setImages(new int[] { R.drawable.double_mirror1, R.drawable.double_mirror2,
				R.drawable.double_mirror3, R.drawable.double_mirror4, R.drawable.double_mirror5,
				R.drawable.double_mirror6, R.drawable.double_mirror7, R.drawable.double_mirror8 });
	}

	@Override
	public Laser reflect(Laser laser) {
		int direction = laser.getDirection();
		direction = (direction + 3) % 8 + 1;
		
		int d = super.direction;
		if (direction % 8 + 1 == d) {
			direction = d % 8 + 1;
			laser.setDirection(direction);
			return laser;
		} else if ((direction + 6) % 8 + 1 == d) {
			direction = (d + 6) % 8 + 1;
			laser.setDirection(direction);
			return laser;
		} else {
			d = (d + 3) % 8 + 1;
			if (direction % 8 + 1 == d) {
				direction = d % 8 + 1;
				laser.setDirection(direction);
				return laser;
			} else if ((direction + 6) % 8 + 1 == d) {
				direction = (d + 6) % 8 + 1;
				laser.setDirection(direction);
				return laser;
			} else {
				return null;
			}
		}
	}
}
