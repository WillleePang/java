package com.willlee.designpatterns.decorator.news;

import java.util.ArrayList;
import java.util.List;

public class DBNews extends ComponentNew{

	@Override
	public List<New> getListOfNews() {
		 List<New> list = new ArrayList<New>();
         //从数据库中取得数据填充到_list 中
         System.out.println("从数据库中取得数据填充到list 中");
         return list;
	}

}
