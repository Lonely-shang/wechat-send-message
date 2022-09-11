package com.miliky.controller;

import com.alibaba.fastjson.JSONArray;
import com.miliky.entry.Limited;
import com.miliky.service.SendMessage;
import com.miliky.utils.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @Author: Miliky
 * @Date: 2022/9/4 9:14 PM
 * @Description: [爱意随风起，风止意难平。]
 */

@RestController
@RequestMapping("/a")
public class testSendController {

    @Resource
    private SendMessage sendMessage;

    @GetMapping("/send")
    public void send () {
//        List<Limited> forbiddenNumber = Utils.getForbiddenNumber();
//
//        for (Limited limited : forbiddenNumber) {
//            System.out.println(limited.toString());
//        }


        sendMessage.sendMessageByTemplate();
    }
}
