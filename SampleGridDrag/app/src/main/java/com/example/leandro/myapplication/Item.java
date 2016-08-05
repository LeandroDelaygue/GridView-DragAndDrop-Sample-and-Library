/**
 * 
 */
package com.example.leandro.myapplication;

public class Item {

	int mIcon;
	int mSpans;
	String mTitle;
	String mDescription;
	String mDescription2;
	String mDescription3;

	public Item(int icon, int spans, String title, String description, String description2, String description3) {

		mIcon = icon;
		mSpans = spans;
		mTitle = title;
		mDescription = description;
		mDescription2 = description2;
		mDescription3= description3;
	}

	public int getSpans() {
		return mSpans;
	}

	public String getDescription() {
		return mDescription;
	}

	public int getIcon() {
		return mIcon;
	}

	public String getTitle() {
		return mTitle;
	}

	public String getmDescription3() {
		return mDescription3;
	}

	public void setmDescription3(String mDescription3) {
		this.mDescription3 = mDescription3;
	}

	public String getmDescription2() {
		return mDescription2;
	}

	public void setmDescription2(String mDescription2) {
		this.mDescription2 = mDescription2;
	}
}
