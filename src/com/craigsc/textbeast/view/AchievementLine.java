package com.craigsc.textbeast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.craigsc.textbeast.R;

public class AchievementLine extends LinearLayout {

	public AchievementLine(Context context) {
		super(context);
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layoutInflater.inflate(R.layout.achievement, this);
	}
}
