package com.willlee.designpatterns.proxy.fontprovider;

public class FontProviderFromDisk implements FontProvider {

	public void getFont(String name) {
		System.out.println(" font "+name+" is providing from disk");
	}

}
