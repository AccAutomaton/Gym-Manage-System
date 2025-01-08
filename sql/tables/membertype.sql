create table membertype
(
    TypeId    int auto_increment
        primary key,
    TypeName  varchar(20) null,
    TypeciShu int         null,
    TypeDay   int         null,
    Typemoney float       null
)
    charset = utf8mb3;

INSERT INTO gym.membertype (TypeName, TypeciShu, TypeDay, Typemoney) VALUES ('季卡', 30, 90, 500);
INSERT INTO gym.membertype (TypeName, TypeciShu, TypeDay, Typemoney) VALUES ('月卡', 10, 30, 150);
INSERT INTO gym.membertype (TypeName, TypeciShu, TypeDay, Typemoney) VALUES ('年卡', 120, 365, 1000);
INSERT INTO gym.membertype (TypeName, TypeciShu, TypeDay, Typemoney) VALUES ('周卡', 5, 7, 50);
