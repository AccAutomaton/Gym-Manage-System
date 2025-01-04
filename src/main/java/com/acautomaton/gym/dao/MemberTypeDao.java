package com.acautomaton.gym.dao;

import com.acautomaton.gym.entity.MemberType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTypeDao extends JpaRepository<MemberType, Long> {
}
