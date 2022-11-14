package com.unicef.controller.noticeFaq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeFaqController {

    @RequestMapping(value = "/community/faq")
    public String faq(){
        return "community/faq";
    }

    @RequestMapping(value = "/community/noticeMain")
    public String notice(){
        return "community/noticeMain";
    }
    @RequestMapping(value = "/community/noticeMain/item1")
    public String noticeItem(){
        return "community/notice_item1";
    }


}
