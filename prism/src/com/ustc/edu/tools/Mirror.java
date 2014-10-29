package com.ustc.edu.tools;

import com.ustc.edu.R;

import android.view.View;

public class Mirror extends Tool {

	public Mirror() {
		setImages(new int[] { R.drawable.mirror1, R.drawable.mirror2,
				R.drawable.mirror3, R.drawable.mirror4, R.drawable.mirror5,
				R.drawable.mirror6, R.drawable.mirror7, R.drawable.mirror8 });
	}

	@Override
	protected void reflect(View lazerView, Laser laser) {

	}

}
