package com.unicef.controller.donate;

import com.unicef.dto.donate.DonateRespDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DonateController {
    @RequestMapping(value = "/donate")
    public String donate(){
        return "donate";
    }

    @RequestMapping(value = "/mypage/supportinfo/mylist/receipt")
    public String myListReceipt(){
        return "donate_receipt";
    }

}
