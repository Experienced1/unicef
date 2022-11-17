package com.unicef.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Onetoone {
    private String category;
    private String title;
    private String detail;

    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
