package com.acautomaton.gym.service;

import com.acautomaton.gym.dao.GoodsDao;
import com.acautomaton.gym.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class GoodsDaoImpl {
    @Autowired
    private GoodsDao goodsDao;

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> query(Map<String, Object> map1) {
        String jpal = "from Goods where 1=1";
        if (map1.get("goodsname") != null && !map1.get("goodsname").equals("")) {
            jpal = jpal + " and goodsName like '%" + map1.get("goodsname") + "%'";
        }
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(g) from Goods g where 1=1";
        if (map1.get("goodsname") != null && !map1.get("goodsname").equals("")) {
            jpa = jpa + " and goodsName like '%" + map1.get("goodsname") + "%'";
        }
        Long count = (Long) entityManager.createQuery(jpa).getSingleResult();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", qu.getResultList());
        return map;
    }

    public Long count(String goodsName) {
        String jpa = "select count(g) from Goods g where goodsName ='" + goodsName + "'";
        Query query = entityManager.createQuery(jpa);
        System.out.println(query);
        return (Long) query.getSingleResult();
    }

    public int update(Goods goods) {
        Goods goods1 = goodsDao.findById(goods.getGoodsId()).get();
        goods1.setInventory(goods.getInventory());
        goodsDao.save(goods1);
        return 1;
    }
}
