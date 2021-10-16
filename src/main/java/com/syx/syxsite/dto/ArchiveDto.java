package com.syx.syxsite.dto;

import com.syx.syxsite.model.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/16 19:31
 * @version:v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveDto {
    private String date;
    private String count;
    private List<Content> articles; // 目前还没有使用过这个属性，没有的话就可以把这些优化掉
}
