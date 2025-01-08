create table goods
(
    goodsId   int auto_increment
        primary key,
    goodsName varchar(50)  null,
    unit      varchar(20)  null,
    unitPrice double       null,
    sellPrice double       null,
    inventory int          null,
    remark    varchar(100) null
)
    charset = utf8mb3;

INSERT INTO gym.goods (goodsName, unit, unitPrice, sellPrice, inventory, remark) VALUES ('狙击枪瞄准镜', '个', 168, 368, 18, '');
INSERT INTO gym.goods (goodsName, unit, unitPrice, sellPrice, inventory, remark) VALUES ('95式狙击枪', '个', 18888, 28888, 17, '');
