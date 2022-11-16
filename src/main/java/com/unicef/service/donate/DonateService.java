package com.unicef.service.donate;

import com.unicef.dto.donate.DonateAreaReqDto;
import com.unicef.dto.donate.DonateReqDto;

public interface DonateService {
    public boolean donate(DonateReqDto donateReqDto) throws Exception;
}
