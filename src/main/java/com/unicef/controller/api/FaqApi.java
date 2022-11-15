package com.unicef.controller.api;

import com.unicef.domain.Faq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/faq")
@RestController
public class FaqApi {

    @PostMapping("/abc")
    public ResponseEntity<?> abc(Faq faq) {

        log.info("{}", faq.toString());
        return ResponseEntity.ok(null);
    }
}
