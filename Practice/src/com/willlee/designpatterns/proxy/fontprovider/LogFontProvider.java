package com.willlee.designpatterns.proxy.fontprovider;


/**
 * 给字体提供类添加日志输出
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

	@Override
	public void getFont(String name) {
		System.out.println("log font provider is working!");
		fontProvider.getFont(name);
	}

	@Override
	public void getImage(String name) {
		System.out.println("log image provider is working!");
		imageProvider.getImage(name);
	}

}
