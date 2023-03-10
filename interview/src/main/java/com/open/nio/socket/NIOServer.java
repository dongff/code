package com.open.nio.socket;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

//网络服务器端程序
public class NIOServer {
    public static void main(String[] args) throws Exception {
        //1. 得到一个ServerSocketChannel对象  老大
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2. 得到一个Selector对象   间谍
        Selector selector = Selector.open();
        //3. 绑定一个端口号
        serverSocketChannel.bind(new InetSocketAddress(9999));
        //4. 设置非阻塞方式
        serverSocketChannel.configureBlocking(false);
        //5. 把ServerSocketChannel对象注册给Selector对象
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6. 干活，服务端不能停
        while (true) {
            //6.1 监控客户端 ，selecto.select()方法返回的是客户端的通道数，如果为0，则说明没有客户端连接。
            if (selector.select(2000) == 0) {  //nio非阻塞式的优势
                System.out.println("Server:没有客户端搭理我，我就干点别的事");
                continue;
            }
            //6.2 得到SelectionKey,判断通道里的事件
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                //客户端先连接上，处理连接事件，然后客户端会向服务端发信息，再处理读取客户端数据事件。
                if (key.isAcceptable()) {  //客户端连接请求事件
                    System.out.println("OP_ACCEPT");
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    //注册通道 ,将通道交给selector选择器进行监控.第一个参数是选择器，
                    //第二个参数服务器要监控读事件，因为客户端发数据，服务端要读取，第三个参数，客户端传过来的数据要放在缓冲区
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (key.isReadable()) {  //读取客户端数据事件
                    //数据在通道中，先得到通道
                    SocketChannel channel = (SocketChannel) key.channel();
                    //取到一个缓冲区，nio读写数据都是基于缓冲区。
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    //从通道中将客户端发来的数据读到缓冲区
                    channel.read(buffer);
                    System.out.println("客户端发来数据：" + new String(buffer.array()));
                }
                // 6.3 手动从集合中移除当前key,防止重复处理
                keyIterator.remove();
            }
        }
    }
}
