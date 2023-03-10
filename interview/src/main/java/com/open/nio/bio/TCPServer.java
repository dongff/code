package com.open.nio.bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//BIO服务端程序
public class TCPServer {

    public static void main(String[] args) throws Exception{
        //1.创建一个ServerSocket对象
        ServerSocket ss=new ServerSocket(9999);

        while(true){
            //2.监听客户端
            System.out.println("来吧");
            Socket s=ss.accept();//阻塞
            System.out.println("有客户上门");
            //3.从连接中取出输入流来接收客户端发来的消息
           InputStream is= s.getInputStream();
           byte[] b=new byte[10];
           is.read(b);
           String clientIP=s.getInetAddress().getHostAddress(); //得到客户端的IP
            System.out.println(clientIP+"说"+new String(b).trim());
            //4.服务端从连接中取出流出流回应客户端
            OutputStream os=s.getOutputStream();
            os.write("没钱".getBytes());
            //5.关闭
            s.close();
        }

    }
}
