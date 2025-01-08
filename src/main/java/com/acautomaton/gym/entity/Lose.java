package com.acautomaton.gym.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lose")
@Getter
@Setter
public class Lose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loosId;
    private String loosName;
    private String loosImages;
    private String loosAddress;
    private java.sql.Date loosjdate;
    private Integer loosStatus;
    private String scavenger;
    private String scavengerPhone;
    private String receiveName;
    private String receivePhone;
    private java.sql.Date loosldate;
    private String admin;
}
