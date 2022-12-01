package com.unicef.domain.donate;

import com.unicef.domain.account.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Donate {
    private int donate_id;
    private int user_id;
    private String donate_area;
    private String donate_type;
    private int donate_amount;
    private int donate_area_id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
