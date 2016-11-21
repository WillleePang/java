package com.willlee.effectivejava.refactorconstructor;

public class NutritionFactsV3 {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	public static class Builder {
		// required parameters
		private final int servingSize;
		private final int servings;
		// optional parameters - initialized to default values
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;

		public Builder(int servingsSize, int servings) {
			this.servingSize = servingsSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			calories = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public NutritionFactsV3 build() {
			return new NutritionFactsV3(this);
		}
	}

	private NutritionFactsV3(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
	public static void main(String[] args) {
		NutritionFactsV3 cocaCola = new NutritionFactsV3.Builder(240, 8).calories(321).sodium(123).carbohydrate(1211).build();
	}
}
