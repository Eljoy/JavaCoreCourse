package javacorecourse.task_19;


/**
 * Created by Home on 13.03.2015.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

class SimpleWEBServerAnnotation extends Thread
{
    private Socket s;
    private   InputStream is;
    private  OutputStream os;
    private static boolean globalFlag = false;

    protected void htmlFormsGenerator(RequestTypes requestType) throws Exception{

        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.0 200 OK\n");
        response.append("Content-Type: text/html\r\n");
        response.append("\r\n");
        response.append("<html><form method='"+requestType.toString()+"'>\n");
        response.append("<input type='text' name='a'></br><input type='text' name='b'></br><input type='submit' ></form></html>");
        os.write(response.toString().getBytes());
        os.flush();
        os.close();
        globalFlag = true;

    }

    protected Map<String, String> parseGET(String url) {
        Map<String, String> parseResult = new HashMap<>();
        String[] tempBuf;

        url  = url.substring(url.indexOf("?") + 1, (url.indexOf("HTTP") - 1));
        if(!url.contains("=")) return null;
        tempBuf = url.split("&");

        for (String s : tempBuf) {
            parseResult.put(s.split("=")[0], s.split(("="))[1]);
        }

        return parseResult;
    }

    protected void showClassWithParametersPage(String invocPath, Map<String, String> parameters) throws Exception{
        String outMessage = null, response = null, className, methodName;
        try {
            className = invocPath.substring(0, invocPath.indexOf("."));
            methodName = invocPath.substring(invocPath.indexOf(".") + 1);

            Class aClass = Class.forName("javacorecourse.task_19." + className);

            Object[] args = new Object[] {Integer.parseInt(parameters.get("a")), Integer.parseInt(parameters.get("b"))};
            System.out.println(args.toString());
            Object iClass = aClass.getConstructor(new Class[]{Integer.class, Integer.class}).newInstance(args);
            System.out.println("32");

            Method method = aClass.getDeclaredMethod(methodName);
            outMessage = (String)method.invoke(iClass);
            writeSimpleResponse(outMessage);

            return;
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
            outMessage = "Class: " + invocPath +", you are trying to load, does not exists";
            writeSimpleResponse(outMessage);
            System.err.println("Some issues while method invocation has been occurred");
        }

    }

    protected void showClassPage(String invocPath) throws Exception {

        String outMessage = null, response = null, className, methodName;
        try {
            className = invocPath.substring(0, invocPath.indexOf("."));
            methodName = invocPath.substring(invocPath.indexOf(".") + 1);

            Class aClass = Class.forName("javacorecourse.task_19." + className);
            Constructor[] constructors = aClass.getConstructors();

            for (Constructor constructor : constructors) {
               if(constructor.isAnnotationPresent(TwoIntParameters.class)) {

                    htmlFormsGenerator(RequestTypes.GET);
                    return;
                }
            }
            Object iClass = aClass.newInstance();
            Method method = aClass.getDeclaredMethod(methodName);
            outMessage = (String)method.invoke(iClass);

            writeSimpleResponse(outMessage);
        }
        catch (NoSuchMethodException e) {
            outMessage = "Class: " + invocPath +", you are trying to load, does not exists";
            writeSimpleResponse(outMessage);
            System.err.println("Some issues while method invocation has been occurred");
        }

    }

    public static void main(String args[])
    {
        try
        {

            ServerSocket server = new ServerSocket(8080);
            System.out.println("server has started");

            while(true)
            {
                new SimpleWEBServerAnnotation(server.accept());
            }
        }
        catch(Exception e)
        {System.out.println("init error: " + e);}
    }

    public SimpleWEBServerAnnotation(Socket s)
    {
        this.s = s;
        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    public void run()
    {
        try
        {
            is = s.getInputStream();
            os = s.getOutputStream();

            byte buf[] = new byte[64*1024];
            int r = is.read(buf);

            Map<String, String> localMap = new HashMap<>();

            String request = new String(buf, 0, r);


            String path = getPath(request);


            if(path == null)
            {
                System.err.println("Path is null");
                String response = "HTTP/1.1 400 Bad Request\n";
                DateFormat df = DateFormat.getTimeInstance();
                df.setTimeZone(TimeZone.getTimeZone("GMT"));
                response = response + "Date: " + df.format(new Date()) + "\n";
                response = response
                        + "Connection: close\n"
                        + "Server: SimpleWEBServer\n"
                        + "Pragma: no-cache\n\n";

                os.write(response.getBytes());
                s.close();

                return;
            }

            if(globalFlag) {
                localMap = parseGET(request);
                globalFlag = false;
                showClassWithParametersPage(path.substring(path.indexOf(":") + 1), localMap);

            }

            if(path.contains(":")) {
                if(path.substring(path.indexOf("\\") + 1, path.indexOf(":")).equals("class"));
                showClassPage(path.substring(path.indexOf(":") + 1));
                return;
            }


            File f = new File(path);
            boolean flag = !f.exists();
            if(!flag) if(f.isDirectory())
            {
                if(path.lastIndexOf(""+File.separator) == path.length()-1)
                    path = path + "index.html";
                else
                    path = path + File.separator + "index.html";
                f = new File(path);
                flag = !f.exists();
            }



            if(flag)
            {

                String response = "HTTP/1.1 404 Not Found\n";

                DateFormat df = DateFormat.getTimeInstance();
                df.setTimeZone(TimeZone.getTimeZone("GMT"));
                response = response + "Date: " + df.format(new Date()) + "\n";

                response = response
                        + "Content-Type: text/plain\n"
                        + "Connection: close\n"
                        + "Server: SimpleWEBServer\n"
                        + "Pragma: no-cache\n\n";

                response = response + "File " + path + " not found!";

                os.write(response.getBytes());
                s.close();

                return;
            }

            String mime = null;
            r = path.lastIndexOf(".");

            if(r > 0)
            {
                String ext = path.substring(r + 1);

                switch (ext) {
                    case "html": mime = "text/html";
                        break;
                    case "htm": mime = "text/html";
                        break;
                    case "gif": mime = "image/gif";
                        break;
                    case "jpg": mime = "image/jpeg";
                        break;
                    case "jpeg": mime = "image/jpeg";
                        break;
                    case "bmp": mime = "image/x-xbitmap";
                        break;

                    default: mime = "text/html";
                }

            }

            String response = "HTTP/1.1 200 OK\n";

            DateFormat df = DateFormat.getTimeInstance();
            df.setTimeZone(TimeZone.getTimeZone("GMT"));
            response = response + "Last-Modified: " + df.format(new Date(f.lastModified())) + "\n";
            response = response + "Content-Length: " + f.length() + "\n";
            response = response + "Content-Type: " + mime + "\n";
            response = response
                    + "Connection: close\n"
                    + "Server: SimpleWEBServer\n\n";

            os.write(response.getBytes());
            FileInputStream fis = new FileInputStream(path);
            r = 1;
            while(r > 0)
            {
                r = fis.read(buf);
                if(r > 0) os.write(buf, 0, r);
            }
            fis.close();
            s.close();
        }
        catch(Exception e)
        {e.printStackTrace();}
    }


    protected String getPath(String header)
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

    protected void writeSimpleResponse(String message) throws Exception{
        String response = "HTTP/1.1 \n";
        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        response = response + "Date: " + df.format(new Date()) + "\n";

        response = response
                + "Content-Type: text/plain\n"
                + "Connection: close\n"
                + "Server: SimpleWEBServer\n"
                + "Pragma: no-cache\n\n";

        response = response +  message;

        os.write(response.getBytes());
        s.close();

    }




    protected String extract(String str, String start, String end)
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




}