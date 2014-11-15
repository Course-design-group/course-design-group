package com.ustc.edu.tools.impl;

import com.ustc.edu.R;
import com.ustc.edu.components.Laser;
import com.ustc.edu.tools.Tool;

public class Wall extends Tool {
	public Wall() {
		setImages(new int[] { R.drawable.wall, R.drawable.wall,
				R.drawable.wall, R.drawable.wall, R.drawable.wall,
				R.drawable.wall, R.drawable.wall, R.drawable.wall });
	}

	@Override
	public Laser reflect(Laser laser) {
		return null;
	}

}
