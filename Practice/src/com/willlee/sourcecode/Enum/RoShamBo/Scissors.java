package com.willlee.sourcecode.Enum.RoShamBo;

public class Scissors implements Item {  
    public Outcome compete(Item it) {  
        return it.eval(this);  
    }  
  
    public Outcome eval(Paper p) {  
        return Outcome.LOSE;  
    }  
  
    public Outcome eval(Scissors s) {  
        return Outcome.DRAW;  
    }  
  
    public Outcome eval(Rock r) {  
        return Outcome.WIN;  
    }  
  
    public String toString() {  
        return "Scissors";  
    }  
}  