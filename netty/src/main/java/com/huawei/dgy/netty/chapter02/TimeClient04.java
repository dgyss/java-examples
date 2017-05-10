package com.huawei.dgy.netty.chapter02;

/**
 * 异步client
 *
 * @auther: dgy
 * @date: 2017/5/9
 * @version: 1.0
 */
public class TimeClient04 {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }

        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-001").start();
    }
}
