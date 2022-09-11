package com.miliky.wechatsendmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan("com.miliky.*")
@SpringBootApplication
@EnableScheduling
public class WechatSendMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatSendMessageApplication.class, args);
    }

}
