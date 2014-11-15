package com.ustc.edu.view;

import android.R.color;
import android.app.Activity;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ustc.edu.R;
import com.ustc.edu.components.Grid;
import com.ustc.edu.tools.Tool;
import com.ustc.edu.tools.ToolFactory;

public class GridViewMain {
	private Activity activity;
	private Grid[][] grids;
	private ImageView[][] mapGrids;
	private int gridNum = -1;

	public GridViewMain(Activity activity, int gridNum, String map) {
		this.activity = activity;
		this.gridNum = gridNum;
		initGrids(map);
		initGridsFrame();
	}

	private void initGrids(String mode) {
		grids = new Grid[gridNum][gridNum];
		mapGrids = new ImageView[gridNum][gridNum];
		int k = 0;
		char[] m = mode.toCharArray();

		for (int i = 0; i < gridNum; i++) {
			for (int j = 0; j < gridNum; j++) {
				grids[i][j] = new Grid();
				if (k < m.length) {
					grids[i][j].setTool(ToolFactory.createTool(m[k], m[k + 1]));
				}
				k += 2;
			}
		}
	}

	private void initGridsFrame() {
		int height = activity.getWindowManager().getDefaultDisplay()
				.getHeight();
		LinearLayout outerLayout = (LinearLayout) activity
				.findViewById(R.id.layout_grid);
		for (int i = 0; i < gridNum; i++) {
			LinearLayout layout = new LinearLayout(activity);

			LayoutParams layoutParams = new LayoutParams();
			layoutParams.width = LayoutParams.FILL_PARENT;
			layoutParams.height = LayoutParams.WRAP_CONTENT;
			layoutParams.verticalMargin = 0.5f;
			layoutParams.horizontalMargin = 0.5f;
			layout.setLayoutParams(layoutParams);
			layout.setBackgroundColor(color.transparent);

			for (int j = 0; j < gridNum; j++) {
				mapGrids[i][j] = new ImageView(activity);
				LayoutParams cellParams = new LayoutParams();
				cellParams.width = (height - 5) / gridNum;
				cellParams.height = (height - 5) / gridNum;
				int imageSrc = grids[i][j].getImage();
				if (imageSrc != -1) {
					mapGrids[i][j].setImageResource(imageSrc);
				}
				mapGrids[i][j].setLayoutParams(cellParams);
				layout.addView(mapGrids[i][j]);
			}
			outerLayout.addView(layout);
		}
	}

	public void changeGrid(int line, int column) {
		Tool tool = grids[line][column].getTool();
		if (tool == null || ! tool.isMovable()) {
			return;
		}
		changeGrid2(line, column);
	}
	
	public void changeGrid2(int line, int column) {
		Tool tool = grids[line][column].getTool();
		int index = tool.getDirection() + 1;
		if (index == 9)
			index = 1;
		tool.setDirection(index);
		mapGrids[line][column].setImageResource(grids[line][column].getImage());
//		mapGrids[line][column].postInvalidate();
	}

	public Tool removeTool(int line, int column) {
		Tool t = grids[line][column].getTool();
		if(t == null || ! t.isMovable()) {
			return null;
		}
		grids[line][column].removeTool();
		mapGrids[line][column].setImageResource(-1);
//		mapGrids[line][column].postInvalidate();
		return t;
	}
	
	public boolean addToolToGrid(int line, int column, Tool tool) {
		if(grids[line][column].getTool() != null) {
			return false;
		} else {
			grids[line][column].setTool(tool);
			mapGrids[line][column].setImageResource(grids[line][column].getImage());
//			mapGrids[line][column].postInvalidate();
			return true;
		}
	}
	
	public Grid[][] getGrids() {
		return grids;
	}
}
