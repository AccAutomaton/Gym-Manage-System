package com.acautomaton.gym.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "coach")
@Getter
@Setter
public class Coach implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coachId;
    private String coachName;
    private String coachPhone;
    private long coachSex;
    private long coachAge;
    private java.sql.Date coachData;
    private long teach;
    private double coachWages;
    private long coachStatic;
    private String coachAddress;
}
