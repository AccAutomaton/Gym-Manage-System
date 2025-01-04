package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.MemberDao;
import com.acautomaton.gym.dao.RechargeDao;
import com.acautomaton.gym.entity.Recharge;
import com.acautomaton.gym.entity.Member;
import com.acautomaton.gym.entity.Membertype;
import com.acautomaton.gym.service.MenberDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/menber")
public class MemberController {
    private final RechargeDao chongzhiDao;
    private final MemberDao menberDao;
    private final MenberDaoImpl menberDaoiImpl;

    @Autowired
    public MemberController(RechargeDao chongzhiDao, MemberDao menberDao, MenberDaoImpl menberDaoImpl) {
        this.chongzhiDao = chongzhiDao;
        this.menberDao = menberDao;
        this.menberDaoiImpl = menberDaoImpl;
    }

    @RequestMapping("/jin2")
    public String jin2() {
        return "WEB-INF/jsp/HYMemberDaoQi";
    }

    @RequestMapping("/jin3")
    public String jin3() {
        return "WEB-INF/jsp/HYMemberChongZhi";
    }

    @RequestMapping("/jin11")
    public String jin11() {
        return "WEB-INF/jsp/HYMemberyeChongZhi";
    }

    @RequestMapping("/jin")
    public String jin() {
        return "WEB-INF/jsp/HYMember";
    }

    @RequestMapping("/jin4")
    public String jin4() {
        return "WEB-INF/jsp/privatecoachinfo";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query(int ktype, String hyname, int pageSize, int pageNumber) {
        return menberDaoiImpl.query(getTypeMap(ktype, hyname, pageSize, pageNumber));
    }

    private Map<String, Object> getTypeMap(int ktype, String hyname, int pageSize, int pageNumber) {
        Map<String, Object> map = new HashMap<>();
        map.put("hyname", hyname);
        map.put("ktype", ktype);
        map.put("qi", (pageNumber - 1) * pageSize);
        map.put("shi", pageSize);
        return map;
    }

    @RequestMapping("/query2")
    @ResponseBody
    public Map<String, Object> query2(int ktype, String hyname, int pageSize, int pageNumber) {
        return menberDaoiImpl.query2(getTypeMap(ktype, hyname, pageSize, pageNumber));
    }

    @RequestMapping("/cha")
    @ResponseBody
    public Member query2(int id) {

        return menberDaoiImpl.cha(id);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> del(int memid) {
        menberDaoiImpl.del(memid);
        return query(0, "", 5, 1);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insert(Member member) {
        menberDaoiImpl.insert(member);
        return query(0, "", 5, 1);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> update(Member member) {
        menberDaoiImpl.update(member);
        return query(0, "", 5, 1);
    }

    @RequestMapping("/ins")
    @ResponseBody
    public Map<String, Object> insert(Recharge chongzhi, String daoqi) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        java.sql.Timestamp dat = java.sql.Timestamp.valueOf(df.format(new Date()));

        chongzhi.setDate(dat);
        chongzhi.setCzStatic(2L);
        chongzhiDao.save(chongzhi);
        Membertype membertype = new Membertype();
        membertype.setTypeId(chongzhi.getMembertype().getTypeId());

        Member member = menberDao.findById(chongzhi.getMember().getMemberId()).get();
        member.setMemberId(chongzhi.getMember().getMemberId());
        member.setMemberStatic(1L);
        member.setMembertypes(membertype);

        java.sql.Date date = java.sql.Date.valueOf(daoqi);

        member.setMemberxufei(date);
        menberDao.save(member);

        return query(0, null, 5, 1);
    }
}
