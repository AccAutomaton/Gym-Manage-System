package com.acautomaton.gym.dao;


import com.acautomaton.gym.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Long> {
}
