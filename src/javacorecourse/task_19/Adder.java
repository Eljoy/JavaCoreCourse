package javacorecourse.task_19;

/**
 * Created by Home on 3/27/2015.
 */

public class Adder {

    private int a, b;

    @TwoIntParameters()
    public Adder(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return String.valueOf(a + b);
    }
}
