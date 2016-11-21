package com.willlee.effectivejava.refactorconstructor;
//代码冗杂，不易调试
public class NutritionFactsV1 {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	public NutritionFactsV1(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}

	public NutritionFactsV1(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}

	public NutritionFactsV1(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}

	public NutritionFactsV1(int servingSize, int servings, int calories, int fat,
			int sodium) {
		this(servingSize, servings, calories, fat, sodium, 0);
	}

	public NutritionFactsV1(int servingSize, int servings, int calories, int fat,
			int sodium, int carbohydrate) {
		super();
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}

	public static void main(String[] args) {
		NutritionFactsV1 cocaCola = new NutritionFactsV1(240, 8, 100, 0, 35, 27);
	}
}
