package com.acautomaton.gym.service;

import com.acautomaton.gym.dao.EquipmentDao;
import com.acautomaton.gym.entity.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class EquipmentDaoImpl {
    @Autowired
    private EquipmentDao equipmentDao;

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> query(Map<String, Object> map1) {
        String jpal = "from Equipment where 1=1";
        if (map1.get("hyname") != null && !map1.get("hyname").equals("")) {
            jpal = jpal + " and eqName like '%" + map1.get("hyname") + "%'";
        }
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(m) from Equipment m where 1=1";
        if (map1.get("hyname") != null && !map1.get("hyname").equals("")) {
            jpa = jpa + " and eqName like '%" + map1.get("hyname") + "%'";
        }
        Long count = (Long) entityManager.createQuery(jpa).getSingleResult();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", qu.getResultList());
        return map;
    }

    public int insert(Equipment equipment) {
        equipmentDao.save(equipment);
        return 1;
    }

    public int del(int eqId) {
        Long memid = (long) eqId;
        equipmentDao.deleteById(memid);
        return 1;
    }
}
