package com.acautomaton.gym.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@Service
public class CoachDaoImpl {

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

    public Long count(String coachName) {
        String jpa = "select count(c) from Coach c where coachName ='" + coachName + "'";
        Query query = entityManager.createQuery(jpa);
        System.out.println(query);
        return (Long) query.getSingleResult();
    }
}
