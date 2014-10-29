package com.ustc.edu.tools;

import android.graphics.Color;

public class ToolFactory {
	public static Tool createTool(char id, char direction) {
		Tool tool = null;
		int index = -1;
		switch (id) {
		case 'R':
			tool = new LaserLauncher(Color.RED);
			index = Integer.parseInt("" + direction);
			tool.setCurrentImageIndex(index);
			break;
		case 'N':
			tool = null;
			break;
		case 'M':
			tool = new Mirror();
			index = Integer.parseInt("" + direction);
			tool.setCurrentImageIndex(index);
			break;
		default:
			break;
		}
		return tool;
	}
}