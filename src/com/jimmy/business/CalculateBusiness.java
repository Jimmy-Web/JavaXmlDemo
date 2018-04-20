package com.jimmy.business;

import java.util.List;

import com.jimmy.util.Dimen;

public class CalculateBusiness {

	private static final int xxhdpi = 480;
	private static final int xhdpi = 320;
	private static final int hdpi = 240;
	private static final int mdpi = 160;
	private static final int ldpi = 120;

	private int widthPixel;// 手机宽度的像素
	private int heightPixel;// 手机高度的像素
	private double diagonalPixel;// 手机对角线的像素
	private int pixelDensity;// 像素密度
	private int screenSize;//屏幕的尺寸

	public CalculateBusiness() {

	}

	public CalculateBusiness(int widthPixel, int heightPixel,int screenSize) {
		this.widthPixel = widthPixel;
		this.heightPixel = heightPixel;
		this.screenSize = screenSize;
		this.diagonalPixel = Math.sqrt(Math.pow(widthPixel, 2) + Math.pow(heightPixel, 2));
		this.pixelDensity = (int) (diagonalPixel/screenSize);
	}
	
	
	public List<Dimen> createDimenList() {
		int dimenItemNum = 1;
		if(widthPixel>heightPixel) {
			dimenItemNum = widthPixel;
		}else {
			dimenItemNum = heightPixel;
		}
		for(int i = 1; i<=dimenItemNum;i++) {
			
		}
		return null;
	}
	

}
