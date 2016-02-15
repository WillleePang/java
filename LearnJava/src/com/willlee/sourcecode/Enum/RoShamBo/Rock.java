package com.willlee.sourcecode.Enum.RoShamBo;

public class Rock implements Item {
	public Outcome compete(Item it) {
		return it.eval(this);
	}

	public Outcome eval(Paper p) {
		return Outcome.WIN;
	}

	public Outcome eval(Scissors s) {
		return Outcome.LOSE;
	}

	public Outcome eval(Rock r) {
		return Outcome.DRAW;
	}

	public String toString() {
		return "Rock";
	}
}
