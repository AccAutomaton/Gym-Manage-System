package com.acautomaton.gym.dao;

import com.acautomaton.gym.entity.PrivateCoachInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrivateCoachInfoDao extends JpaRepository<PrivateCoachInfo, Long> {
    @Query(value = "select * FROM  privatecoachinfo where memberid =:memberid", nativeQuery = true)
    List<PrivateCoachInfo> queryByIdNative(@Param("memberid") long memberid);

    @Query(value = "select * FROM  privatecoachinfo where coachid =:coachid", nativeQuery = true)
    List<PrivateCoachInfo> queryByCoachIdNative(@Param("coachid") long coachid);

    @Query(value = "select * FROM  privatecoachinfo where subjectid =:subjectid", nativeQuery = true)
    List<PrivateCoachInfo> queryBySubjectIdNative(@Param("subjectid") long subjectid);
}
