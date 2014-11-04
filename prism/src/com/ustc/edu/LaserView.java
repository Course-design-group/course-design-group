package com.ustc.edu;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.TableLayout.LayoutParams;

import com.ustc.edu.tools.Grid;
import com.ustc.edu.tools.Lamp;
import com.ustc.edu.tools.Laser;
import com.ustc.edu.tools.LaserLauncher;
import com.ustc.edu.tools.Tool;

public class LaserView extends View {
	private ArrayList<LaserLauncher> launchers = new ArrayList<LaserLauncher>();
	private ArrayList<Lamp> lamps = new ArrayList<Lamp>();
	private Grid[][] grids;
	private int gridSize;
	private Paint paint;
	private int linePlus = -1;
	private int columnPlus = -1;
	private GridViewMain main;

	public LaserView(Context context, GridViewMain main, int gridSize) {
		super(context);
		System.out.println("constructor");
		this.main = main;
		this.grids = main.getGrids();
		this.gridSize = gridSize;

		for (int i = 0; i < grids.length; i++) {
			for (int j = 0; j < grids[i].length; j++)
				if (grids[i][j].getTool() instanceof LaserLauncher) {
					LaserLauncher launcher = (LaserLauncher) grids[i][j]
							.getTool();
					launcher.setLine(i);
					launcher.setColumn(j);
					launchers.add(launcher);
				} else if (grids[i][j].getTool() instanceof Lamp) {
					Lamp lamp = (Lamp) grids[i][j].getTool();
					lamp.setLine(i);
					lamp.setColumn(j);
					lamps.add(lamp);
				}
		}

		paint = new Paint();
		LayoutParams params = new LayoutParams();
		params.width = LayoutParams.FILL_PARENT;
		params.height = LayoutParams.FILL_PARENT;
		setLayoutParams(params);
		setVisibility(VISIBLE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		System.out.println("on draw");
		for(int i = 0; i < lamps.size(); i++) {
			Lamp lamp = lamps.get(i);
			lamp.close();
			main.changeGrid2(lamp.getLine(), lamp.getColumn());
		}
		
		for (int i = 0; i < launchers.size(); i++) {
			LaserLauncher launcher = launchers.get(i);
			linePlus = columnPlus = -1;
			emitLaser(launcher.emitLaser(), launcher.getLine(), launcher
					.getColumn(), canvas);
		}
	}

	private void emitLaser(Laser laser, int line, int column, Canvas canvas) {
		if (line >= grids.length || column >= grids[0].length)
			return;
		if (line < 0 || column < 0)
			return;
		Tool t = grids[line][column].getTool();
		if (t != null) {
			laser = t.reflect(laser);
			if (laser == null)
				return;
			if (t instanceof Lamp) {
				main.changeGrid2(line, column);
			}

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
		float stopX;
		float stopY;
		if (column + columnPlus >= grids.length) {
			stopX = startX + columnPlus * gridSize / 2;
			stopY = startY + linePlus * gridSize / 2;
		} else {
			stopX = (column + columnPlus) * gridSize + gridSize / 2 + 5;
			stopY = (line + linePlus) * gridSize + gridSize / 2 + 5;
		}

		paint.setColor(laser.getColor());
		paint.setStrokeWidth((float) 1.5);
		canvas.drawLine(startX, startY, stopX, stopY, paint);
		emitLaser(laser, line + linePlus, column + columnPlus, canvas);
	}
}
