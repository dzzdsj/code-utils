package com.dzzdsj.demo.codeutils.FastJsonDemo.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s = "{\n" +
                "    \"msg\": \"Succeed\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"catalogName\": \"住宅\",\n" +
                "            \"catalogId\": \"01\",\n" +
                "            \"dispOrder\": 10,\n" +
                "            \"parentId\": \"00000000000000000000000000000000\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"别墅\",\n" +
                "            \"catalogId\": \"02\",\n" +
                "            \"dispOrder\": 20,\n" +
                "            \"parentId\": \"00000000000000000000000000000000\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"厂房\",\n" +
                "            \"catalogId\": \"03\",\n" +
                "            \"dispOrder\": 30,\n" +
                "            \"parentId\": \"00000000000000000000000000000000\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"公共建筑\",\n" +
                "            \"catalogId\": \"04\",\n" +
                "            \"dispOrder\": 40,\n" +
                "            \"parentId\": \"00000000000000000000000000000000\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"其他存在重大安全隐患建筑\",\n" +
                "            \"catalogId\": \"05\",\n" +
                "            \"dispOrder\": 50,\n" +
                "            \"parentId\": \"00000000000000000000000000000000\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"自建房\",\n" +
                "            \"catalogId\": \"0101\",\n" +
                "            \"dispOrder\": 10,\n" +
                "            \"parentId\": \"01\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"成套房\",\n" +
                "            \"catalogId\": \"0102\",\n" +
                "            \"dispOrder\": 20,\n" +
                "            \"parentId\": \"01\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"公寓楼\",\n" +
                "            \"catalogId\": \"0103\",\n" +
                "            \"dispOrder\": 30,\n" +
                "            \"parentId\": \"01\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"宿舍楼\",\n" +
                "            \"catalogId\": \"0104\",\n" +
                "            \"dispOrder\": 40,\n" +
                "            \"parentId\": \"01\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"改建的群租房\",\n" +
                "            \"catalogId\": \"0105\",\n" +
                "            \"dispOrder\": 50,\n" +
                "            \"parentId\": \"01\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"独栋\",\n" +
                "            \"catalogId\": \"0201\",\n" +
                "            \"dispOrder\": 10,\n" +
                "            \"parentId\": \"02\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"联排\",\n" +
                "            \"catalogId\": \"0202\",\n" +
                "            \"dispOrder\": 20,\n" +
                "            \"parentId\": \"02\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"双拼\",\n" +
                "            \"catalogId\": \"0203\",\n" +
                "            \"dispOrder\": 30,\n" +
                "            \"parentId\": \"02\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"叠拼\",\n" +
                "            \"catalogId\": \"0204\",\n" +
                "            \"dispOrder\": 40,\n" +
                "            \"parentId\": \"02\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"生产场所\",\n" +
                "            \"catalogId\": \"0301\",\n" +
                "            \"dispOrder\": 10,\n" +
                "            \"parentId\": \"03\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"经营场所\",\n" +
                "            \"catalogId\": \"0302\",\n" +
                "            \"dispOrder\": 20,\n" +
                "            \"parentId\": \"03\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"办公场所\",\n" +
                "            \"catalogId\": \"0303\",\n" +
                "            \"dispOrder\": 30,\n" +
                "            \"parentId\": \"03\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"物流仓储场所\",\n" +
                "            \"catalogId\": \"0304\",\n" +
                "            \"dispOrder\": 40,\n" +
                "            \"parentId\": \"03\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"机关企事业单位用房\",\n" +
                "            \"catalogId\": \"0401\",\n" +
                "            \"dispOrder\": 10,\n" +
                "            \"parentId\": \"04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"娱乐场所\",\n" +
                "            \"catalogId\": \"0402\",\n" +
                "            \"dispOrder\": 20,\n" +
                "            \"parentId\": \"04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"商业场所\",\n" +
                "            \"catalogId\": \"0403\",\n" +
                "            \"dispOrder\": 30,\n" +
                "            \"parentId\": \"04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"文化旅游场所\",\n" +
                "            \"catalogId\": \"0404\",\n" +
                "            \"dispOrder\": 40,\n" +
                "            \"parentId\": \"04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"交通运输场所\",\n" +
                "            \"catalogId\": \"0405\",\n" +
                "            \"dispOrder\": 50,\n" +
                "            \"parentId\": \"04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"酒店、宾馆、招待所\",\n" +
                "            \"catalogId\": \"0406\",\n" +
                "            \"dispOrder\": 60,\n" +
                "            \"parentId\": \"04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"餐馆、五小店\",\n" +
                "            \"catalogId\": \"0407\",\n" +
                "            \"dispOrder\": 70,\n" +
                "            \"parentId\": \"04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"大中小学校、幼儿园、培训机构\",\n" +
                "            \"catalogId\": \"0408\",\n" +
                "            \"dispOrder\": 80,\n" +
                "            \"parentId\": \"04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"医疗卫生场所\",\n" +
                "            \"catalogId\": \"0409\",\n" +
                "            \"dispOrder\": 90,\n" +
                "            \"parentId\": \"04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"养老、托老机构场所\",\n" +
                "            \"catalogId\": \"0410\",\n" +
                "            \"dispOrder\": 100,\n" +
                "            \"parentId\": \"04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"catalogName\": \"民间信仰场所\",\n" +
                "            \"catalogId\": \"0411\",\n" +
                "            \"dispOrder\": 110,\n" +
                "            \"parentId\": \"04\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"totalNum\": null,\n" +
                "    \"endRows\": null,\n" +
                "    \"retcode\": \"0\",\n" +
                "    \"startRows\": null\n" +
                "}";
        JSONObject resp = JSON.parseObject(s);
        List<HouseCategory> houseCategoryList = JSON.parseObject(resp.getString("data"),new TypeReference<List<HouseCategory>>(){});

        List<HouseCategoryVo> rootList = new ArrayList<>();
        for(HouseCategory houseCategory:houseCategoryList){
            if(houseCategory.getParentId().equals("00000000000000000000000000000000")){
                HouseCategoryVo houseCategoryVo = new HouseCategoryVo();
                houseCategoryVo.setHouseCategory(houseCategory);
                rootList.add(houseCategoryVo);
            }
        }

        for(HouseCategoryVo houseCategoryVo:rootList){
            List<HouseCategoryVo> houseCategoryVoList = new ArrayList<>();
            for(HouseCategory houseCategory:houseCategoryList){
                if(isChild(houseCategoryVo.getHouseCategory(),houseCategory)){
                    HouseCategoryVo houseCategoryVo1 = new HouseCategoryVo();
                    houseCategoryVo1.setHouseCategory(houseCategory);
                    houseCategoryVoList.add(houseCategoryVo1);
                }
            }
            houseCategoryVo.setChildren(houseCategoryVoList);
        }
        System.out.println(rootList);


        System.out.println(resp);
    }

    public static boolean isChild(HouseCategory parent, HouseCategory child){
        if(parent.getCatalogId().equals(child.getParentId())){
            return true;
        }
        return false;
    }
}
