package com.unicef.controller.donate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DonateController {

    @RequestMapping(value = "/donate")
    public String donate(){
        return "donate";
    }
}
