package com.jessie.mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TbSpecification {
    private Long id;

    private String specName;

    private List<TbSpecificationOption> specificationOptionList;

    public TbSpecification(Long id, String specName) {
        this.id = id;
        this.specName = specName;
    }
}