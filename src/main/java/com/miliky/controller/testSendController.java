package com.miliky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/send")
    public String send () {
        return "aaaa";
    }
}
