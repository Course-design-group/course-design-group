package com.ustc.edu;

import android.app.Activity;
import android.graphics.Color;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ToolsFrame {
	private Activity activity;
	private int lines = -1;
	private int columns = -1;

	public ToolsFrame(Activity activity, int columns, int lines) {
		this.activity = activity;
		this.lines = lines;
		this.columns = columns;
		initMenuFrame();
	}

	private void initMenuFrame() {
		int height = activity.getWindowManager().getDefaultDisplay()
				.getHeight();
		
		LinearLayout mapLayout = (LinearLayout) activity
				.findViewById(R.id.toolsLayout);
		for (int i = 0; i < lines; i++) {
			LinearLayout layout = new LinearLayout(activity);

			LayoutParams layoutParams = new LayoutParams();
			layoutParams.width = LayoutParams.FILL_PARENT;
			layoutParams.height = LayoutParams.WRAP_CONTENT;
			layoutParams.verticalMargin = 0.5f;
			layoutParams.horizontalMargin = 0.5f;
			layout.setBackgroundColor(Color.TRANSPARENT);
			layout.setLayoutParams(layoutParams);

			ImageView[] mapView = new ImageView[columns];

			for (int j = 0; j < columns; j++) {
				mapView[j] = new ImageView(activity);
				LayoutParams cellParams = new LayoutParams();
				cellParams.width = (height - 4) / (2 * lines);
				cellParams.height = (height - 4) / (2 * lines);
				mapView[j].setImageResource(R.drawable.tools_cell);
				mapView[j].setLayoutParams(cellParams);
				layout.addView(mapView[j]);
			}
			mapLayout.addView(layout);
		}
	}
}
