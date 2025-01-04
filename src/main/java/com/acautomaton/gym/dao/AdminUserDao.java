package com.acautomaton.gym.dao;

import com.acautomaton.gym.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface AdminUserDao extends JpaRepository<AdminUser, Long> {
    AdminUser findByAdminNameAndAdminPassword(String name, String password);

    @Modifying
    @Query(value = "update adminuser set adminPassword =:adminPassword where adminId =:adminId", nativeQuery = true)
    void updPassword(@Param("adminId") long adminId, @Param("adminPassword") String adminPassword);
}
