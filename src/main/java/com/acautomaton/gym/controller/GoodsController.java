package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.GoodInfoDao;
import com.acautomaton.gym.dao.GoodsDao;
import com.acautomaton.gym.entity.GoodInfo;
import com.acautomaton.gym.entity.Goods;
import com.acautomaton.gym.service.GoodsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsDao goodsDao;
    private final GoodInfoDao goodInfoDao;
    private final GoodsDaoImpl goodsDaoImpl;

    @Autowired
    public GoodsController(GoodsDao goodsDao, GoodInfoDao goodInfoDao, GoodsDaoImpl goodsDaoImpl) {
        this.goodsDao = goodsDao;
        this.goodInfoDao = goodInfoDao;
        this.goodsDaoImpl = goodsDaoImpl;
    }

    @RequestMapping("/sp")
    public String sp() {
        return "WEB-INF/jsp/Goods";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query(String goodsname, int pageSize, int pageNumber) {
        return getGoodsMap(goodsname, pageSize, pageNumber);
    }

    private Map<String, Object> getGoodsMap(String goodsname, int pageSize, int pageNumber) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("goodsname", goodsname);
        map1.put("qi", (pageNumber - 1) * pageSize);
        map1.put("shi", pageSize);
        return goodsDaoImpl.query(map1);
    }

    @RequestMapping("/query2")
    @ResponseBody
    public List<Goods> query2() {
        return goodsDao.findAll();
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> del(long goodsId, String goodsname, int pageSize, int pageNumber) {
        List<GoodInfo> goodInfoList = goodInfoDao.queryByGoodsIdNative(goodsId);
        if (goodInfoList != null && !goodInfoList.isEmpty()) {
            for (GoodInfo goodInfo : goodInfoList) {
                if (goodsId == goodInfo.getGoods().getGoodsId()) {
                    goodInfoDao.delete(goodInfo);
                }
            }
        }
        goodsDao.deleteById(goodsId);
        return getGoodsMap(goodsname, pageSize, pageNumber);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void save(Goods goods) {
        goodsDao.save(goods);
    }

    @RequestMapping("/cha")
    @ResponseBody
    public Optional<Goods> one(long goodsId) {
        return goodsDao.findById(goodsId);
    }

    @RequestMapping("/count")
    @ResponseBody
    public Long count(String goodsName) {
        return goodsDaoImpl.count(goodsName);
    }

    @RequestMapping("/upd")
    @ResponseBody
    public void upd(Goods goods) {
        goodsDaoImpl.update(goods);
    }

    @RequestMapping("/update")
    @ResponseBody
    public void update(Goods goods) {
        goodsDao.save(goods);
    }

    @RequestMapping("/topcoach")
    @ResponseBody
    public Map<String, Object> topcoach() {
        Map<String, Object> map = new HashMap<>();
        map.put("goods", goodsDao.findAll());
        return map;
    }
}
