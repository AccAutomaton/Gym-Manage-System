package com.acautomaton.gym.dao;

import com.acautomaton.gym.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachDao extends JpaRepository<Coach, Long> {
}
