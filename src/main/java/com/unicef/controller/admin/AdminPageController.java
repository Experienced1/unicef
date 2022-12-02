package com.unicef.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {

    @RequestMapping(value = "/admin/userlist")
    public String adminUserlist(){
        return "admin/admin_userlist";
    }

    @RequestMapping(value = "/admin/onetoone")
    public String adminDonation(){
        return "admin/admin_onetoone";
    }

    @RequestMapping(value = "/admin/faq")
    public String adminFaq(){
        return "admin/admin_faq";
    }

    @RequestMapping(value = "/admin/faq/add")
    public String adminFaqAdd(){
        return "admin/admin_faq_add";
    }

    @RequestMapping(value = "/admin/faq/donate")
    public String donate(){
        return "admin/admin_faq_donate";
    }
    @RequestMapping(value = "/admin/faq/childRights")
    public String childRights(){
        return "admin/admin_faq_childRights";
    }
    @RequestMapping(value = "/admin/faq/activity")
    public String activity(){
        return "admin/admin_faq_activity";
    }
    @RequestMapping(value = "/admin/faq/promotion")
    public String promotion(){
        return "admin/admin_faq_promotion";
    }
    @RequestMapping(value = "/admin/faq/recruitment")
    public String recruitment(){
        return "admin/admin_faq_recruitment";
    }
    @RequestMapping(value = "/admin/faq/other")
    public String other(){
        return "admin/admin_faq_other";
    }


    @RequestMapping(value = "/admin/notice")
    public String adminNotice(){
        return "admin/admin_notice";
    }

    @RequestMapping(value = "/admin/notice/add")
    public String adminNoticeAdd(){
        return "admin/admin_notice_add";
    }
}
