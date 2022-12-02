package com.unicef.controller.user;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String login(Model model, @RequestParam @Nullable String error){
        if(error != null){
            model.addAttribute("error", error.equals("auth")
                    ? "아이디 또는 비밀번호가 잘못되었습니다" : "");
        }
        return "/account/login";
    }
}
