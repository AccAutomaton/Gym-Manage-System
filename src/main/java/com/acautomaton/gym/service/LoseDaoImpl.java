package com.acautomaton.gym.service;

import com.acautomaton.gym.dao.LoseDao;
import com.acautomaton.gym.entity.Lose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class LoseDaoImpl {
    @Autowired
    private LoseDao loosDao;

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> query(Map<String, Object> map1) {
        String jpal = "from Lose where 1=1";
        if (map1.get("loosName") != null && !map1.get("loosName").equals("")) {
            jpal = jpal + " and loosName like '%" + map1.get("loosName") + "%'";
        }
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(l) from Lose l where 1=1";
        if (map1.get("loosName") != null && !map1.get("loosName").equals("")) {
            jpa = jpa + " and loosName like '%" + map1.get("loosName") + "%'";
        }
        Long count = (Long) entityManager.createQuery(jpa).getSingleResult();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", qu.getResultList());
        return map;
    }

    public int update(Lose loos) {
        Lose loos1 = loosDao.findById(loos.getLoosId()).get();
        loos1.setLoosStatus(loos.getLoosStatus());
        loos1.setReceiveName(loos.getReceiveName());
        loos1.setReceivePhone(loos.getReceivePhone());
        loos1.setLoosldate(loos.getLoosldate());
        loosDao.save(loos1);
        return 1;
    }
}
