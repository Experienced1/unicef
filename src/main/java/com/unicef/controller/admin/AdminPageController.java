package com.unicef.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {

    @RequestMapping(value = "/admin/userlist")
    public String adminUserlist(){
        return "admin/admin_userlist";
    }

    @RequestMapping(value = "/admin/donation")
    public String adminDonation(){
        return "admin/admin_donation";
    }

    @RequestMapping(value = "/admin/faq")
    public String adminFaq(){
        return "admin/admin_faq";
    }

    @RequestMapping(value = "/admin/notice")
    public String adminNotice(){
        return "admin/admin_notice";
    }
}
