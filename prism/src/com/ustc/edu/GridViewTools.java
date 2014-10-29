package com.ustc.edu;

import android.app.Activity;
import android.graphics.Color;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ustc.edu.tools.Grid;
import com.ustc.edu.tools.Tool;
import com.ustc.edu.tools.ToolFactory;

public class GridViewTools {
	private Activity activity;
	private Grid[][] grids;
	private int lines = -1;
	private int columns = -1;
	private ImageView[][] toolsView = null;

	public GridViewTools(Activity activity, int columns, int lines, String map) {
		this.activity = activity;
		this.columns = columns;
		this.lines = lines;
		initGrids(map);
		initMenuFrame();
	}

	private void initGrids(String map) {
		char[] m = map.toCharArray();
		int k = 0;
		grids = new Grid[lines][columns];
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				grids[i][j] = new Grid();
				if (k < m.length) {
					grids[i][j].setTool(ToolFactory.createTool(m[k], m[k + 1]));
				}
				k += 2;
			}
		}
	}

	private void initMenuFrame() {
		int height = activity.getWindowManager().getDefaultDisplay()
				.getHeight();

		LinearLayout mapLayout = (LinearLayout) activity
				.findViewById(R.id.grid_tools_layout);
		toolsView = new ImageView[lines][columns];
		for (int i = 0; i < lines; i++) {
			LinearLayout layout = new LinearLayout(activity);

			LayoutParams layoutParams = new LayoutParams();
			layoutParams.width = LayoutParams.FILL_PARENT;
			layoutParams.height = LayoutParams.WRAP_CONTENT;
			layoutParams.verticalMargin = 0.5f;
			layoutParams.horizontalMargin = 0.5f;
			layout.setBackgroundColor(Color.TRANSPARENT);
			layout.setLayoutParams(layoutParams);

			for (int j = 0; j < columns; j++) {
				toolsView[i][j] = new ImageView(activity);
				LayoutParams cellParams = new LayoutParams();
				cellParams.width = (height - 4) / (2 * lines);
				cellParams.height = (height - 4) / (2 * lines);
				toolsView[i][j].setImageResource(grids[i][j].getImage());
				toolsView[i][j].setLayoutParams(cellParams);
				layout.addView(toolsView[i][j]);
			}
			mapLayout.addView(layout);
		}
	}

	public void changeGrid(int line, int column) {
		System.out.println("Tools: chage grid");
		Tool tool = grids[line][column].getTool();
		if (tool == null) {
			return;
		}
		int index = tool.getCurrentImageIndex() + 1;
		if(index == 9)
			index = 1;
		tool.setCurrentImageIndex(index);
		toolsView[line][column]
				.setImageResource(grids[line][column].getImage());
		toolsView[line][column].postInvalidate();
	}
	
	public Tool removeTool(int line, int column) {
		Tool t = grids[line][column].removeTool();
		toolsView[line][column].setImageResource(-1);
		toolsView[line][column].postInvalidate();
		return t;
	}
	
	public boolean addToolToGrid(int line, int column, Tool tool) {
		if(grids[line][column].getTool() != null) {
			return false;
		} else {
			grids[line][column].setTool(tool);
			toolsView[line][column].setImageResource(grids[line][column].getImage());
			toolsView[line][column].postInvalidate();
			return true;
		}
	}
}
