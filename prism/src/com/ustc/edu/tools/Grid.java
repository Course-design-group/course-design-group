package com.ustc.edu.tools;

public class Grid {
	Tool tool = null;

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public int getImage() {
		if (tool != null) {
			return tool.getImage();
		} else {
			return -1;
		}
	}
	
	public Tool removeTool() {
		Tool t = tool;
		tool = null;
		return t;
	}
}
