package com.huawei.dgy.netty.chapter02;

/**
 * 实现NIO客户端
 *
 * @auther: dgy
 * @date: 2017/4/21
 * @version: 1.0
 */
public class TimeClient03 {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }

        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }
}
