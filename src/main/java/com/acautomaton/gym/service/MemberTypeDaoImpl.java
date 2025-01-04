package com.acautomaton.gym.service;

import com.acautomaton.gym.dao.MemberTypeDao;
import com.acautomaton.gym.entity.MemberType;
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
public class MemberTypeDaoImpl {

    @Autowired
    private MemberTypeDao memberttypeDao;

    public List<MemberType> cha() {
        return memberttypeDao.findAll();
    }

    public MemberType cha2(int id) {
        Long lo = (long) id;
        return memberttypeDao.findById(lo).get();
    }

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> query(Map<String, Object> map1) {
        String jpal = "from MemberType where 1=1";
        if (map1.get("typeName") != null && !map1.get("typeName").equals("")) {
            jpal = jpal + " and TypeName like '%" + map1.get("typeName") + "%'";
        }
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(t) from MemberType t where 1=1";
        if (map1.get("typeName") != null && !map1.get("typeName").equals("")) {
            jpa = jpa + " and TypeName like '%" + map1.get("typeName") + "%'";
        }
        Long count = (Long) entityManager.createQuery(jpa).getSingleResult();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", qu.getResultList());
        return map;
    }
}
