create table equipment
(
    eqId   int auto_increment
        primary key,
    eqName varchar(20) null,
    eqText varchar(50) null
)
    charset = utf8mb3;

INSERT INTO gym.equipment (eqName, eqText) VALUES ('95式狙击步枪', '弹道偏左');
