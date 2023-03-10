package com.open.nio.bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

//BIO客户端程序
public class TCPClient {

    public static void main(String[] args) throws Exception{
        while(true){
            //1.创建Socket对象
            Socket s=new Socket("127.0.0.1",9999);
            //2.从连接中取出输出流并发送消息
            OutputStream os=s.getOutputStream();
            System.out.println("请输入内容");
            Scanner sc=new Scanner(System.in);
            String msg=sc.nextLine();
            os.write(msg.getBytes());
            //3.从连接中取出输入并接收服务端返回的信息
            InputStream is= s.getInputStream(); //阻塞
            byte[] b=new byte[10];
            is.read(b);
            System.out.println("老大说:"+new String(b).trim());
            //4.关闭
            s.close();
        }
    }
}
