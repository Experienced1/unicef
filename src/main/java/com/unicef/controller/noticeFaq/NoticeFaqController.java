package com.unicef.controller.noticeFaq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class NoticeFaqController {

    @GetMapping("/faq")
    public String faq(){
        return "/community/faq";
    }

    @GetMapping("/noticeMain")
    public String notice(){
        return "/community/noticeMain";
    }
    @GetMapping("/noticeMain/item1")
    public String noticeItem(){
        return "/community/notice_item1";
    }


}
