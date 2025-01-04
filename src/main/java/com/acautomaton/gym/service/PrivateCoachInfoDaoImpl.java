package com.acautomaton.gym.service;

import com.acautomaton.gym.dao.PrivateCoachInfoDao;
import com.acautomaton.gym.entity.PrivateCoachInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class PrivateCoachInfoDaoImpl {
    @Autowired
    private PrivateCoachInfoDao privateCoachInfoDao;

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> query(Map<String, Object> map1) {
        String jpal = "from PrivateCoachInfo where 1=1";
        if (map1.get("subjectid") != null && !map1.get("subjectid").equals("")) {
            jpal = jpal + " and subjectid = '" + map1.get("subjectid") + "'";
        }
        if (map1.get("coachid") != null && !map1.get("coachid").equals("")) {
            jpal = jpal + " and coachid = '" + map1.get("coachid") + "'";
        }
        if (map1.get("memberid") != null && !map1.get("memberid").equals("")) {
            jpal = jpal + " and memberid = '" + map1.get("memberid") + "'";
        }
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(p) from PrivateCoachInfo p where 1=1";
        if (map1.get("subjectid") != null && !map1.get("subjectid").equals("")) {
            jpa = jpa + " and subjectid = '" + map1.get("subjectid") + "'";
        }
        if (map1.get("coachid") != null && !map1.get("coachid").equals("")) {
            jpa = jpa + " and coachid = '" + map1.get("coachid") + "'";
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

    public Long count(Integer memid) {
        String jpa = "select count(p) from PrivateCoachInfo p where memberId=" + memid;
        Query query = entityManager.createQuery(jpa);
        System.out.println(query);
        return (Long) query.getSingleResult();
    }

    public int update(PrivateCoachInfo privateCoachInfo) {
        PrivateCoachInfo privateCoachInfo1 = privateCoachInfoDao.findById(privateCoachInfo.getPid()).get();
        privateCoachInfo1.setCoach(privateCoachInfo.getCoach());
        privateCoachInfoDao.save(privateCoachInfo1);
        return 1;
    }

    public List<PrivateCoachInfo> ByMemberid(Long memberid) {
        return privateCoachInfoDao.queryByIdNative(memberid);
    }
}
