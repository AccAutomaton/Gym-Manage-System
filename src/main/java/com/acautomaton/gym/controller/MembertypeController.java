package com.acautomaton.gym.controller;

import com.acautomaton.gym.entity.MemberType;
import com.acautomaton.gym.service.MemberTypeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ktype")
public class MembertypeController {
    private final MemberTypeDaoImpl membertypeDaoImpl;

    @Autowired
    public MembertypeController(MemberTypeDaoImpl membertypeDaoImpl) {
        this.membertypeDaoImpl = membertypeDaoImpl;
    }

    @RequestMapping("/jin5")
    public String jin5() {
        return "WEB-INF/jsp/Membertype";
    }

    @RequestMapping("/query")
    @ResponseBody
    public List<MemberType> query() {
        return membertypeDaoImpl.cha();
    }

    @RequestMapping("/queryq")
    @ResponseBody
    public Map<String, Object> query(String typeName, int pageSize, int pageNumber) {
        return getMemberTypeMap(typeName, pageSize, pageNumber, membertypeDaoImpl);
    }

    static Map<String, Object> getMemberTypeMap(String typeName, int pageSize, int pageNumber, MemberTypeDaoImpl membertypeDaoImpl) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("typeName", typeName);
        map1.put("qi", (pageNumber - 1) * pageSize);
        map1.put("shi", pageSize);
        return membertypeDaoImpl.query(map1);
    }

    @RequestMapping("/query2")
    @ResponseBody
    public MemberType query2(int xztype) {
        return membertypeDaoImpl.cha2(xztype);
    }
}
