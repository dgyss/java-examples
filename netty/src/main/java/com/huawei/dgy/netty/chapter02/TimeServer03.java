package com.huawei.dgy.netty.chapter02;

/**
 * NIO创建的TimeServer
 *
 * @auther: dgy
 * @date: 2017/4/20
 * @version: 1.0
 */
public class TimeServer03 {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {

            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }

        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        Thread t = new Thread(timeServer, "NIO-MultiplexerTimeServer-001");

        /**
         * The Java Virtual Machine exits when the only
         * threads running are all daemon threads.
         *
         * default: thread is not daemon.
         * */
        t.start();
    }
}
