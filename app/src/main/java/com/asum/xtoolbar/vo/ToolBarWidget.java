package com.asum.xtoolbar.vo;

public class ToolBarWidget {
	// 1代表左边只含图片按钮，2代表左边包含图片与文字的按钮，3代表左边文字按钮
	// 4代表只含图片的功能按钮，5代表包含图片与文字的功能按钮，6代表文字功能按钮
	private int type;

	private String name;
	private int backgroundResoured;
	private int textResoured;
	private int textColor;
	private double textSize;

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getBackgroundResoured() {
		return backgroundResoured;
	}

	public int getTextResoured() {
		return textResoured;
	}

	public int getTextColor() {
		return textColor;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBackgroundResoured(int backgroundResoured) {
		this.backgroundResoured = backgroundResoured;
	}

	public void setTextResoured(int textResoured) {
		this.textResoured = textResoured;
	}

	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}

	public double getTextSize() {
		return textSize;
	}

	public void setTextSize(double textSize) {
		this.textSize = textSize;
	}
}
