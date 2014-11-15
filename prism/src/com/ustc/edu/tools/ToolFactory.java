package com.ustc.edu.tools;

import com.ustc.edu.tools.impl.ColorSplit;
import com.ustc.edu.tools.impl.DoubleMirror;
import com.ustc.edu.tools.impl.Lamp;
import com.ustc.edu.tools.impl.LaserLauncher;
import com.ustc.edu.tools.impl.Mirror;
import com.ustc.edu.tools.impl.Pipe;
import com.ustc.edu.tools.impl.TwistMirror;
import com.ustc.edu.tools.impl.Wall;

import android.graphics.Color;

public class ToolFactory {
	public static Tool createTool(char id, char direction) {
		Tool tool = null;
		int index = -1;
		switch (id) {
		case 'R':
			tool = new LaserLauncher(Color.RED);
			tool.setMovable(false);
			index = Integer.parseInt("" + direction);
			tool.setDirection(index);
			break;
		case 'G':
			tool = new LaserLauncher(Color.GREEN);
			tool.setMovable(false);
			index = Integer.parseInt("" + direction);
			tool.setDirection(index);
			break;
		case 'B':
			tool = new LaserLauncher(Color.BLUE);
			tool.setMovable(false);
			index = Integer.parseInt("" + direction);
			tool.setDirection(index);
			break;
		case 'N':
			tool = null;
			break;
		case 'M':
			tool = new Mirror();
			index = Integer.parseInt("" + direction);
			tool.setDirection(index);
			break;
		case 'T':
			tool = new TwistMirror();
			index = Integer.parseInt("" + direction);
			tool.setDirection(index);
			break;
		case 'D':
			tool = new DoubleMirror();
			index = Integer.parseInt("" + direction);
			tool.setDirection(index);
			break;
		case 'L':
			tool = new ColorSplit(Color.BLUE);
			index = Integer.parseInt("" + direction);
			tool.setDirection(index);
			break;
		case 'V':
			tool = new ColorSplit(Color.GREEN);
			index = Integer.parseInt("" + direction);
			tool.setDirection(index);
			break;
		case 'Q':
			tool = new Wall();
			index = Integer.parseInt("" + direction);
			tool.setMovable(false);
			tool.setDirection(index);
			break;
		case 'S':
			tool = new Pipe();
			index = Integer.parseInt("" + direction);
			tool.setMovable(false);
			tool.setDirection(index);
			break;
		case 'H':
			tool = new ColorSplit(Color.RED);
			index = Integer.parseInt("" + direction);
			tool.setDirection(index);
			break;
		case 'r':
			tool = new Lamp(Color.RED);
			index = 1;
			tool.setDirection(index);
			tool.setMovable(false);
			break;
		case 'g':
			tool = new Lamp(Color.GREEN);
			index = 1;
			tool.setDirection(index);
			tool.setMovable(false);
			break;
		case 'b':
			tool = new Lamp(Color.BLUE);
			index = 1;
			tool.setDirection(index);
			tool.setMovable(false);
			break;
		case 'y':
			tool = new Lamp(Color.YELLOW);
			index = 1;
			tool.setDirection(index);
			tool.setMovable(false);
			break;
		case 'p':
			tool = new Lamp(Color.rgb(255, 0, 255));
			index = 1;
			tool.setDirection(index);
			tool.setMovable(false);
			break;
		case 'c':
			tool = new Lamp(Color.CYAN);
			index = 1;
			tool.setDirection(index);
			tool.setMovable(false);
			break;
		case 'w':
			tool = new Lamp(Color.WHITE);
			index = 1;
			tool.setDirection(index);
			tool.setMovable(false);
			break;
		default:
			break;
		}
		return tool;
	}
}
