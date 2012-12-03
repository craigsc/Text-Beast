package com.craigsc.textbeast.receivers;

import com.craigsc.textbeast.AwardManager;
import com.craigsc.textbeast.managers.AchievementManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SMSReceived extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("TextBeast", "hit");
		//update count
		AchievementManager.incrementReceived(context);
		//determine whether any new achievements have been unlocked
		AwardManager.award(context);
	}
	
}
