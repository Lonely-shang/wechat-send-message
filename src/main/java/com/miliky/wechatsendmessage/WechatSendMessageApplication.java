package com.miliky.wechatsendmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.miliky.*")
@SpringBootApplication
public class WechatSendMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatSendMessageApplication.class, args);
    }

}
