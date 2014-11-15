package com.ustc.edu.tools.impl;

import com.ustc.edu.R;
import com.ustc.edu.components.Laser;
import com.ustc.edu.tools.Tool;

public class TwistMirror extends Tool {
	public TwistMirror() {
		setImages(new int[] { R.drawable.twist_mirror1,
				R.drawable.twist_mirror2, R.drawable.twist_mirror3,
				R.drawable.twist_mirror4, R.drawable.twist_mirror5,
				R.drawable.twist_mirror6, R.drawable.twist_mirror7,
				R.drawable.twist_mirror8 });
	}

	@Override
	public Laser reflect(Laser laser) {
		int d1, d2, d3, d4;
		d2 = this.direction;
		d1 = (d2 + 6) % 8 + 1;
		d3 = d2 % 8 + 1;
		d4 = (d2 + 1) % 8 + 1;
		
		int d = laser.getDirection();
		d = (d + 3) % 8 + 1;
		
		if(d == d1) {
			laser.setDirection(d4);
		} else if(d == d2) {
			laser.setDirection(d3);
		} else if(d == d3) {
			laser.setDirection(d2);
		} else if(d == d4) {
			laser.setDirection(d1);
		} else {
			return null;
		}
		
		return laser;
	}

}
