package com.willlee.designpatterns.decorator.news;

public class Client {
	public static void main(String[] args) {
		ComponentNew xml = new XMLNews();
		DecoratorNew addamount = new AddAmountDecoratorNew(xml);
		DecoratorNew addRss = new AddRssDecoratorNew(addamount);
		addRss.getListOfNews();
	}
}
