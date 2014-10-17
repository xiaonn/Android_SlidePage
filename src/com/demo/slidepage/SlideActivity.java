package com.demo.slidepage;

import java.util.ArrayList;
import java.util.List;

import com.demo.Adapter.ViewPagerAdapter;
import com.demo.tools.ImageUtility;
import com.demo.tools.ToastUtility;
import com.demo.tools.WindowUtility;

import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class SlideActivity extends Activity {

	private ViewPager viewPage;// 页卡内容
	private int currentIndex;// 当前页卡索引
	private ImageView slideImageView;// 滑动图片

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide);
		initImageView();
		initTextView();
		initViewPager();
	}

	/**!
	 * 初始化动画图片
	 * */
	private void initImageView() {
		slideImageView = (ImageView) findViewById(R.id.slide_image);
		int slideImageWidth = ImageUtility.getImageWidth(this, R.drawable.slide_picture);
		int screenWidth = WindowUtility.getWindowWidth(this);//获取屏幕宽度
		Matrix matrix = new Matrix();//图片偏移
		matrix.postTranslate((screenWidth / 3 - slideImageWidth) / 2, 0);//设置图片偏移量
		slideImageView.setImageMatrix(matrix);//设置图片偏移
	}

	/**!
	 * 初始化TextView
	 * */
	private void initTextView() {
		TextView textView1 = (TextView) findViewById(R.id.slide_bar_textView1);
		TextView textView2 = (TextView) findViewById(R.id.slide_bar_textView2);
		TextView textView3 = (TextView) findViewById(R.id.slide_bar_textView3);
		textView1.setOnClickListener(new SlideBarOnClickListener(0));
		textView2.setOnClickListener(new SlideBarOnClickListener(1));
		textView3.setOnClickListener(new SlideBarOnClickListener(2));
	}

	/**!
	 *   初始化ViewPager
	 * */
	private void initViewPager() {
		viewPage = (ViewPager) findViewById(R.id.slide_viewPager);//获取布局文件
		List<View> views = new ArrayList<View>();//初始化数组
		LayoutInflater inflater = LayoutInflater.from(this);//加载layoutInflater
		views.add(inflater.inflate(R.layout.child1, null));//加载view1
		views.add(inflater.inflate(R.layout.child2, null));//加载view2
		views.add(inflater.inflate(R.layout.child3, null));//加载view3
		viewPage.setAdapter(new ViewPagerAdapter(views));//加载适配器
		viewPage.setCurrentItem(0);//设置当前位置
		viewPage.setOnPageChangeListener(new SlideViewOnPageChangeListener());//设置当前页面变化的监听
	}

	/**
	 * ! 重写OnClickListener方法，实现TextView点击事件，根据初始化按钮的index生成listener
	 * */
	private class SlideBarOnClickListener implements OnClickListener {
		private int index = 0;

		public SlideBarOnClickListener(int index) {
			// TODO Auto-generated constructor stub
			this.index = index;
		}

		public void onClick(View v) {
			// TODO Auto-generated method stub
			viewPage.setCurrentItem(index);
		}
	}

	/**
	 * ! 重写ViewPager改变的Listener
	 * */
	private class SlideViewOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			int windowWidth = WindowUtility.getWindowWidth(SlideActivity.this);//获取屏幕宽度
			Animation animation = new TranslateAnimation(windowWidth
					/ 3 * currentIndex, windowWidth / 3 * arg0, 0, 0);//初始化动画效果
			animation.setFillAfter(true);// True:图片停留在动画结束的位置
			animation.setDuration(300);// 过渡时间

			slideImageView.startAnimation(animation);//开始动画
			currentIndex = arg0;//将当前页索引赋值给currentIndex

			ToastUtility.showToastShort(SlideActivity.this, "您选择了" + viewPage.getCurrentItem() + "页卡");//展示Toast
		}

	}
}
