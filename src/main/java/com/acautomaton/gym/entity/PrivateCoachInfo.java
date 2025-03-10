package com.acautomaton.gym.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "privatecoachinfo")
@Getter
@Setter
public class PrivateCoachInfo implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;
    @ManyToOne
    @JoinColumn(name = "subjectid")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "coachid")
    private Coach coach;
    @ManyToOne
    @JoinColumn(name = "memberid")
    private Member member;
    private int count;
    private double countprice;
    private double realprice;
    private java.sql.Date date;
    private int state;
    private String remark;
    private String admin;
}
