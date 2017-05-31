
    package edu.hm.authorization;

import com.sun.deploy.net.HttpRequest;
import org.junit.Assert;
import org.junit.Test;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.*;

/**
 * Created by MatHe on 29.05.2017.
 */
public class TestTest
{
    /*
    @Test
    public void runner() throws IOException {

        String request = "http://localhost:8082/shareit/media/books/";
        InetAddress inetAdd = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAdd, 8082);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String req = "POST /shareit/media/books/isbn?token=jtdoerlprslgbezr HTTP/1.1\n" +
                "Host: localhost:8082\n" +
                "Content-Type: application/JSON\n\n" +
                "{\n" +
                "\t\"title\":\"title\",\n" +
                "\t\"author\":\"author\",\n" +
                "\t\"isbn\":\"isbn\"\n" +
                "}";

        DataInputStream dIn = new DataInputStream(in);
        DataOutputStream dOut = new DataOutputStream(out);

        dOut.write(req.getBytes(), 0, req.length());
        dOut.flush();
        boolean asdf = true;
        while (asdf) {
            System.out.print((char)dIn.read());
        }





    }


    @Test
    public void newUserTest() throws Exception {



        String request = "https://matthiastestapp.herokuapp.com/authorization/auth/signup";

        InetAddress inetAdd = InetAddress.getByName("matthiastestapp.herokuapp.com");
        Socket socket = new Socket(inetAdd, 80);
        String content = "{\n" +
                "\t\"userName\":\"name\",\n" +
                "\t\"password\":\"password\",\n" +
                "}\n";
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String req = "POST /authorization/auth/signup HTTP/1.1\n" +
                "Host: matthiastestapp.herokuapp.com\n" +
                "Content-Type: application/JSON\n" +
                "{\n" +
                "\t\"userName\":\"name\",\n" +
                "\t\"password\":\"password\",\n" +
                "}\n";


        DataInputStream dIn = new DataInputStream(in);
        DataOutputStream dOut = new DataOutputStream(out);

        dOut.write(req.getBytes(), 0, req.length());
        dOut.flush();
        Thread.sleep(10000);
        String firstLine = dIn.readLine();
        Assert.assertEquals("HTTP/1.1 200 OK",firstLine);
        System.out.println(firstLine);
        boolean asdf = true;
        dIn.available();
        while (dIn.available()>0) {
            System.out.println(dIn.readLine());
        }

        socket.close();
    }

    @Test
    public void UserLoginTest() throws Exception{
        String request = "http://localhost:8082/authorization/auth/login";
        InetAddress inetAdd = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAdd, 8082);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String req = "POST /authorization/auth/login HTTP/1.1\n" +
                "Host: localhost:8082\n" +
                "Content-Type: application/JSON\n\n" +
                "{\n" +
                "\t\"userName\":\"name\",\n" +
                "\t\"password\":\"password\",\n" +
                "}";

        DataInputStream dIn = new DataInputStream(in);
        DataOutputStream dOut = new DataOutputStream(out);

        dOut.write(req.getBytes(), 0, req.length());
        dOut.flush();
        boolean asdf = true;
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        while (dIn.available()>0) {
            System.out.print((char)dIn.read());
        }
        socket.close();
    }

    @Test
    public void createBook() throws Exception{
        String request = "http://localhost:8082/authorization/auth/login";
        InetAddress inetAdd = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAdd, 8082);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String token = "";
        String req = "POST /shareit/media/books?token="+token+" HTTP/1.1\n" +
                "Host: localhost:8082\n" +
                "Content-Type: application/JSON\n\n" +
                "{\n" +
                "\t\"title\":\"title\",\n" +
                "\t\"author\":\"author\",\n" +
                "\t\"isbn\":\"isbn\"\n" +
                "}";

        DataInputStream dIn = new DataInputStream(in);
        DataOutputStream dOut = new DataOutputStream(out);

        dOut.write(req.getBytes(), 0, req.length());
        dOut.flush();
        boolean asdf = true;
        while (dIn.available()>0) {
            System.out.print((char)dIn.read());
        }
    }
*/


}
