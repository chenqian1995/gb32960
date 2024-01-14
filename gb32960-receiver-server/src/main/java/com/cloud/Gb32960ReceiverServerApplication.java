package com.cloud;

import com.cloud.server.NettyServer;
import io.netty.channel.ChannelFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@Slf4j
@SpringBootApplication
public class Gb32960ReceiverServerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Gb32960ReceiverServerApplication.class, args);
        log.info("GB32960 receiver server start success!");
    }

    @Resource
    private NettyServer nettyServer;

    @Override
    public void run(String... args) throws Exception {
// 开启服务
        ChannelFuture future = nettyServer.start("localhost", 7070);
        // 在JVM销毁前关闭服务
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                nettyServer.close();
            }
        });
        future.channel().closeFuture().sync();
    }
}
