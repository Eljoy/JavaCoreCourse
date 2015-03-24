package javacorecourse.task_17;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Home on 16.12.2014.
 */
public class MyWebServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            Socket s = ss.accept();

            System.err.println("Client accepted");
            new Thread(new SocketProcessor(s)).start();
        }
    }

    private static class SocketProcessor implements Runnable {
        private InputStream in;
        private OutputStream out;
        private Socket s;

        private SocketProcessor(Socket  s) throws Exception{
            this.s = s;
            out = s.getOutputStream();
            in = s.getInputStream();

        }


        @Override
        public void run() {
            try {
                readInputHeaders();
                writeResponse("<html><body><h1>Hello World!</h1></body></html>");
            } catch (Throwable t) {

            } finally {
                try {
                    s.close();
                } catch (Throwable t) {

                }
            }
            System.err.println("Client processing finished");

        }
        private void writeResponse (String s) throws Exception {
            String response = "HTTP/1.1 200 OK\n" +
                    "Server: MyServer\n" +
                    "Content-Type: text/html\n" +
                    "Content-Length: " + s.length() + "\n" +
                    "Connection: close\r\n\r\n";
            String result = response + s;
            out.write(result.getBytes());
            out.flush();
    }
        private void readInputHeaders() throws Throwable {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            while(true) {
                String s = br.readLine();
                System.out.println(s);
                if(s == null || s.trim().length() == 0) {
                    break;
                }
                System.out.println(getPath(s));
            }
        }

        protected String getPath(String header)
        {
            // ищем URI, указанный в HTTP запросе
            // URI ищется только для методов POST и GET, иначе возвращается null
            String URI = extract(header, "GET ", " "), path;
            System.out.println(URI);
            if(URI == null) URI = extract(header, "POST ", " ");
            if(URI == null) return null;

            // если URI записан вместе с именем протокола
            // то удаляем протокол и имя хоста
            path = URI.toLowerCase();
            if(path.indexOf("http://", 0) == 0)
            {
                URI = URI.substring(7);
                URI = URI.substring(URI.indexOf("/", 0));
            }
            else if(path.indexOf("/", 0) == 0)
                URI = URI.substring(1); // если URI начинается с символа /, удаляем его

            // отсекаем из URI часть запроса, идущего после символов ? и #
            int i = URI.indexOf("?");
            if(i > 0) URI = URI.substring(0, i);
            i = URI.indexOf("#");
            if(i > 0) URI = URI.substring(0, i);

            // конвертируем URI в путь до документов
            // предполагается, что документы лежат там же, где и сервер
            // иначе ниже нужно переопределить path
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


        // "вырезает" из строки str часть, находящуюся между строками start и end
        // если строки end нет, то берётся строка после start
        // если кусок не найден, возвращается null
        // для поиска берётся строка до "\n\n" или "\r\n\r\n", если таковые присутствуют
        public String extract(String str, String start, String end)
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


}
