package com.demo.tools;

import android.app.Activity;
import android.content.Context;
import android.view.Window;

public class NavigationUtility {

	public static void hideNavigationBar(Context context){
		((Activity) context).requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
}
