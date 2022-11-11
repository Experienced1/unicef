package com.unicef.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcoountController {

    @RequestMapping(value = "/account/join")
    public String accountJoin(){
        return "account/join";
    }

    @RequestMapping(value = "/account/join/form")
    public String accountJoinForm(){
        return "/account/join_form";
    }

    @RequestMapping(value = "/account/login")
    public String login(){
        return "/account/login";
    }
}
