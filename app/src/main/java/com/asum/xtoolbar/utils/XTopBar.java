package com.asum.xtoolbar.utils;

import java.util.ArrayList;

import com.asum.xlayoutparams.utils.DensityUtils;
import com.asum.xlayoutparams.utils.XPxArea;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 顶部栏
 * 
 * @author Asum
 *
 */
public class XTopBar extends RelativeLayout {
	private Context context;
	private XTopBarCallBack callBack;

	private LinearLayout leftLayout;
	private TextView titleTextView;
	private LinearLayout rightLayout;

	private ArrayList<RelativeLayout> leftLayouts;
	private ArrayList<TextView> leftButtons;

	private ArrayList<RelativeLayout> rightLayouts;
	private ArrayList<TextView> rightButtons;

	public XTopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	public XTopBar(Context context) {
		super(context);
		this.context = context;
	}

	public void initialize(double x, double y, double w, double h) {
		new XPxArea(context, this).set(x, y, w, h);

		getWidgets();
		setWidgets();
	}

	public void initialize() {
		getWidgets();
		setWidgets();

		this.setPadding((int) XTopBarConfig.LEFT_RIGHT_PADDING, DensityUtils.dip2px(context, 8), (int) XTopBarConfig.LEFT_RIGHT_PADDING, DensityUtils.dip2px(context, 8));
	}

	private void getWidgets() {
		leftLayout = new LinearLayout(context);
		titleTextView = new TextView(context);
		rightLayout = new LinearLayout(context);

		leftLayouts = new ArrayList<RelativeLayout>();
		leftButtons = new ArrayList<TextView>();

		rightLayouts = new ArrayList<RelativeLayout>();
		rightButtons = new ArrayList<TextView>();
	}

	private void setWidgets() {
		this.addView(leftLayout);
		leftLayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
		leftLayout.setOrientation(LinearLayout.HORIZONTAL);
		new XPxArea(context, leftLayout).set(XPxArea.LEFT, 0, XPxArea.WRAP, XPxArea.MATCH);

		this.addView(titleTextView);
		titleTextView.setText("未命名");
		titleTextView.setTextColor(XTopBarConfig.TITLE_COLOR);
		titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, (float) XTopBarConfig.TITLE_TEXT_SIZE);
		if (XTopBarConfig.TITLE_IN_CENTER) {
			new XPxArea(context, titleTextView).set(XPxArea.CENTER, XPxArea.CENTER, XPxArea.WRAP, XPxArea.WRAP);
		} else {
			new XPxArea(context, titleTextView).leftConnectRight(leftLayout).set(XTopBarConfig.SPACEING, XPxArea.CENTER, XPxArea.WRAP, XPxArea.WRAP);
		}

		this.addView(rightLayout);
		rightLayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
		rightLayout.setOrientation(LinearLayout.HORIZONTAL);
		new XPxArea(context, rightLayout).set(XPxArea.RIGHT, 0, XPxArea.WRAP, XPxArea.MATCH);
	}

	/**
	 * 设置标题
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		if (titleTextView != null) {
			titleTextView.setText(title);
		}
	}

	/**
	 * 在左边添加一个按钮
	 * 
	 * @param resId
	 *            按钮资源文件
	 * @param clickFlag
	 *            按钮点击的唯一标记符
	 */
	public void addLeftButton(int resId, double width, double height, int clickFlag) {
		RelativeLayout layout = new RelativeLayout(context);
		layout.setId(clickFlag);
		leftLayouts.add(layout);
		addListener(layout, clickFlag);

		TextView leftButton = new TextView(context);
		leftButton.setId(clickFlag);
		leftButton.setBackgroundResource(resId);
		addButtonToLeft(layout, leftButton, width, height);
		addListener(leftButton, clickFlag);

		leftLayout.addView(layout);
		if (leftLayouts.size() == 1) {
			layout.setPadding((int) XTopBarConfig.LEFT_RIGHT_PADDING, 0, 0, 0);
			new XPxArea(context, layout).set(0, 0, XPxArea.WRAP, XPxArea.MATCH);
		} else {
			new XPxArea(context, layout).set(XTopBarConfig.SPACEING, 0, XPxArea.WRAP, XPxArea.MATCH);
		}
	}

	/**
	 * 在左边添加一个按钮
	 * 
	 * @param resId
	 *            按钮资源文件
	 * @param name
	 *            按钮名字
	 * @param clickFlag
	 *            按钮点击的唯一标记符
	 */
	public void addLeftButton(int resId, String name, double width, double height, int clickFlag) {
		RelativeLayout layout = new RelativeLayout(context);
		layout.setId(clickFlag);
		leftLayouts.add(layout);
		addListener(layout, clickFlag);

		TextView leftButton = new TextView(context);
		leftButton.setId(clickFlag);
		leftButton.setText(name);
		leftButton.setBackgroundResource(resId);
		addButtonToLeft(layout, leftButton, width, height);
		addListener(leftButton, clickFlag);

		leftLayout.addView(layout);
		if (leftLayouts.size() == 1) {
			layout.setPadding((int) XTopBarConfig.LEFT_RIGHT_PADDING, 0, 0, 0);
			new XPxArea(context, layout).set(0, 0, XPxArea.WRAP, XPxArea.MATCH);
		} else {
			new XPxArea(context, layout).set(XTopBarConfig.SPACEING, 0, XPxArea.WRAP, XPxArea.MATCH);
		}
	}

	/**
	 * 在左边添加一个纯文本按钮
	 * 
	 * @param resId
	 *            纯文本的点击效果资源文件
	 * @param name
	 *            按钮名字
	 * @param height
	 *            高度
	 * @param clickFlag
	 *            按钮点击的唯一标记符
	 */
	public void addLeftTextButton(int resId, String name, double width, double height, int clickFlag) {
		RelativeLayout layout = new RelativeLayout(context);
		layout.setId(clickFlag);
		leftLayouts.add(layout);
		addListener(layout, clickFlag);

		TextView leftButton = new TextView(context);
		leftButton.setId(clickFlag);
		leftButton.setText(name);
		leftButton.setTextColor(context.getResources().getColorStateList(resId));
		addButtonToLeft(layout, leftButton, width, height);
		addListener(leftButton, clickFlag);

		leftLayout.addView(layout);
		if (leftLayouts.size() == 1) {
			layout.setPadding((int) XTopBarConfig.LEFT_RIGHT_PADDING, 0, 0, 0);
			new XPxArea(context, layout).set(0, 0, XPxArea.WRAP, XPxArea.MATCH);
		} else {
			new XPxArea(context, layout).set(XTopBarConfig.SPACEING, 0, XPxArea.WRAP, XPxArea.MATCH);
		}
	}

	/**
	 * 在右边添加一个按钮
	 * 
	 * @param resId
	 *            按钮资源文件
	 * @param clickFlag
	 *            按钮点击的唯一标记符
	 */
	public void addRightButton(int resId, double width, double height, int clickFlag) {
		RelativeLayout layout = new RelativeLayout(context);
		layout.setId(clickFlag);
		rightLayouts.add(layout);
		addListener(layout, clickFlag);

		TextView rightButton = new TextView(context);
		rightButton.setId(clickFlag);
		rightButton.setBackgroundResource(resId);
		addButtonToRight(layout, rightButton, width, height);
		addListener(rightButton, clickFlag);

		rightLayout.addView(layout);
		if (rightLayouts.size() == 1) {
			layout.setPadding(0, 0, (int) XTopBarConfig.LEFT_RIGHT_PADDING, 0);
			new XPxArea(context, layout).set(0, 0, XPxArea.WRAP, XPxArea.MATCH);
		} else {
			new XPxArea(context, layout).set(XTopBarConfig.SPACEING, 0, XPxArea.WRAP, XPxArea.MATCH);
		}
	}

	/**
	 * 在右边添加一个按钮
	 * 
	 * @param resId
	 *            按钮资源文件
	 * @param name
	 *            按钮名字
	 * @param clickFlag
	 *            按钮点击的唯一标记符
	 */
	public void addRightButton(int resId, String name, double width, double height, int clickFlag) {
		RelativeLayout layout = new RelativeLayout(context);
		layout.setId(clickFlag);
		rightLayouts.add(layout);
		addListener(layout, clickFlag);

		TextView rightButton = new TextView(context);
		rightButton.setId(clickFlag);
		rightButton.setBackgroundResource(resId);
		rightButton.setText(name);
		addButtonToRight(layout, rightButton, width, height);
		addListener(rightButton, clickFlag);

		rightLayout.addView(layout);
		if (rightLayouts.size() == 1) {
			layout.setPadding(0, 0, (int) XTopBarConfig.LEFT_RIGHT_PADDING, 0);
			new XPxArea(context, layout).set(0, 0, XPxArea.WRAP, XPxArea.MATCH);
		} else {
			new XPxArea(context, layout).set(XTopBarConfig.SPACEING, 0, XPxArea.WRAP, XPxArea.MATCH);
		}
	}

	/**
	 * 在右边添加一个纯文本按钮
	 * 
	 * @param resId
	 * @param name
	 * @param clickFlag
	 */
	public void addRightTextButton(int resId, String name, double width, double height, int clickFlag) {
		RelativeLayout layout = new RelativeLayout(context);
		layout.setId(clickFlag);
		rightLayouts.add(layout);
		addListener(layout, clickFlag);

		TextView rightButton = new TextView(context);
		rightButton.setId(clickFlag);
		rightButton.setTextColor(context.getResources().getColorStateList(resId));
		rightButton.setText(name);
		addButtonToRight(layout, rightButton, width, height);
		addListener(rightButton, clickFlag);

		rightLayout.addView(layout);
		if (rightLayouts.size() == 1) {
			layout.setPadding(0, 0, (int) XTopBarConfig.LEFT_RIGHT_PADDING, 0);
			new XPxArea(context, layout).set(0, 0, XPxArea.WRAP, XPxArea.MATCH);
		} else {
			new XPxArea(context, layout).set(XTopBarConfig.SPACEING, 0, XPxArea.WRAP, XPxArea.MATCH);
		}
	}

	/**
	 * 移除所有按钮
	 */
	public void removeAll() {
		removeLeftAll();
		removeRightAll();
	}

	/**
	 * 移除左边的所有按钮
	 */
	public void removeLeftAll() {
		leftLayout.removeAllViews();
	}

	/**
	 * 移除右边的所有按钮
	 */
	public void removeRightAll() {
		rightLayout.removeAllViews();
	}

	/**
	 * 移除指定clickFlag的按钮
	 * 
	 * @param clickFlag
	 */
	public void removeByClickFlag(int clickFlag) {
		for (int i = 0; i < leftLayouts.size(); i++) {
			if (leftLayouts.get(i).getId() == clickFlag) {
				leftLayout.removeView(leftLayouts.get(i));
			}
		}

		for (int i = 0; i < rightLayouts.size(); i++) {
			if (rightLayouts.get(i).getId() == clickFlag) {
				rightLayout.removeView(rightLayouts.get(i));
			}
		}
	}

	/**
	 * 隐藏所有按钮
	 */
	public void hideAll() {
		hideLeftAll();
		hideRightAll();
	}

	/**
	 * 隐藏左边的所有按钮
	 */
	public void hideLeftAll() {
		for (int i = 0; i < leftLayouts.size(); i++) {
			leftLayouts.get(i).setVisibility(View.GONE);
		}
	}

	/**
	 * 隐藏右边的所有按钮
	 */
	public void hideRightAll() {
		for (int i = 0; i < rightLayouts.size(); i++) {
			rightLayouts.get(i).setVisibility(View.GONE);
		}
	}

	/**
	 * 隐藏指定clickFlag的按钮
	 * 
	 * @param clickFlag
	 */
	public void hideByClickFlag(int clickFlag) {
		for (int i = 0; i < leftLayouts.size(); i++) {
			if (leftLayouts.get(i).getId() == clickFlag) {
				leftLayouts.get(i).setVisibility(View.GONE);
			}
		}

		for (int i = 0; i < rightLayouts.size(); i++) {
			if (rightLayouts.get(i).getId() == clickFlag) {
				rightLayouts.get(i).setVisibility(View.GONE);
			}
		}
	}

	/**
	 * 显示所有按钮
	 */
	public void showAll() {
		showLeftAll();
		showRightAll();
	}

	/**
	 * 显示左边的所有按钮
	 */
	public void showLeftAll() {
		for (int i = 0; i < leftLayouts.size(); i++) {
			leftLayouts.get(i).setVisibility(View.VISIBLE);
		}
	}

	/**
	 * 显示右边的所有按钮
	 */
	public void showRightAll() {
		for (int i = 0; i < rightLayouts.size(); i++) {
			rightLayouts.get(i).setVisibility(View.VISIBLE);
		}
	}

	/**
	 * 显示指定clickFlag的按钮
	 * 
	 * @param clickFlag
	 */
	public void showByClickFlag(int clickFlag) {
		for (int i = 0; i < leftLayouts.size(); i++) {
			if (leftLayouts.get(i).getId() == clickFlag) {
				leftLayouts.get(i).setVisibility(View.VISIBLE);
			}
		}

		for (int i = 0; i < rightLayouts.size(); i++) {
			if (rightLayouts.get(i).getId() == clickFlag) {
				rightLayouts.get(i).setVisibility(View.VISIBLE);
			}
		}
	}

	private void addButtonToLeft(RelativeLayout layout, TextView leftButton, double width, double height) {
		leftButton.setGravity(Gravity.CENTER);
		leftButton.setIncludeFontPadding(false);
		leftButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, (float) XTopBarConfig.BUTTON_TEXT_SIZE);
		leftButtons.add(leftButton);
		layout.addView(leftButton);

		new XPxArea(context, leftButton).set(0, XPxArea.CENTER, width, height);
	}

	private void addButtonToRight(RelativeLayout layout, TextView rightButton, double width, double height) {
		rightButton.setGravity(Gravity.CENTER);
		rightButton.setIncludeFontPadding(false);
		rightButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, (float) XTopBarConfig.BUTTON_TEXT_SIZE);
		rightButtons.add(rightButton);
		layout.addView(rightButton);

		new XPxArea(context, rightButton).set(0, XPxArea.CENTER, width, height);
	}

	private void addListener(View view, final int flag) {
		view.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (callBack != null) {
					callBack.onClick(flag);
				}
			}
		});
	}

	public void setCallBack(XTopBarCallBack callBack) {
		this.callBack = callBack;
	}

	public interface XTopBarCallBack {
		public void onClick(int flag);
	}
}
