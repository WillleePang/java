package com.willlee.sourcecode.Enum.RoShamBo;

public interface Item {
	Outcome compete(Item it);
	Outcome eval(Paper p);
	Outcome eval(Scissors s);
	Outcome eval(Rock r);
}
