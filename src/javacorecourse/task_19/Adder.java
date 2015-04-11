package javacorecourse.task_19;

/**
 * Created by Home on 3/27/2015.
 */
import javacorecourse.task_19.Parameters.parType;
public class Adder {

    private int a, b;

    @Parameters(parNames = {"a", "b"}, parTypes = {parType.INT, parType.INT })
    public Adder(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }


    public String toString() {
        return String.valueOf(a + b);
    }
}
