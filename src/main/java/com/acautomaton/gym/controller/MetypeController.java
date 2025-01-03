package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.MemberttypeDao;
import com.acautomaton.gym.entity.Membertype;
import com.acautomaton.gym.service.MembertypeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Optional;

import static com.acautomaton.gym.controller.MembertypeController.getMemberTypeMap;

@Controller
@RequestMapping("/metype")
public class MetypeController {
    private final MembertypeDaoImpl membertypeDaoImpl;
    private final MemberttypeDao memberttypeDao;

    @Autowired
    public MetypeController(MembertypeDaoImpl membertypeDaoImpl, MemberttypeDao memberttypeDao) {
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
    public void save(Membertype membertype) {

        memberttypeDao.save(membertype);
    }

    @RequestMapping("/cha")
    @ResponseBody
    public Optional<Membertype> one(long typeId) {
        return memberttypeDao.findById(typeId);
    }

    @RequestMapping("/upd")
    @ResponseBody
    public void upd(Membertype membertype) {
        memberttypeDao.save(membertype);
    }
}
