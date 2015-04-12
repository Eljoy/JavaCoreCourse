package test.java;

import javacorecourse.task_19.WebServerParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IGazdaliev on 02.04.2015.
 */
public class Task_19_Test {

    @Test
    public void parseGETTest() {
        final String REQUEST = "GET /class:Adder.toString?a=6&b=8 HTTP/1.1\n" +
                "Host: localhost:8080\n" +
                "Connection: keep-alive\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36\n" +
                "Referer: http://localhost:8080/class:Adder.toString\n" +
                "Accept-Encoding: gzip, deflate, sdch\n" +
                "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4";
        Map<String, String> expectedParseResult = new HashMap<>();
        expectedParseResult.put("a", "6");
        expectedParseResult.put("b", "8");
        Assert.assertEquals(expectedParseResult, WebServerParser.parseGET(REQUEST));
    }
    @Test
    public void  getPathTest() {
       final String REQUEST = "GET /class:Adder.toString?a=6&b=8 HTTP/1.1\n" +
               "Host: localhost:8080\n" +
               "Connection: keep-alive\n" +
               "Cache-Control: max-age=0\n" +
               "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
               "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36\n" +
               "Referer: http://localhost:8080/class:Adder.toString\n" +
               "Accept-Encoding: gzip, deflate, sdch\n" +
               "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4";
        final String expectedPath = ".\\class:Adder.toString";
        Assert.assertEquals(expectedPath, WebServerParser.getPath(REQUEST));
    }

}
