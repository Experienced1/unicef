package com.unicef.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }

    @RequestMapping(value = "/involve/individual/pledge")
    public String individualPledge(){
        return "individual/pledge";
    }

    @RequestMapping(value = "/involve/individual/oneOff")
    public String individualOneOff(){
        return "individual/oneoff";
    }

    @RequestMapping(value = "/involve/individual/transparency")
    public String individualTransparency(){
        return "individual/transparency";
    }
}
