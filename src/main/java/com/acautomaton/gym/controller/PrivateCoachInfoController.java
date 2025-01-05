package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.CoachDao;
import com.acautomaton.gym.dao.MemberDao;
import com.acautomaton.gym.dao.PrivateCoachInfoDao;
import com.acautomaton.gym.dao.SubjectDao;
import com.acautomaton.gym.entity.PrivateCoachInfo;
import com.acautomaton.gym.service.PrivateCoachInfoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/privateinfo")
public class PrivateCoachInfoController {
    private final CoachDao coachDao;
    private final SubjectDao subjectDao;
    private final MemberDao menberDao;
    private final PrivateCoachInfoDao privateCoachInfoDao;
    private final PrivateCoachInfoDaoImpl privateCoachInfoDaoImpl;

    @Autowired
    public PrivateCoachInfoController(CoachDao coachDao, SubjectDao subjectDao, MemberDao menberDao,
                                      PrivateCoachInfoDao privateCoachInfoDao,
                                      PrivateCoachInfoDaoImpl privateCoachInfoDaoImpl) {
        this.coachDao = coachDao;
        this.subjectDao = subjectDao;
        this.menberDao = menberDao;
        this.privateCoachInfoDao = privateCoachInfoDao;
        this.privateCoachInfoDaoImpl = privateCoachInfoDaoImpl;
    }

    @RequestMapping("/jin3")
    public String jin3() {
        return "WEB-INF/jsp/PrivateCoach";
    }

    @RequestMapping("/ddaa")
    @ResponseBody
    public List<PrivateCoachInfo> query() {
        return privateCoachInfoDao.findAll();
    }

    @ModelAttribute("a")
    public Model cha(Model model) {
        model.addAttribute("coach", coachDao.findAll());
        model.addAttribute("subject", subjectDao.findAll());
        model.addAttribute("menber", menberDao.findAll());
        return model;
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query2(Model model, Integer coachid, Integer subjectid, Integer memberid, int pageSize, int pageNumber) {
        Map<String, Object> map1 = new HashMap<>();
        return getPrivateCoachMap(coachid, subjectid, memberid, pageSize, pageNumber, map1);
    }

    private Map<String, Object> getPrivateCoachMap(Integer coachid, Integer subjectid, Integer memberid, int pageSize, int pageNumber, Map<String, Object> map1) {
        map1.put("coachid", coachid);
        map1.put("subjectid", subjectid);
        map1.put("memberid", memberid);
        map1.put("qi", (pageNumber - 1) * pageSize);
        map1.put("shi", pageSize);
        return privateCoachInfoDaoImpl.query(map1);
    }

    @RequestMapping("/query2")
    @ResponseBody
    public List<PrivateCoachInfo> query3(long pid) {
        List<PrivateCoachInfo> list = new ArrayList<>();
        list.add(privateCoachInfoDao.findById(pid).get());
        return list;
    }

    @RequestMapping("/cha")
    @ResponseBody
    public Optional<PrivateCoachInfo> one(long id) {
        return privateCoachInfoDao.findById(id);
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> del(long id, Integer coachid, Integer subjectid, Integer memberid, int pageSize, int pageNumber) {
        privateCoachInfoDao.deleteById(id);
        Map<String, Object> map1 = new HashMap<>();
        return getPrivateCoachMap(coachid, subjectid, memberid, pageSize, pageNumber, map1);
    }

    @RequestMapping("/upd")
    @ResponseBody
    public void upd(PrivateCoachInfo privateCoachInfo) {
        privateCoachInfoDaoImpl.update(privateCoachInfo);
    }

    @RequestMapping("/count")
    @ResponseBody
    public Long count(Integer memid) {
        privateCoachInfoDaoImpl.count(memid);
        return privateCoachInfoDaoImpl.count(memid);
    }

    @RequestMapping("/byid")
    @ResponseBody
    public List<PrivateCoachInfo> queryid(Long memberid) {
        return privateCoachInfoDaoImpl.ByMemberid(memberid);
    }
}
