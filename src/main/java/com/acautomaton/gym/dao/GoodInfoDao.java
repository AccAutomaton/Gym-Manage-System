package com.acautomaton.gym.dao;

import com.acautomaton.gym.entity.GoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodInfoDao extends JpaRepository<GoodInfo, Long> {

    @Query(value = "select * FROM goodinfo where memberid =:memberid", nativeQuery = true)
    List<GoodInfo> queryByIdNative(@Param("memberid") long memberid);

    @Query(value = "select * FROM goodinfo where goodsid =:goodsid", nativeQuery = true)
    List<GoodInfo> queryByGoodsIdNative(@Param("goodsid") long goodsid);
}
