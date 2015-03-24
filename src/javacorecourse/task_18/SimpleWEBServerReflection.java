package javacorecourse.task_18;

/**
 * Created by Home on 13.03.2015.
 */
import java.io.*;
import java.lang.reflect.Method;
import java.net.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

class SimpleWEBServerReflection extends Thread
{
    private Socket s;
    private   InputStream is;
    private  OutputStream os;

    public static void main(String args[])
    {
             try
        {

            ServerSocket server = new ServerSocket(8080);
            System.out.println("server is started");

            while(true)
            {
                new SimpleWEBServerReflection(server.accept());
            }
        }
        catch(Exception e)
        {System.out.println("init error: " + e);}
    }

    public SimpleWEBServerReflection(Socket s)
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


            String request = new String(buf, 0, r);

            String path = getPath(request);

            if(path == null)
            {
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

            r = path.lastIndexOf(".");
            if(path.substring(r + 1).equals("getpage")) {
                showClassPage(path.substring(2, r));
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

    protected void showClassPage(String className) throws Exception {

        String outMessage = null, response = null;
        try {
        Class temp = Class.forName("javacorecourse.task_18." + className);

            Method method = temp.getMethod("getPage");
            outMessage = (String)method.invoke(new CurrentTime());
            response = "HTTP/1.1 200 OK\n";
        }
        catch (Exception e) {
            outMessage = "Class" + className +" you are trying to load, does not exists";
            System.err.println("Some issues while method invocation has been occurred");
            response = "HTTP/1.1 404 Not Found\n";
        }

        response = response + "Content-Length: " + outMessage.length() + "\n";
        response = response + "Content-Type: text/html\n";
        response = response
                + "Connection: close\n"
                + "Server: SimpleWEBServer" +"\r\n\r\n"+ "<p>" + outMessage + "</p>";
        os.write(response.getBytes());
        os.close();

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