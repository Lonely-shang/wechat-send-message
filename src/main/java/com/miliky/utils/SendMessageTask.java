package com.miliky.utils;

import com.miliky.service.SendMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 *
 * @Author: Miliky
 * @Date: 2022/9/4 9:23 PM
 * @Description: [爱意随风起，风止意难平。]
 */

@Component
public class SendMessageTask {

    @Resource
    SendMessage sendMessage;

//    @Scheduled(cron="0/5 * *  * * ? ")
//    @Scheduled(cron = "0 30 7 * * ? *")
//    private void configureTasks() {
//        sendMessage.sendMessageByTemplate();
//    }
}
