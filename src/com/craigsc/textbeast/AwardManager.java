package com.craigsc.textbeast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.craigsc.textbeast.domain.ReceivedAchievement;
import com.craigsc.textbeast.managers.AchievementManager;

public class AwardManager {
	private static final int TROPHY_ID = 1;
	
	public static void award(final Context context) {
		//award for received texts
		int numReceived = AchievementManager.getReceived(context);
		for (ReceivedAchievement a : ReceivedAchievement.values()) {
			if (a.getNumTexts() == numReceived && !AchievementManager.hasAchievement(context, a)) {
				achievementUnlocked(context, a);
				break;
			}
		}
	}
	
	private static void achievementUnlocked(Context c, ReceivedAchievement a) {
		AchievementManager.awardAchievement(c, a);
		
		NotificationManager nm = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
		String tickerText = "You've unlocked the " + a.getName() + " trophy!";
		Notification notification = new Notification(a.getImage(), tickerText, System.currentTimeMillis());
		PendingIntent intent = PendingIntent.getActivity(c, 0, new Intent(c, TextBeast.class), 0);
		notification.setLatestEventInfo(c, tickerText, "You have received a total of " + a.getNumTexts() + " texts", intent);
		//possibly make this a preferences thing
		notification.defaults |= Notification.DEFAULT_ALL;
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		
		nm.notify(TROPHY_ID, notification);
	}
}
