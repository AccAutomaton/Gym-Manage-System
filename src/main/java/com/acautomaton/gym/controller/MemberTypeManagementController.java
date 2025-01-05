package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.MemberTypeDao;
import com.acautomaton.gym.entity.MemberType;
import com.acautomaton.gym.service.MemberTypeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Optional;

import static com.acautomaton.gym.controller.MemberTypeController.getMemberTypeMap;

@Controller
@RequestMapping("/metype")
public class MemberTypeManagementController {
    private final MemberTypeDaoImpl membertypeDaoImpl;
    private final MemberTypeDao memberttypeDao;

    @Autowired
    public MemberTypeManagementController(MemberTypeDaoImpl membertypeDaoImpl, MemberTypeDao memberttypeDao) {
        this.membertypeDaoImpl = membertypeDaoImpl;
        this.memberttypeDao = memberttypeDao;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> del(long typeId, String typeName, int pageSize, int pageNumber) {
        memberttypeDao.deleteById(typeId);
        return getMemberTypeMap(typeName, pageSize, pageNumber, membertypeDaoImpl);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void save(MemberType membertype) {

        memberttypeDao.save(membertype);
    }

    @RequestMapping("/cha")
    @ResponseBody
    public Optional<MemberType> one(long typeId) {
        return memberttypeDao.findById(typeId);
    }

    @RequestMapping("/upd")
    @ResponseBody
    public void upd(MemberType membertype) {
        memberttypeDao.save(membertype);
    }
}
