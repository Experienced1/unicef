package com.unicef.domain.notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttachedFile {
    private int file_id;
    private int notice_id;
    private String file_origin_name;
    private String file_temp_name;
}
