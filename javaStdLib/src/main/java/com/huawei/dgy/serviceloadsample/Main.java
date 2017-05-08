package com.huawei.dgy.serviceloadsample;

import java.util.ServiceLoader;

/**
 * 测试{@link java.util.ServiceLoader ServiceLoad}类
 *
 * <p>
 *     ServiceLoader类的使用步骤：
 *     1. 编写一个接口（标准）
 *     2. 编写接口的实现类
 *     3. 在/src/META-INF/services下新建一个文件，文件名为接口的包名+接口名
 *     4. 把实现类的全名写在该文件中，一个实现类占一行
 * </p>
 *
 *
 * @auther: dgy
 * @date: 2017/5/4
 * @version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<MessageService> serviceLoader = ServiceLoader.load(MessageService.class);
        for(MessageService service : serviceLoader) {
            System.out.println(service.getMessage());
        }
    }

}
