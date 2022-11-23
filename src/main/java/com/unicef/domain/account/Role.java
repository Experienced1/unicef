package com.unicef.domain.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    private int role_id;
    private String role;
    private String role_name;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}