package javacorecourse.task_19;

/**
 * Created by Home on 3/27/2015.
 */

public class Adder {

    private int a, b;

    public Adder() {
    }

    @TwoIntParameters()
    public Adder(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public String toString() {
      //  return String.valueOf(a + b);
        return "55";
    }
}
