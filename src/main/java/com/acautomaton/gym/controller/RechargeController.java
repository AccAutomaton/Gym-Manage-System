package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.MenberDao;
import com.acautomaton.gym.dao.chongzhiDao;
import com.acautomaton.gym.entity.Chongzhi;
import com.acautomaton.gym.entity.Member;
import com.acautomaton.gym.service.MenberDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/cz")
public class RechargeController {
    private final chongzhiDao chongzhiDao;
    private final MenberDao menberDao;
    private final MenberDaoImpl menberDaoImpl;

    @Autowired
    public RechargeController(chongzhiDao chongzhiDao, MenberDao menberDao, MenberDaoImpl menberDaoImpl) {
        this.chongzhiDao = chongzhiDao;
        this.menberDao = menberDao;
        this.menberDaoImpl = menberDaoImpl;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping("/jin")
    public String jin() {
        return "WEB-INF/jsp/HYMemberjilu";
    }

    @RequestMapping("/jin2")
    public String jin2() {
        return "WEB-INF/jsp/ShouRuTongji";
    }

    @RequestMapping("/xin")
    @ResponseBody
    public Map<String, Object> cye(Chongzhi chongzhi) {
        Member member = menberDao.findById(chongzhi.getMember().getMemberId()).get();
        member.setMemberbalance(member.getMemberbalance() + chongzhi.getMoney());
        menberDao.save(member);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.sql.Timestamp dat = java.sql.Timestamp.valueOf(df.format(new Date()));
        chongzhi.setDate(dat);
        chongzhi.setCzStatic(1L);
        chongzhiDao.save(chongzhi);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("hyname", null);
        map1.put("ktype", 0);
        map1.put("qi", 1);
        map1.put("shi", 5);
        return menberDaoImpl.query(map1);
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query(int pageSize, int pageNumber, final String xdate, final String ddate) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        if (xdate.isEmpty() || ddate.isEmpty()) {
            return map;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final Date startTime = sdf.parse(xdate);
        final Date endTime = sdf.parse(ddate);
        Pageable pageable = new PageRequest(pageNumber - 1, pageSize);
        Specification<Chongzhi> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.between(root.get("date"), startTime, endTime));

            return criteriaBuilder.and(list.toArray(new Predicate[0]));
        };
        Page<Chongzhi> list1 = chongzhiDao.findAll(specification, pageable);
        List<Chongzhi> li = list1.getContent();
        map.put("total", list1.getTotalElements());
        map.put("rows", li);
        return map;
    }

    @RequestMapping("/tongji")
    @ResponseBody
    public int[] TOngji() {
        String[] array = {"2024-01", "2024-02", "2024-03", "2024-04", "2024-05", "2024-06", "2024-07", "2024-08", "2024-09", "2024-10", "2024-11", "2024-12"};
        int[] intar = new int[12];
        for (int i = 0; i < array.length; i++) {
            String jpa = "select sum(a.money) from Chongzhi as a where Date like('%" + array[i] + "%')";
            Query query = entityManager.createQuery(jpa);
            Object obj = query.getSingleResult();
            if (obj == null) {
                intar[i] = 0;
            }
            else {
                intar[i] = ((Long) obj).intValue();
            }
        }
        return intar;
    }
}
