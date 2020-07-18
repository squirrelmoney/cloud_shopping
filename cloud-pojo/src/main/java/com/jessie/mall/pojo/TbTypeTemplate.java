package com.jessie.mall.pojo;

import com.jessie.mall.common.common.TypeTemplateResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbTypeTemplate {
    private Long id;

    private String name;

    private String specIds;

    private String brandIds;

    private String customAttributeItems;

//    private List<TypeTemplateResult> specIdsForType;
//
//    private List<TypeTemplateResult> brandIdsForType;
//
//    private Object[] customAttributeItemsForType;


}