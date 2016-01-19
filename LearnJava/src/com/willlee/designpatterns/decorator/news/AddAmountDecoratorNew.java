package com.willlee.designpatterns.decorator.news;

import java.util.List;

public class AddAmountDecoratorNew extends DecoratorNew{

	public AddAmountDecoratorNew(ComponentNew componentNew) {
		super(componentNew);
	}
	
	@Override
	public List<New> getListOfNews() {
		System.out.println("add Amount");
		return super.getListOfNews();
	}

}
