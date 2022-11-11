package com.unicef.controller.faq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FaqController {

    @RequestMapping(value = "/community/faq")
    public String faq(){
        return "community/faq";
    }

    @RequestMapping(value = "/community/notice")
    public String notice(){
        return "community/notice";
    }

}
