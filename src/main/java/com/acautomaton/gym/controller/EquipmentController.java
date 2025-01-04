package com.acautomaton.gym.controller;

import com.acautomaton.gym.entity.Equipment;
import com.acautomaton.gym.service.EquipmentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/qc")
public class EquipmentController {
    private final EquipmentDaoImpl equipmentDao;

    @Autowired
    EquipmentController(EquipmentDaoImpl equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    @RequestMapping("/yemian")
    public String yemian() {
        return "WEB-INF/jsp/Equipment";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query(String hyname, int pageSize, int pageNumber) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("hyname", hyname);
        map1.put("qi", (pageNumber - 1) * pageSize);
        map1.put("shi", pageSize);
        return equipmentDao.query(map1);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insert(Equipment equipment) {
        equipmentDao.insert(equipment);
        return query("", 5, 1);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> del(int eqId) {
        equipmentDao.del(eqId);
        return query("", 5, 1);
    }
}
