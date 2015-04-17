package javacorecourse.task_19;

/**
 * Created by Home on 4/11/2015.
 */
import javacorecourse.task_19.Parameters.parType;

public class Simple {
    private String first, second, third, fourth;

    @Parameters(parNames = {"first", "second", "third", "fourth"},
                parTypes = {parType.STRING, parType.STRING, parType.STRING, parType.STRING})
    public Simple(String first, String second, String third, String fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public String getResponse() {
        return first + " " + second+ " " + third + " " + fourth;
    }
}
