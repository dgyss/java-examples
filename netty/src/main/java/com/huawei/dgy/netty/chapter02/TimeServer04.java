package com.huawei.dgy.netty.chapter02;

import java.io.IOException;

/**
 * AIO服务端
 *
 * @auther: dgy
 * @date: 2017/5/3
 * @version: 1.0
 */
public class TimeServer04 {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {

            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }

        }

        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
