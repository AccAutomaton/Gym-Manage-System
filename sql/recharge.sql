create table recharge
(
    Id       int auto_increment
        primary key,
    Memberid int         null,
    Typeid   int         null,
    Money    int         null,
    ssmoney  int         null,
    zlmoney  int         null,
    Date     datetime    null,
    czjine   int         null,
    beizhu   varchar(50) null,
    czStatic int         null
)
    charset = utf8mb3;

INSERT INTO gym.recharge (Memberid, Typeid, Money, ssmoney, zlmoney, Date, czjine, beizhu, czStatic) VALUES (46, null, 188, 198, 10, '2024-12-29 17:14:14', 0, '', 1);
INSERT INTO gym.recharge (Memberid, Typeid, Money, ssmoney, zlmoney, Date, czjine, beizhu, czStatic) VALUES (47, null, 648, 648, 0, '2025-01-03 11:06:26', 0, '', 1);
INSERT INTO gym.recharge (Memberid, Typeid, Money, ssmoney, zlmoney, Date, czjine, beizhu, czStatic) VALUES (46, null, 100, 100, 0, '2025-01-05 11:09:31', 0, '', 1);
