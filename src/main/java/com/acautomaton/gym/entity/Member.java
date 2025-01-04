package com.acautomaton.gym.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;
    private String memberName;
    private String memberPhone;
    private long memberSex;
    private long memberAge;
    private String birthday;
    private java.sql.Date nenberDate;
    @ManyToOne
    @JoinColumn(name = "MemberTypes")
    private Membertype membertypes;
    private long memberStatic;
    private float memberbalance;
    private java.sql.Date Memberxufei;
}
