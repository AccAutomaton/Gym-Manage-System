create table member
(
    MemberId      int auto_increment
        primary key,
    MemberName    varchar(20)     null,
    MemberPhone   varchar(20)     null,
    MemberSex     int             null,
    MemberAge     int             null,
    MemberTypes   int             null,
    NenberDate    date            null,
    Birthday      varchar(20)     null,
    memberStatic  int             null,
    Memberbalance float default 0 null,
    Memberxufei   date            null,
    constraint `fk-member-membertype`
        foreign key (MemberTypes) references membertype (TypeId)
)
    charset = utf8mb3;

INSERT INTO gym.member (MemberName, MemberPhone, MemberSex, MemberAge, MemberTypes, NenberDate, Birthday, memberStatic, Memberbalance, Memberxufei) VALUES ('李二牛', '13612345678', 1, 18, 3, '2024-12-29', '06-18', 1, -28788, '2026-01-03');
INSERT INTO gym.member (MemberName, MemberPhone, MemberSex, MemberAge, MemberTypes, NenberDate, Birthday, memberStatic, Memberbalance, Memberxufei) VALUES ('何晨光', '13912345678', 1, 18, 5, '2024-12-29', '06-18', 2, 92, '2025-01-05');
INSERT INTO gym.member (MemberName, MemberPhone, MemberSex, MemberAge, MemberTypes, NenberDate, Birthday, memberStatic, Memberbalance, Memberxufei) VALUES ('王艳兵', '14012345678', 1, 18, 2, '2024-12-29', '06-18', 1, 0, '2025-01-28');
