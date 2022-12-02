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
    @RequestMapping(value = "/community/noticeMain/item")
    public String noticeItem(){
        return "community/notice_item";
    }
    @RequestMapping(value = "/community/faq/donate")
    public String donate(){
        return "community/faq_donate";
    }
    @RequestMapping(value = "/community/faq/childRights")
    public String childRights(){
        return "community/faq_childRights";
    }
    @RequestMapping(value = "/community/faq/activity")
    public String activity(){
        return "community/faq_activity";
    }
    @RequestMapping(value = "/community/faq/promotion")
    public String promotion(){
        return "community/faq_promotion";
    }
    @RequestMapping(value = "/community/faq/recruitment")
    public String recruitment(){
        return "community/faq_recruitment";
    }
    @RequestMapping(value = "/community/faq/other")
    public String other(){
        return "community/faq_other";
    }
}
