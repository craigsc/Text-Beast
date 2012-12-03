package com.craigsc.textbeast.domain;

import com.craigsc.textbeast.R;

public enum ReceivedAchievement {

	FOREVER_ALONE("Forever Alone", R.drawable.icon, 0),
	NOOB("Nublet", R.drawable.icon, 10),
	APPRENTICE("Apprentice Textist", R.drawable.icon, 50),
	SLOWLEARNER("Warming Up", R.drawable.icon, 100),
	ONFIRE("You're on Fire!", R.drawable.icon, 500),
	KING("King of Texting", R.drawable.icon, 1000),
	GURU("Guru", R.drawable.icon, 2500),
	INSANE("Insanity", R.drawable.icon, 5000),
	MASTER("Master of Texts", R.drawable.icon, 7500),
	BEAST("Text BEAST", R.drawable.icon, 10000);
	
	
	private String name;
	private int image;
	private int numTexts;
	
	ReceivedAchievement(String name, int image, int numTexts) {
		this.name = name;
		this.image = image;
		this.numTexts = numTexts;
	}
	
	public String getName() {
		return name;
	}
	
	public int getImage() {
		return image;
	}
	
	public int getNumTexts() {
		return numTexts;
	}
	
	public String getTickerText() {
		return "You've received " + numTexts + " texts!";
	}
	
	public int getNextLevel() {
		boolean stop = false;
		for (ReceivedAchievement a : ReceivedAchievement.values()) {
			if (stop) {
				return a.getNumTexts();
			}
			if (name.equals(a.getName())) {
				stop = true;
			}
		}
		//safety value
		return 1000000;
	}
	
}
