package javacorecourse.task_19;

/**
 * Created by Home on 3/27/2015.
 */

public class Adder {

    private int a, b;

    @Parameters(count = 2, type = Parameters.parametersTYPE.INT)
    public Adder(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }


    public String toString() {
        return String.valueOf(a + b);
    }
}
