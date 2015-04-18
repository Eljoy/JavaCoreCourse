package javacorecourse.task_19;

/**
 * Created by Home on 3/27/2015.
 */
import javacorecourse.task_19.Parameters.parType;
import org.apache.log4j.Logger;

public class Adder {
    protected Logger log = Logger.getLogger(Adder.class);
    private int a, b;

    @Parameters(parNames = {"a", "b"}, parTypes = {parType.INT, parType.INT })
    public Adder(Integer a, Integer b) {
        this.a = a;
        this.b = b;
        log.debug("To Adder class has been transferred next parameters: a = " + a + " b = " + b);
    }


    public String toString()
    {   log.debug("Result of invocation Adder.toString(): " + String.valueOf(a + b));
        return String.valueOf(a + b);
    }
}
