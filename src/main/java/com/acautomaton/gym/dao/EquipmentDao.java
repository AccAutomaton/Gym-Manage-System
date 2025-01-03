package com.acautomaton.gym.dao;

import com.acautomaton.gym.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentDao extends JpaRepository<Equipment, Long> {
}
