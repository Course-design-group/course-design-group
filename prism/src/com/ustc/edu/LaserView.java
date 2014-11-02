package com.ustc.edu;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.TableLayout.LayoutParams;

import com.ustc.edu.tools.Grid;
import com.ustc.edu.tools.Laser;
import com.ustc.edu.tools.LaserLauncher;
import com.ustc.edu.tools.Tool;

public class LaserView extends View {
	private ArrayList<LaserLauncher> launchers = new ArrayList<LaserLauncher>();
	private Grid[][] grids;
	private int gridSize;
	private Paint paint;
	private int linePlus = -1;
	private int columnPlus = -1;

	public LaserView(Context context, Grid[][] grids, int gridSize) {
		super(context);
		this.grids = grids;
		this.gridSize = gridSize;

		for (int i = 0; i < grids.length; i++) {
			for (int j = 0; j < grids[i].length; j++)
				if (grids[i][j].getTool() instanceof LaserLauncher) {
					LaserLauncher launcher = (LaserLauncher) grids[i][j]
							.getTool();
					launcher.setLine(i);
					launcher.setColumn(j);
					launchers.add(launcher);
				}
		}
		
		paint = new Paint();
		LayoutParams params = new LayoutParams();
		params.width = LayoutParams.FILL_PARENT;
		params.height = LayoutParams.FILL_PARENT;
		setLayoutParams(params);
		setVisibility(VISIBLE);
		invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		for (int i = 0; i < launchers.size(); i++) {
			LaserLauncher launcher = launchers.get(i);
			linePlus = columnPlus = -1;
			emitLaser(launcher.emitLaser(), launcher.getLine(), launcher
					.getColumn(), canvas);
		}
	}

	private void emitLaser(Laser laser, int line, int column, Canvas canvas) {
		if(line >= grids.length || column >= grids[0].length)
			return;
		if(line < 0 || column < 0)
			return;
		if(laser == null)
			return;
		Tool t = grids[line][column].getTool();
		if (t != null) {
			t.reflect(laser);
			switch (laser.getDirection()) {
			case 1:
				columnPlus = -1;
				linePlus = 0;
				break;
			case 2:
				columnPlus = -1;
				linePlus = -1;
				break;
			case 3:
				columnPlus = 0;
				linePlus = -1;
				break;
			case 4:
				columnPlus = 1;
				linePlus = -1;
				break;
			case 5:
				columnPlus = 1;
				linePlus = 0;
				break;
			case 6:
				columnPlus = 1;
				linePlus = 1;
				break;
			case 7:
				columnPlus = 0;
				linePlus = 1;
				break;
			case 8:
				columnPlus = -1;
				linePlus = 1;
				break;
			}
		}

		float startX = column * gridSize + gridSize / 2 + 5;
		float startY = line * gridSize + gridSize / 2 + 5;
		float stopX = (column + columnPlus) * gridSize + gridSize/2 + 5;
		float stopY = (line + linePlus) * gridSize + gridSize / 2 + 5;
		paint.setColor(laser.getColor());
		paint.setStrokeWidth((float) 1.5);
		canvas.drawLine(startX, startY, stopX, stopY, paint);
		emitLaser(laser, line + linePlus, column + columnPlus, canvas);
	}
}
