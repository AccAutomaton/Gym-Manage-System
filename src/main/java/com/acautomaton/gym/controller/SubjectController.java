package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.PrivateCoachInfoDao;
import com.acautomaton.gym.dao.SubjectDao;
import com.acautomaton.gym.entity.PrivateCoachInfo;
import com.acautomaton.gym.entity.Subject;
import com.acautomaton.gym.service.SubjectDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectDaoImpl subjectDaoImpl;
    private final SubjectDao subjectDao;
    private final PrivateCoachInfoDao privateCoachInfoDao;

    @Autowired
    public SubjectController(SubjectDaoImpl subjectDaoImpl, SubjectDao subjectDao,
                             PrivateCoachInfoDao privateCoachInfoDao) {
        this.subjectDaoImpl = subjectDaoImpl;
        this.subjectDao = subjectDao;
        this.privateCoachInfoDao = privateCoachInfoDao;
    }

    @RequestMapping("/jin7")
    public String jin7() {
        return "WEB-INF/jsp/subject";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query(String subname, int pageSize, int pageNumber) {
        return getSubjectMap(subname, pageSize, pageNumber);
    }

    private Map<String, Object> getSubjectMap(String subname, int pageSize, int pageNumber) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("subname", subname);
        map1.put("qi", (pageNumber - 1) * pageSize);
        map1.put("shi", pageSize);
        return subjectDaoImpl.query(map1);
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> del(long subId, String subname, int pageSize, int pageNumber) {
        List<PrivateCoachInfo> privateCoachInfoList = privateCoachInfoDao.queryBySubjectIdNative(subId);
        if (privateCoachInfoList != null && !privateCoachInfoList.isEmpty()) {
            for (PrivateCoachInfo privateCoachInfo : privateCoachInfoList) {
                if (subId == privateCoachInfo.getSubject().getSubId()) {
                    privateCoachInfoDao.delete(privateCoachInfo);
                }
            }
        }
        subjectDao.deleteById(subId);
        return getSubjectMap(subname, pageSize, pageNumber);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void save(Subject subject) {
        subjectDao.save(subject);
    }

    @RequestMapping("/cha")
    @ResponseBody
    public Optional<Subject> one(long subId) {
        return subjectDao.findById(subId);
    }

    @RequestMapping("/upd")
    @ResponseBody
    public void upd(Subject subject) {
        subjectDao.save(subject);
    }

    @RequestMapping("/count")
    @ResponseBody
    public Long count(String subname) {
        subjectDaoImpl.count(subname);
        return subjectDaoImpl.count(subname);
    }

}
