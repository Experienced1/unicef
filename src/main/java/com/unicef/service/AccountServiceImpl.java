package com.unicef.service;

import com.unicef.domain.User;
import com.unicef.exception.CustomValidationException;
import com.unicef.repository.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public boolean checkDuplicateId(String userId) {

        User user = accountRepository.findUserByUserId(userId);
        if (user != null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("duplicateFlag", "이미 가입된 아이디 입니다");
            throw new CustomValidationException("DuplicateId Error", errorMap);
        }

        return true;
    }
}
