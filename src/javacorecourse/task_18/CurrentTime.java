package javacorecourse.task_18;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Home on 3/18/2015.
 */
public class CurrentTime {



    public static String getPage(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();


        return dateFormat.format(calendar.getTime());
    }
}
