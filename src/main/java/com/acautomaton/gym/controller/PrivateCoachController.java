package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.CoachDao;
import com.acautomaton.gym.dao.MemberDao;
import com.acautomaton.gym.dao.PrivateCoachInfoDao;
import com.acautomaton.gym.dao.SubjectDao;
import com.acautomaton.gym.entity.Member;
import com.acautomaton.gym.entity.PrivateCoachInfo;
import com.acautomaton.gym.entity.Subject;
import com.acautomaton.gym.service.CoachDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/private")
public class PrivateCoachController {
    private final CoachDao coachDao;
    private final CoachDaoImpl coachDaoImpl;
    private final SubjectDao subjectDao;
    private final MemberDao menberDao;
    private final PrivateCoachInfoDao privateCoachInfoDao;

    @Autowired
    public PrivateCoachController(CoachDao coachDao, CoachDaoImpl coachDaoImpl,
                                  SubjectDao subjectDao, MemberDao menberDao,
                                  PrivateCoachInfoDao privateCoachInfoDao) {
        this.coachDao = coachDao;
        this.coachDaoImpl = coachDaoImpl;
        this.subjectDao = subjectDao;
        this.menberDao = menberDao;
        this.privateCoachInfoDao = privateCoachInfoDao;
    }

    @RequestMapping("/jin3")
    public String jin3() {
        return "WEB-INF/jsp/PrivateCoach";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query(String coachname, int pageSize, int pageNumber) {
        return getCoachMap(coachname, pageSize, pageNumber, coachDaoImpl);
    }

    static Map<String, Object> getCoachMap(String coachname, int pageSize, int pageNumber, CoachDaoImpl coachDaoImpl) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("coachname", coachname);
        map1.put("qi", (pageNumber - 1) * pageSize);
        map1.put("shi", pageSize);
        return coachDaoImpl.query(map1);
    }

    @RequestMapping("/query2")
    @ResponseBody
    public List<Member> query2() {
        return menberDao.findAll();
    }

    @RequestMapping("/topcoach")
    @ResponseBody
    public Map<String, Object> topcoach() {
        Map<String, Object> map = new HashMap<>();
        map.put("coach", coachDao.findAll());
        map.put("subject", subjectDao.findAll());
        map.put("menber", menberDao.findAll());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public void save(PrivateCoachInfo privateCoachInfo) {
        privateCoachInfoDao.save(privateCoachInfo);
    }

    @RequestMapping("/cha")
    @ResponseBody
    public Optional<Subject> one(long id) {
        return subjectDao.findById(id);
    }

    @RequestMapping("/cha2")
    @ResponseBody
    public Optional<Member> two(long id) {
        return menberDao.findById(id);
    }
}
