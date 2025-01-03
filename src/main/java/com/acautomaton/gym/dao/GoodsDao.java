package com.acautomaton.gym.dao;

import com.acautomaton.gym.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsDao extends JpaRepository<Goods, Long> {
}
