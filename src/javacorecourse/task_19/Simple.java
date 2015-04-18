package javacorecourse.task_19;

/**
 * Created by Home on 4/11/2015.
 */
import javacorecourse.task_19.Parameters.parType;
import org.apache.log4j.Logger;

public class Simple {
    protected Logger log = Logger.getLogger(Simple.class);

    private String first, second, third, fourth;

    @Parameters(parNames = {"first", "second", "third", "fourth"},
                parTypes = {parType.STRING, parType.STRING, parType.STRING, parType.STRING})
    public Simple(String first, String second, String third, String fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        log.debug("To class Simple has been transferred parameters: first = " + first +
                " second = " + second + " third = " + third + " fourth = " + fourth);
    }

    public String getResponse() {
        log.debug("Result of invocation Simple.getResponse(): " + first + " " + second + " " + third + " " + fourth);
        return first + " " + second+ " " + third + " " + fourth;
    }
}
