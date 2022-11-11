package com.unicef.controller.unicefIntroduction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnicefPageController {

    @RequestMapping(value = "/unicef/activity")
    public String unicefActivity(){
        return "unicef/activity";
    }

    @RequestMapping(value = "/unicef/patronageStory")
    public String patronageStory(){
        return "unicef/patronage_story";
    }

    @RequestMapping(value = "/unicef/introduction")
    public String unicefIntroduction(){
        return "unicef/unicef_introduction";
    }
}
