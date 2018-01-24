package com.willlee.designpatterns.decorator.news;

import java.util.List;

public class AddRssDecoratorNew extends DecoratorNew {

	public AddRssDecoratorNew(ComponentNew componentNew) {
		super(componentNew);
	}

	@Override
	public List<New> getListOfNews() {
		System.out.println("add RSS");
		return super.getListOfNews();
	}
}
