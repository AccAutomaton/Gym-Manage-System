package com.acautomaton.gym.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "membertype")
@Getter
@Setter
public class MemberType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long typeId;
    private String typeName;
    private long typeciShu;
    private long typeDay;
    private float typemoney;
    @OneToMany(mappedBy = "membertypes")
    @JsonIgnore
    private List<Member> list = new ArrayList<>();
}
