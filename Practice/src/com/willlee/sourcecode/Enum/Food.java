package com.willlee.sourcecode.Enum;

//使用接口组织枚举 
public interface Food {
	enum Coffee implements Food {
		BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
	}

	enum Dessert implements Food {
		FRUIT, CAKE, GELATO
	}
}
