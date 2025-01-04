package com.acautomaton.gym.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "adminuser")
@Getter
@Setter
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adminId;
    private String adminName;
    private String adminPassword;
}
