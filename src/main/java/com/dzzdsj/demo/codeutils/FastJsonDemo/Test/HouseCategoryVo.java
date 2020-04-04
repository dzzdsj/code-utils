package com.dzzdsj.demo.codeutils.FastJsonDemo.Test;

import lombok.Data;

import java.util.List;

@Data
public class HouseCategoryVo {
    private HouseCategory houseCategory;
    private List<HouseCategoryVo> children;
}
