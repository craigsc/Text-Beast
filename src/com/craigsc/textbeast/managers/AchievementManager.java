package com.craigsc.textbeast.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.craigsc.textbeast.domain.ReceivedAchievement;

public class AchievementManager {
	private static final String ACHIEVEMENTS = "achievement_counts";
	private static final String NUM_RECEIVED = "num_received";
	
	public static void incrementReceived(final Context context) {
		SharedPreferences prefs = getPrefs(context);
		prefs.edit().putInt(NUM_RECEIVED, prefs.getInt(NUM_RECEIVED, 0) + 1).commit();
	}
	
	public static int getReceived(final Context context) {
		return getPrefs(context).getInt(NUM_RECEIVED, 0);
	}
	
	public static void clearStats(Context context) {
		getPrefs(context).edit().clear().commit();
	}
	
	public static boolean hasAchievement(Context c, ReceivedAchievement a) {
		return a.getNumTexts() <= 0 || getPrefs(c).getBoolean(a.getName(), false);
	}
	
	public static void awardAchievement(Context c, ReceivedAchievement a) {
		getPrefs(c).edit().putBoolean(a.getName(), true).commit();
	}
	
	private static SharedPreferences getPrefs(final Context context) {
		return context.getSharedPreferences(ACHIEVEMENTS, Context.MODE_PRIVATE);
	}
}
