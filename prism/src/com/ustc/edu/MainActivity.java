package com.ustc.edu;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ustc.edu.tools.Tool;

public class MainActivity extends Activity implements OnTouchListener {
	private int width;
	private int height;
	private int gridNum = 6;

	private int touchX = -1;
	private int touchY = -1;
	private int line = -1;
	private int column = -1;
	private Tool touchTool = null;
	private boolean toolTag = false;
	private ImageView touchImage;
	private boolean imgTag = false;

	private GridViewTools gridViewTools;
	private GridViewMain gridViewMain;
	private View laserView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		width = getWindowManager().getDefaultDisplay().getWidth();
		height = getWindowManager().getDefaultDisplay().getHeight();

		new MainFrame(this, gridNum);
		new ToolsFrame(this, (width - height) * gridNum / height, gridNum / 2);
		gridViewMain = new GridViewMain(this, gridNum,
				"N0N0N0N0N0N0N0N0N0N0N0N0" + "R6N0N0N0N0N0N0N0N0N0N0N0"
						+ "N0N0N0N0N0N0N0N0N0N0r0N0");
		gridViewTools = new GridViewTools(this, (width - height) * gridNum
				/ height, gridNum / 2, "M1M8");
		laserView = new LaserView(this, gridViewMain.getGrids(), height
				/ gridNum);
		FrameLayout laserPanel = (FrameLayout) findViewById(R.id.laserPanel);
		laserPanel.addView(laserView);
		RelativeLayout layout = (RelativeLayout) findViewById(R.id.touch_panel);
		touchImage = (ImageView) findViewById(R.id.touchImage);
		layout.setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (touchX == -1 && touchY == -1) {
			touchX = (int) event.getX();
			touchY = (int) event.getY();
			System.out.println(width + " " + height + " " + touchX + " "
					+ touchY);
			if (touchX > height && touchY > height / 2)
				return false;
			column = touchX * gridNum / height;
			line = touchY * gridNum / height;
		}

		int x = (int) event.getX();
		int y = (int) event.getY();
		int c = x * gridNum / height;
		int l = y * gridNum / height;

		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
			if (column >= gridNum && toolTag == false) {
				toolTag = true;
				touchTool = gridViewTools.removeTool(line, column - gridNum);
			} else if (toolTag == false) {
				toolTag = true;
				touchTool = gridViewMain.removeTool(line, column);
			}
			if (!imgTag && touchTool != null) {
				touchImage.setImageResource(touchTool.getImage());
				imgTag = true;
			}
			touchImage.layout(x - 5, y - 5, x + height / gridNum - 5, y
					+ height / gridNum - 5);
			break;
		case MotionEvent.ACTION_UP:
			if (c >= gridNum) {
				if (y >= height / 2) {
					if (column >= gridNum) {
						gridViewTools.addToolToGrid(line, column - gridNum,
								touchTool);
					} else {
						gridViewMain.addToolToGrid(line, column, touchTool);
					}
				} else if (!gridViewTools.addToolToGrid(l, c - gridNum,
						touchTool)) {
					if (column >= gridNum) {
						gridViewTools.addToolToGrid(line, column - gridNum,
								touchTool);
					} else {
						gridViewMain.addToolToGrid(line, column, touchTool);
					}
				}
				if (c == column && l == line) {
					gridViewTools.changeGrid(l, c - gridNum);
				}
			} else {
				if (!gridViewMain.addToolToGrid(l, c, touchTool)) {
					if (column >= gridNum) {
						gridViewTools.addToolToGrid(line, column - gridNum,
								touchTool);
					} else {
						gridViewMain.addToolToGrid(line, column, touchTool);
					}
				}
				if (c == column && l == line)
					gridViewMain.changeGrid(l, c);
			}
			touchX = touchY = -1;
			touchTool = null;
			toolTag = false;
			imgTag = false;
			touchImage.setImageResource(-1);
			touchImage.postInvalidate();
			laserView.postInvalidate();
			break;
		default:
			break;
		}
		return true;
	}
}