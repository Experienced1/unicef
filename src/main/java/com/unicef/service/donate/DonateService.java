package com.unicef.service.donate;

import com.unicef.dto.donate.DonateReqDto;
import com.unicef.dto.donate.DonateRespDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DonateService {
    public boolean donate(DonateReqDto donateReqDto) throws Exception;

    public List<DonateRespDto> getDonateList(int userId) throws Exception;

    boolean deleteDonate(int id) throws Exception;
}
