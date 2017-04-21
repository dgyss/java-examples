package com.huawei.dgy.netty.chapter02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 采用线程池和任务队列实现伪异步的I/O通信框架
 *
 * <p>
 *     当有新的客户端接入时，将客户端的Socket封装成一个Task（该任务实现
 *     {@link java.lang.Runnable}接口）投递到后端的线程池中进行处理，JDK的线程
 *     池维护一个消息队列和N个活跃线程，对消息队列中的任务进行。由于线程池可以设置
 *     消息队列的大小和最大线程数，因此，它的资源占用是可控的，无论多少个客户端并发
 *     访问，都不会导致资源的耗尽和宕机。
 * </p>
 *
 * <p>
 *     为了解决同步阻塞I/O面临的一个链路需要一个线程处理的问题，后来有人对它的线程
 *     模型进行了优化——后端通过一个线程池来处理多个客户端的请求接入，形成客户端个数
 *     M；线程池最大线程数N的比例关系，其中M可以远远大于N。通过线程池可以灵活地调配
 *     线程资源，设置线程的最大值，防止由于海量并发接入导致线程耗尽。
 * </p>
 *
 * <p>
 *     疑问：
 *     1. 服务器如果默认是保持连接的，那么保持连接的时间多长？
 *     2. 是否可以使得服务器所有连接均处于保持连接状态但是没有数据传送？
 * </p>
 *
 * @auther: dgy
 * @date: 2017/4/20
 * @version: 1.0
 */
public class TimeServer02 {
    public static void main(String[] args) throws IOException{
        int port = 8080;
        if (args != null && args.length > 0) {

            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }

        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port: " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
