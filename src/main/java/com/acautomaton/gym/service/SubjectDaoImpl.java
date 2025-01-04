package com.acautomaton.gym.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@Service
public class SubjectDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> query(Map<String, Object> map1) {
        String jpal = "from Subject where 1=1";
        if (map1.get("subname") != null && !map1.get("subname").equals("")) {
            jpal = jpal + " and subname like '%" + map1.get("subname") + "%'";
        }
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(s) from Subject s where 1=1";
        if (map1.get("subname") != null && !map1.get("subname").equals("")) {
            jpa = jpa + " and subname like '%" + map1.get("subname") + "%'";
        }
        Long count = (Long) entityManager.createQuery(jpa).getSingleResult();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", qu.getResultList());
        return map;
    }

    public Long count(String subname) {
        String jpa = "select count(s) from Subject s where subname ='" + subname + "'";
        Query query = entityManager.createQuery(jpa);
        System.out.println(query);
        return (Long) query.getSingleResult();
    }
}
