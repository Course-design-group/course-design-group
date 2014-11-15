package com.ustc.edu.view;

import com.ustc.edu.R;

import android.R.color;
import android.app.Activity;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainFrame {
	private Activity activity;
	private int gridNum;
	
	public MainFrame(Activity activity, int gridNum) {
		this.activity = activity;
		this.gridNum = gridNum;
		initMainFrame();
	}

	private void initMainFrame() {
		int height = activity.getWindowManager().getDefaultDisplay()
				.getHeight();
		LinearLayout mapLayout = (LinearLayout) activity
				.findViewById(R.id.mapLayout);
		for (int i = 0; i < gridNum; i++) {
			LinearLayout layout = new LinearLayout(activity);

			LayoutParams layoutParams = new LayoutParams();
			layoutParams.width = LayoutParams.FILL_PARENT;
			layoutParams.height = LayoutParams.WRAP_CONTENT;
			layoutParams.verticalMargin = 0.5f;
			layoutParams.horizontalMargin = 0.5f;
			layout.setLayoutParams(layoutParams);
			layout.setBackgroundColor(color.transparent);

			ImageView[] mapView = new ImageView[gridNum];

			for (int j = 0; j < gridNum; j++) {
				mapView[j] = new ImageView(activity);
				LayoutParams cellParams = new LayoutParams();
				cellParams.width = (height - 5) / gridNum;
				cellParams.height = (height - 5) / gridNum;
				mapView[j].setImageResource(R.drawable.map_cell);
				mapView[j].setLayoutParams(cellParams);
				layout.addView(mapView[j]);
			}
			mapLayout.addView(layout);
		}
	}
}
