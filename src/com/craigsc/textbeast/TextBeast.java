package com.craigsc.textbeast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.craigsc.textbeast.domain.ReceivedAchievement;
import com.craigsc.textbeast.managers.AchievementManager;
import com.craigsc.textbeast.view.AchievementLine;

public class TextBeast extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        AchievementManager.clearStats(this);
        
        ViewGroup container = (ViewGroup) findViewById(R.id.container);
        for (ReceivedAchievement a : ReceivedAchievement.values()) {
        	AchievementLine al = new AchievementLine(this);
            ImageView trophy = (ImageView) al.findViewById(R.id.received_trophy);
            TextView name = (TextView) al.findViewById(R.id.received_trophy_name);
            LinearLayout descContainer = (LinearLayout) al.findViewById(R.id.achievement_desc);
        	if (AchievementManager.hasAchievement(this, a)) {
        		trophy.setImageResource(a.getImage());
                name.setText(a.getName());
                TextView desc = new TextView(this);
                desc.setTextSize(12.0f);
                desc.setScrollContainer(false);
                desc.setGravity(Gravity.CENTER_HORIZONTAL);
                desc.setText(a.getTickerText());
                descContainer.addView(desc);
        	} else {
        		//change to locked icon
        		trophy.setImageResource(R.drawable.lock);
        		name.setText("Locked Trophy");
        		ProgressBar progress = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
                progress.setMax(a.getNextLevel());
                progress.setProgress(AchievementManager.getReceived(this));
                progress.setVisibility(View.VISIBLE);
                descContainer.addView(progress);
        	}
        	container.addView(al);
        }
    }
}