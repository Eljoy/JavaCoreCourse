package javacorecourse.task_19;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Home on 3/18/2015.
 */
public class CurrentTime {
    private static Logger log = Logger.getLogger(CurrentTime.class);
    public static String getPage(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        log.debug(" CurrentTime.getPage has been invoked. Result of invocation: " + dateFormat.format(calendar.getTime()));
        return dateFormat.format(calendar.getTime());
    }
}
