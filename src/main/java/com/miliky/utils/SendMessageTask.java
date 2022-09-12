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
    @Scheduled(cron = "0 30 7 * * ?")
    private void configureTasks() {
        sendMessage.sendMessageByTemplate("oOyZn6-ktWyFdUQnG_hMSLp1rLtE", "MS_8tMihef-6XBIS6IFnD4vKQmo1CHIa_uN6_EX3JqA");
        sendMessage.sendForbiddenNumberMessageByTemplate("oOyZn69j-qeL_FO1YehWd6lkQguY", "kmvjwoiGzSy1knITnBXRuAXGWzyoaGBMLA7m6urJVFo");
    }
}
