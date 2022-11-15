package com.unicef.service.donate;

import com.unicef.dto.donate.DonateAreaReqDto;
import org.springframework.stereotype.Service;

public interface DonateAreaService {
    public boolean donateArea(DonateAreaReqDto donateAreaReqDto) throws Exception;
}
