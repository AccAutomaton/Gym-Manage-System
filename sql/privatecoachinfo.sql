create table privatecoachinfo
(
    pid        int auto_increment
        primary key,
    memberid   int                        null,
    coachid    int                        null,
    subjectid  int                        null,
    count      int                        null,
    countprice double                     null,
    realprice  double                     null,
    date       date                       null,
    state      int                        null,
    remark     varchar(20)                null,
    admin      varchar(20) default 'asdf' null,
    constraint fk_pri_coach
        foreign key (coachid) references coach (coachId),
    constraint fk_pri_member
        foreign key (memberid) references member (MemberId),
    constraint fk_pri_subject
        foreign key (subjectid) references subject (subId)
)
    charset = utf8mb3;

INSERT INTO gym.privatecoachinfo (memberid, coachid, subjectid, count, countprice, realprice, date, state, remark, admin) VALUES (46, 17, 7, 1, 188, 200, '2024-12-30', 1, '', 'asdf');
INSERT INTO gym.privatecoachinfo (memberid, coachid, subjectid, count, countprice, realprice, date, state, remark, admin) VALUES (47, 17, 7, 1, 188, 300, '2025-01-03', 1, '', 'asdf');
