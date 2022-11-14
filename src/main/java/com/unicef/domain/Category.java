package com.unicef.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    private int category_id;
    private String category_list;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
