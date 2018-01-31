package com.willlee.designpatterns.proxy.fontprovider;


/**
 * �������ṩ�������־���
 * 
 * @author Administrator
 * 
 */
public class LogFontProvider implements FontProvider , ImageProvider{
	private FontProvider fontProvider;
	private ImageProvider imageProvider;
		
	public LogFontProvider(FontProvider fontProvider) {
		this.fontProvider = fontProvider;
	}

	public void getFont(String name) {
		System.out.println("log font provider is working!");
		fontProvider.getFont(name);
	}

	public void getImage(String name) {
		System.out.println("log image provider is working!");
		imageProvider.getImage(name);
	}

}
