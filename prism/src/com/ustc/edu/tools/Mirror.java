package com.ustc.edu.tools;

import com.ustc.edu.R;


public class Mirror extends Tool {

	public Mirror() {
		setImages(new int[] { R.drawable.mirror1, R.drawable.mirror2,
				R.drawable.mirror3, R.drawable.mirror4, R.drawable.mirror5,
				R.drawable.mirror6, R.drawable.mirror7, R.drawable.mirror8 });
	}

	@Override
	public Laser reflect(Laser laser) {
		System.out.println("reflect");
		int direction = laser.getDirection();
		direction = (direction + 3) % 8 + 1;
		if(direction % 8 + 1 == super.direction) {
			direction = super.direction % 8 + 1;
			laser.setDirection(direction);
			return laser;
		} else if((direction + 6) % 8 + 1 == super.direction) {
			direction = (super.direction + 6) % 8 + 1;
			laser.setDirection(direction);
			return laser;
		} else {
			return null;
		}
	}

}
