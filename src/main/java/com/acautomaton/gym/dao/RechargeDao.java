package com.acautomaton.gym.dao;

import com.acautomaton.gym.entity.Recharge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RechargeDao extends JpaRepository<Recharge, Long> {

    Page<Recharge> findAll(Specification<Recharge> specification, Pageable pageable);

    @Query(value = "select * FROM chongzhi where memberid =:memberid", nativeQuery = true)
    List<Recharge> queryByIdNative(@Param("memberid") long memberid);
}
