package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.LoosDao;
import com.acautomaton.gym.entity.Loos;
import com.acautomaton.gym.service.LoosDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/loos")
public class LoseController {
    private final LoosDaoImpl loosDaoImpl;
    private final LoosDao loosDao;

    @Autowired LoseController(LoosDaoImpl loosDaoImpl, LoosDao loosDao) {
        this.loosDaoImpl = loosDaoImpl;
        this.loosDao = loosDao;
    }

    @RequestMapping("/jin9")
    public String jin7() {
        return "WEB-INF/jsp/loos";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query(String loosName, int pageSize, int pageNumber) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("loosName", loosName);
        map1.put("qi", (pageNumber - 1) * pageSize);
        map1.put("shi", pageSize);
        return loosDaoImpl.query(map1);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void save(Loos loos) {
        loosDao.save(loos);
    }

    @RequestMapping("/query3")
    @ResponseBody
    public List<Loos> query3(long loosId) {
        List<Loos> list = new ArrayList<>();
        list.add(loosDao.findById(loosId).get());
        return list;
    }

    @RequestMapping("/quhui")
    @ResponseBody
    public void upd(Loos loos) {
        loosDaoImpl.update(loos);
    }

    @RequestMapping("/cha")
    @ResponseBody
    public Optional<Loos> one(Long loosId) {
        return loosDao.findById(loosId);
    }

}
