package com.acautomaton.gym.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@Service
public class PrivateCoachDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("DuplicatedCode")
    public Map<String, Object> query(Map<String, Object> map1) {
        String jpal = "from Coach where 1=1";
        if (map1.get("coachname") != null && !map1.get("coachname").equals("")) {
            jpal = jpal + " and coachName like '%" + map1.get("coachname") + "%'";
        }
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(c) from Coach c where 1=1";
        if (map1.get("coachname") != null && !map1.get("coachname").equals("")) {
            jpa = jpa + " and coachName like '%" + map1.get("coachname") + "%'";
        }
        Long count = (Long) entityManager.createQuery(jpa).getSingleResult();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", qu.getResultList());
        return map;
    }

    public Map<String, Object> query2(Map<String, Object> map1) {
        String jpal = "from Member where 1=1";
        if (map1.get("hyname") != null && !map1.get("hyname").equals("")) {
            jpal = jpal + " and memberName like '%" + map1.get("hyname") + "%'";
        }
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(m) from Member m where 1=1";
        if (map1.get("hyname") != null && !map1.get("hyname").equals("")) {
            jpa = jpa + " and memberName like '%" + map1.get("hyname") + "%'";
        }
        Long count = (Long) entityManager.createQuery(jpa).getSingleResult();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", qu.getResultList());
        return map;
    }
}
