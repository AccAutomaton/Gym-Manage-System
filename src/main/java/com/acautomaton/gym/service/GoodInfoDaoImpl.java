package com.acautomaton.gym.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@Service
public class GoodInfoDaoImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> query(Map<String, Object> map1) {
        String jpal = "from GoodInfo where 1=1";
        if (map1.get("goodsid") != null && !map1.get("goodsid").equals("")) {
            jpal = jpal + " and goodsid = '" + map1.get("goodsid") + "'";
        }
        if (map1.get("memberid") != null && !map1.get("memberid").equals("")) {
            jpal = jpal + " and memberid = '" + map1.get("memberid") + "'";
        }
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(x) from GoodInfo x where 1=1";
        if (map1.get("goodsid") != null && !map1.get("goodsid").equals("")) {
            jpa = jpa + " and goodsid = '" + map1.get("goodsid") + "'";
        }
        if (map1.get("memberid") != null && !map1.get("memberid").equals("")) {
            jpa = jpa + " and memberid = '" + map1.get("memberid") + "'";
        }
        Long count = (Long) entityManager.createQuery(jpa).getSingleResult();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", qu.getResultList());
        return map;
    }
}
