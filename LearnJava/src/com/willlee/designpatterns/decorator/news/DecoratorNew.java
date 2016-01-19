package com.willlee.designpatterns.decorator.news;

import java.util.List;

public abstract class DecoratorNew extends ComponentNew {
	private ComponentNew componentNew;

	public DecoratorNew(ComponentNew componentNew) {
		this.componentNew = componentNew;
	}

    @Override
	public List<New> getListOfNews() {
		return this.componentNew.getListOfNews();
	}

}
