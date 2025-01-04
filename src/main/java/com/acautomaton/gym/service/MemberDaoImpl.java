package com.acautomaton.gym.service;

import com.acautomaton.gym.dao.GoodInfoDao;
import com.acautomaton.gym.dao.MemberDao;
import com.acautomaton.gym.dao.PrivateCoachInfoDao;
import com.acautomaton.gym.dao.RechargeDao;
import com.acautomaton.gym.entity.GoodInfo;
import com.acautomaton.gym.entity.Member;
import com.acautomaton.gym.entity.PrivateCoachInfo;
import com.acautomaton.gym.entity.Recharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class MemberDaoImpl {
    @Autowired
    private MemberDao menberDao;

    @Autowired
    private PrivateCoachInfoDao privateCoachInfoDao;

    @Autowired
    private GoodInfoDao goodInfoDao;

    @Autowired
    private RechargeDao chongZhiDao;

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> query(Map<String, Object> map1) throws ParseException {
        List<Member> memberslist = menberDao.findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        Date now = sdf.parse(date);
        for (Member list : memberslist) {
            String date1 = list.getMemberxufei().toString();
            if (date1 == null) {
                date1 = date;
            }
            Date daoqi = sdf.parse(date1);
            Member m = menberDao.findById(list.getMemberId()).get();
            if (daoqi.before(now)) {
                m.setMemberStatic(2L);
            }
            else {
                m.setMemberStatic(1L);
            }
            menberDao.save(m);
        }
        String jpal = "from Member where 1=1";
        if (map1.get("hyname") != null && !map1.get("hyname").equals("")) {
            jpal = jpal + " and memberName like '%" + map1.get("hyname") + "%'";
        }
        int ktype = (int) map1.get("ktype");
        if (ktype != 0) {
            jpal = jpal + "and membertypes=" + ktype;
        }
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(m) from Member m where 1=1";
        if (map1.get("hyname") != null && !map1.get("hyname").equals("")) {
            jpa = jpa + " and memberName like '%" + map1.get("hyname") + "%'";
        }
        if (ktype != 0) {
            jpa = jpa + " and membertypes=" + ktype;
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
        int ktype = (int) map1.get("ktype");
        if (ktype != 0) {
            jpal = jpal + " and membertypes=" + ktype;
        }
        jpal += " and memberStatic = 2";
        Query qu = entityManager.createQuery(jpal);
        qu.setFirstResult((int) map1.get("qi"));
        qu.setMaxResults((int) map1.get("shi"));
        String jpa = "select count(m) from Member m where 1=1";
        if (map1.get("hyname") != null && !map1.get("hyname").equals("")) {
            jpa = jpa + " and memberName like '%" + map1.get("hyname") + "%'";
        }
        if (ktype != 0) {
            jpa = jpa + " and membertypes=" + ktype;
        }
        jpa += " and memberStatic = 2";
        Long count = (Long) entityManager.createQuery(jpa).getSingleResult();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", qu.getResultList());
        return map;
    }

    public int del(int id) {
        Long memid = (long) id;
        List<PrivateCoachInfo> privateCoachInfoList = privateCoachInfoDao.queryByIdNative(memid);
        if (privateCoachInfoList != null && !privateCoachInfoList.isEmpty()) {
            for (PrivateCoachInfo privateCoachInfo : privateCoachInfoList) {
                if (memid.equals(privateCoachInfo.getMember().getMemberId())) {
                    privateCoachInfoDao.delete(privateCoachInfo);
                }
            }
        }
        List<GoodInfo> goodInfoList = goodInfoDao.queryByIdNative(memid);
        if (goodInfoList != null && !goodInfoList.isEmpty()) {
            for (GoodInfo goodInfo : goodInfoList) {
                if (memid.equals(goodInfo.getMember().getMemberId())) {
                    goodInfoDao.delete(goodInfo);
                }
            }
        }
        List<Recharge> chongzhiList = chongZhiDao.queryByIdNative(memid);
        if (chongzhiList != null && !chongzhiList.isEmpty()) {
            for (Recharge chongzhi : chongzhiList) {
                if (memid.equals(chongzhi.getMember().getMemberId())) {
                    chongZhiDao.delete(chongzhi);
                }
            }
        }
        menberDao.deleteById(memid);
        return 1;
    }

    public int insert(Member member) {
        member.setMemberStatic(1L);
        menberDao.save(member);
        return 1;
    }

    public int update(Member member) {
        menberDao.save(member);
        return 1;
    }

    public Member cha(int id) {
        Long lo = (long) id;
        return menberDao.findById(lo).get();
    }

    public int upd(Member member) {
        Member member1 = menberDao.findById(member.getMemberId()).get();
        member1.setMemberbalance(member.getMemberbalance());
        menberDao.save(member1);
        return 1;
    }
}
