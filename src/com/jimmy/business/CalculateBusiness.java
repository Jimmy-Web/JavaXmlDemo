package com.jimmy.business;

import java.util.List;

import com.jimmy.util.Dimen;

public class CalculateBusiness {

	private static final int xxhdpi = 480;
	private static final int xhdpi = 320;
	private static final int hdpi = 240;
	private static final int mdpi = 160;
	private static final int ldpi = 120;

	private int widthPixel;// �ֻ���ȵ�����
	private int heightPixel;// �ֻ��߶ȵ�����
	private double diagonalPixel;// �ֻ��Խ��ߵ�����
	private int pixelDensity;// �����ܶ�
	private int screenSize;//��Ļ�ĳߴ�

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
