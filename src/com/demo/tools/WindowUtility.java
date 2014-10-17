package com.demo.tools;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**!
 * @pragma WindowUtility:窗口工具类
 * @author lishuai
 * */
public class WindowUtility {
	
	/**!
	 * 获取屏幕宽度
	 * @param context:上下文
	 * */
	public static int getWindowWidth(Context context){
		return defaultDisplayMetrics(context).widthPixels;
	}
	
	/**!
	 * 获取高度
	 * @param context:上下文
	 * */
	public static int getWindowHeight(Context context){
		return defaultDisplayMetrics(context).heightPixels;
	}
	
	/**!
	 * 获取屏幕密度
	 * @param context:上下文
	 * */
	public static int getWindowDensity(Context context){
		return defaultDisplayMetrics(context).densityDpi;
	}
	
	public static DisplayMetrics defaultDisplayMetrics(Context context){
		DisplayMetrics dm = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm;
	}
}
