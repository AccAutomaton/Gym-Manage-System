package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.GoodInfoDao;
import com.acautomaton.gym.dao.GoodsDao;
import com.acautomaton.gym.dao.MemberDao;
import com.acautomaton.gym.entity.GoodInfo;
import com.acautomaton.gym.entity.Goods;
import com.acautomaton.gym.entity.Member;
import com.acautomaton.gym.service.GoodInfoDaoImpl;
import com.acautomaton.gym.service.GoodsDaoImpl;
import com.acautomaton.gym.service.MenberDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/goodinfo")
public class GoodInfoController {
    private final GoodInfoDao goodInfoDao;
    private final GoodsDao goodsDao;
    private final GoodInfoDaoImpl goodInfoDaoImpl;
    private final MemberDao menberDao;
    private final GoodsDaoImpl goodsDaoImpl;
    private final MenberDaoImpl menberDaoImpl;

    @Autowired
    public GoodInfoController(GoodInfoDao goodInfoDao, GoodsDao goodsDao, GoodInfoDaoImpl goodInfoDaoImpl,
                              MemberDao menberDao, GoodsDaoImpl goodsDaoImpl, MenberDaoImpl menberDaoImpl) {
        this.goodInfoDao = goodInfoDao;
        this.goodsDao = goodsDao;
        this.goodInfoDaoImpl = goodInfoDaoImpl;
        this.menberDao = menberDao;
        this.menberDaoImpl = menberDaoImpl;
        this.goodsDaoImpl = goodsDaoImpl;
    }

    @RequestMapping("/spinfo")
    public String spinfo() {
        return "WEB-INF/jsp/GoodInfo";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query(Integer goodsid, Integer memberid, int pageSize, int pageNumber) {
        return getGoodMap(goodsid, memberid, pageSize, pageNumber);
    }

    private Map<String, Object> getGoodMap(Integer goodsid, Integer memberid, int pageSize, int pageNumber) {
        Map<String, Object> map = new HashMap<>();
        map.put("goodsid", goodsid);
        map.put("memberid", memberid);
        map.put("qi", (pageNumber - 1) * pageSize);
        map.put("shi", pageSize);
        return goodInfoDaoImpl.query(map);
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> del(long id, Integer goodsid, Integer memberid, int pageSize, int pageNumber) {
        goodInfoDao.deleteById(id);
        return getGoodMap(goodsid, memberid, pageSize, pageNumber);
    }

    @RequestMapping("/dellist")
    @ResponseBody
    public Map<String, Object> delete(int[] array, Integer goodsid, Integer memberid, int pageSize, int pageNumber) {
        System.out.println(array[0]);
        for (int j : array) {
            goodInfoDao.deleteById((long) j);
        }
        return query(goodsid, memberid, pageSize, pageNumber);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void save(GoodInfo goodInfo) {
        goodInfoDao.save(goodInfo);
    }

    @RequestMapping("/cha")
    @ResponseBody
    public Optional<GoodInfo> one(long goodsId) {
        return goodInfoDao.findById(goodsId);
    }

    @RequestMapping("/chagoods")
    @ResponseBody
    public Optional<Goods> oneg(long goodsId) {
        return goodsDao.findById(goodsId);
    }

    @RequestMapping("/chamember")
    @ResponseBody
    public Optional<Member> onem(long memberId) {
        return menberDao.findById(memberId);
    }

    @RequestMapping("/upd")
    @ResponseBody
    public void upd(GoodInfo goodInfo) {
        goodInfoDao.save(goodInfo);
    }

    @RequestMapping("/updmember")
    @ResponseBody
    public void upd(Member member) {
        menberDaoImpl.upd(member);
    }

    @RequestMapping("/updgoods")
    @ResponseBody
    public void upd(Goods goods) {
        goodsDaoImpl.update(goods);
    }
}
