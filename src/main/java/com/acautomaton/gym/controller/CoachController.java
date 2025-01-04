package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.CoachDao;
import com.acautomaton.gym.dao.PrivateCoachInfoDao;
import com.acautomaton.gym.entity.Coach;
import com.acautomaton.gym.entity.PrivateCoachInfo;
import com.acautomaton.gym.service.CoachDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/coach")
public class CoachController {
    private final CoachDao coachDao;
    private final PrivateCoachInfoDao privateCoachInfoDao;
    private final CoachDaoImpl coachDaoImpl;

    @Autowired
    public CoachController(CoachDaoImpl coachDaoImpl, CoachDao coachDao, PrivateCoachInfoDao privateCoachInfoDao) {
        this.coachDaoImpl = coachDaoImpl;
        this.coachDao = coachDao;
        this.privateCoachInfoDao = privateCoachInfoDao;
    }

    @RequestMapping("/jin3")
    public String jin3() {
        return "WEB-INF/jsp/Coach";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query(String coachname, int pageSize, int pageNumber) {
        return getCoachMap(coachname, pageSize, pageNumber);
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> del(long id, String coachname, int pageSize, int pageNumber) {
        List<PrivateCoachInfo> privateCoachInfoList = privateCoachInfoDao.queryByCoachIdNative(id);
        if (privateCoachInfoList != null && !privateCoachInfoList.isEmpty()) {
            for (PrivateCoachInfo privateCoachInfo : privateCoachInfoList) {
                if (id == privateCoachInfo.getCoach().getCoachId()) {
                    privateCoachInfoDao.delete(privateCoachInfo);
                }
            }
        }
        coachDao.deleteById(id);
        return getCoachMap(coachname, pageSize, pageNumber);
    }

    private Map<String, Object> getCoachMap(String coachname, int pageSize, int pageNumber) {
        return PrivateCoachController.getCoachMap(coachname, pageSize, pageNumber, coachDaoImpl);
    }

    @RequestMapping("/count")
    @ResponseBody
    public Long count(String coachName) {
        coachDaoImpl.count(coachName);
        return coachDaoImpl.count(coachName);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void save(Coach coach) {
        coachDao.save(coach);
    }

    @RequestMapping("/cha")
    @ResponseBody
    public Optional<Coach> one(long id) {
        return coachDao.findById(id);
    }

    @RequestMapping("/upd")
    @ResponseBody
    public void upd(Coach coach) {
        coachDao.save(coach);
    }
}
