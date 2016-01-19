package com.willlee.designpatterns.proxy.fontprovider;

import java.lang.reflect.Proxy;



/**
 * 字体提供类的工厂
 * 
 * @author Administrator
 * 
 */
public abstract class ProviderFactory {
	
	public static FontProvider getFontProvider() {
		//return new FontProviderFromDisk();
		//return new LogFontProvider(new FontProviderFromDisk());
		Class<FontProvider> targetClass = FontProvider.class;
        return (FontProvider) Proxy.newProxyInstance(
            targetClass.getClassLoader(), 
            new Class[] {targetClass}, 
            new LogProviderHandler(new FontProviderFromDisk()));
	}

	public static ImageProvider getImageProvider() {
		Class<ImageProvider> targetClass = ImageProvider.class;
        return (ImageProvider) Proxy.newProxyInstance(
            targetClass.getClassLoader(), 
            new Class[] {targetClass}, 
            new LogProviderHandler(new ImageProviderFromDisk()));
	}
}
