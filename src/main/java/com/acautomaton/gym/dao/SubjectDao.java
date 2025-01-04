package com.acautomaton.gym.dao;

import com.acautomaton.gym.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject, Long> {
}
