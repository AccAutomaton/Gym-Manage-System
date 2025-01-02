package com.acautomaton.gym.dao;


import com.acautomaton.gym.entity.Membertype;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: 会员卡类型信息Dao层接口
 * @Author: LiuJian
 * @Date: 2020/4/3
 */
public interface MemberttypeDao extends JpaRepository<Membertype,Long> {
}
