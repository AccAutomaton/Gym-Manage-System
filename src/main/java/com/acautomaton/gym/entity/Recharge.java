package com.acautomaton.gym.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "recharge")
@Entity
public class Recharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "Memberid")
    private Member member;
    @OneToOne
    @JoinColumn(name = "Typeid")
    private MemberType membertype;
    private long money;
    private long ssmoney;
    private long zlmoney;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.sql.Timestamp date;
    private long czjine;
    private String beizhu;
    private long czStatic;
}
