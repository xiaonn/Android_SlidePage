package com.demo.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**!
 * @pragma ImagUtility:图片处理的工具类
 * @author lishuai
 * */
public class ImageUtility {

	/**!
	 * 获取图片宽度
	 * @param context:当前上下文
	 * @param res:图片文件(R.drawable.xx)
	 * */
	public static int getImageWidth(Context context, int res){
		return getBitMap(context, res).getWidth();
	}
	
	/**!
	 * 获取图片高度
	 * @param context:当前上下文
	 * @param res:图片文件(R.drawable.xx)
	 * */
	public static int getImageHeight(Context context, int res){
		return getBitMap(context, res).getHeight();
	}
	
	/**!
	 * 获取位图
	 * @param context:当前上下文
	 * @param res:图片文件(R.drawable.xx)
	 * */
	public static Bitmap getBitMap(Context context, int res){
		Bitmap bitMap = BitmapFactory.decodeResource(context.getResources(), res);
		return bitMap;
	}
	
}
