package com.jessie.mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbSpecificationOption {
    private Long id;

    private String optionName;

    private Long specId;

    private Integer orders;


}