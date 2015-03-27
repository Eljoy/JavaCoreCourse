package javacorecourse.task_19;

/**
 * Created by Home on 3/27/2015.
 */
public enum  RequestTypes {
    GET("GET"), POST("POST");

    private final String name;

    RequestTypes(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}
