package com.unicef.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {

    @RequestMapping(value = "/mypage/myinfo")
    public String myInfo(){
        return "mypage/mypage_my_info";
    }

    @RequestMapping(value = "/mypage/drop")
    public String drop(){
        return "mypage/mypage_drop";
    }

    @RequestMapping(value = "/mypage/search")
    public String mypageSearch(){
        return "mypage/mypage_search";
    }

    @RequestMapping(value = "/mypage/supportinfo")
    public String supportInfo(){
        return "mypage/mypage_support_info";
    }

    @RequestMapping(value = "/mypage/myreceipt")
    public String myReceipt(){
        return "mypage/mypage_my_receipt";
    }

    @RequestMapping(value = "/mypage/onetoone")
    public String oneToOne(){
        return "mypage/mypage_onetoone";
    }

    @RequestMapping(value = "/mypage/onetoone/form")
    public String oneToOneForm(){
        return "mypage/mypage_onetoone_form";
    }
}
