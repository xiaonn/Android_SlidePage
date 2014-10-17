package com.demo.tools;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**!
 * @pragma ToastUtility:展示Toast工具类
 * @pragma Android中的Toast是一种简易的消息提示框，toast提示框不能被用户点击，toast会根据用户设置的显示时间后自动消失
 * @author lishuai
 * */
public class ToastUtility {
	
	/**!
	 * 展示默认效果Toast(时间短)
	 * @param context:上下文
	 * @param message:需要toast展示的消息
	 * */
	public static void showToastShort(Context context, String message){
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}
	
	/**!
	 * 展示默认效果Toast(时间长)
	 * @param context:上下文
	 * @param message:需要toast展示的消息
	 * */
	public static void showToastLong(Context context, String message){
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}
	
	/**!
	 * 展示居中效果Toast(时间短)
	 * @param context:上下文
	 * @param message:需要toast展示的消息
	 * */
	public static void showCenterToast(Context context, String message){
		Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
	
	/**!
	 * 展示居中效果包含图片的Toast(时间短)
	 * @param context:上下文
	 * @param message:需要toast展示的消息
	 * @param resId:图片文件(R.drawable.xx)
	 * */
	public static void showCenterToastWithImage(Context context, String message, int resId){
		Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout linearlayout = (LinearLayout)toast.getView();
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(resId);
		linearlayout.addView(imageView);
		toast.show();
	}
	
}
