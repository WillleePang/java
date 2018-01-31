package com.willlee.designpatterns.proxy.fontprovider;

public class ImageProviderFromDisk implements ImageProvider {

	public void getImage(String name) {
		System.out.println(" image "+name+" is providing from disk");
	}

}
