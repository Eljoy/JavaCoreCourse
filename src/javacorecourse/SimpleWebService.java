package javacorecourse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by Home on 14.05.2015.
 */
@WebService(serviceName = "SimpleWebService")
public class SimpleWebService {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + "!";
    }

    public static void main(String[] args) {

    }
}
