package com.ustc.edu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.FrameLayout.LayoutParams;

public class IndexActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index_layout);
		
		int height = getWindowManager().getDefaultDisplay().getHeight();
		int width = getWindowManager().getDefaultDisplay().getWidth();
		
		ImageView head = (ImageView) findViewById(R.id.head);
		LayoutParams headParams = (LayoutParams) head.getLayoutParams();
		headParams.leftMargin = width / 6;
		headParams.topMargin = height / 5;
		head.setLayoutParams(headParams);
		
		LinearLayout buttonLayout = (LinearLayout) findViewById(R.id.buttons);
		LayoutParams buttonParams = (LayoutParams) buttonLayout.getLayoutParams();
		buttonParams.leftMargin = width / 3;
		buttonParams.topMargin = height / 2;
		
		buttonLayout.setLayoutParams(buttonParams);
	}
	
	public void onClick(View view) {
		
	}
}
