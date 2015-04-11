package javacorecourse.task_19;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Home on 4/11/2015.
 */
public class WebServerParser {

    public static Map<String, String> parseGET(String url) {
        Map<String, String> parseResult = new HashMap<>();
        String[] tempBuf;

        url  = url.substring(url.indexOf("?") + 1, (url.indexOf("HTTP") - 1));
        if(!url.contains("=")) return null;
        tempBuf = url.split("&");

        for (String s : tempBuf) {
            parseResult.put(s.split("=")[0], s.split(("="))[1]);
        }
        System.out.println(parseResult);
        return parseResult;
    }

    public static String extract(String str, String start, String end)
    {
        int s = str.indexOf("\n\n", 0), e;
        if(s < 0) s = str.indexOf("\r\n\r\n", 0);
        if(s > 0) str = str.substring(0, s);
        s = str.indexOf(start, 0)+start.length();
        if(s < start.length()) return null;
        e = str.indexOf(end, s);
        if(e < 0) e = str.length();
        return (str.substring(s, e)).trim();
    }

    public static String getPath(String header)
    {

        String URI = extract(header, "GET ", " "), path;
        if(URI == null) URI = extract(header, "POST ", " ");
        if(URI == null) return null;

        path = URI.toLowerCase();
        if(path.indexOf("http://", 0) == 0)
        {
            URI = URI.substring(7);
            URI = URI.substring(URI.indexOf("/", 0));
        }
        else if(path.indexOf("/", 0) == 0)
            URI = URI.substring(1);

        int i = URI.indexOf("?");
        if(i > 0) URI = URI.substring(0, i);
        i = URI.indexOf("#");
        if(i > 0) URI = URI.substring(0, i);


        path = "." + File.separator;
        char a;
        for(i = 0; i < URI.length(); i++)
        {
            a = URI.charAt(i);
            if(a == '/')
                path = path + File.separator;
            else
                path = path + a;
        }

        return path;
    }

}
