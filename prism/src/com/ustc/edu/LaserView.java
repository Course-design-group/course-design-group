package com.ustc.edu;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.ustc.edu.tools.Laser;

public class LaserView extends View {
	private Laser[] lasers;
	private Context context;

	public LaserView(Context context) {
		super(context);
		this.context = context;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}

}
