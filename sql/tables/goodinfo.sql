create table goodinfo
(
    id       int auto_increment
        primary key,
    goodsid  int          null,
    memberid int          null,
    count    int          null,
    price    double       null,
    remark   varchar(100) null
)
    charset = utf8mb3;

INSERT INTO gym.goodinfo (goodsid, memberid, count, price, remark) VALUES (9, 46, 1, 368, '');
INSERT INTO gym.goodinfo (goodsid, memberid, count, price, remark) VALUES (9, 47, 1, 368, '');
INSERT INTO gym.goodinfo (goodsid, memberid, count, price, remark) VALUES (10, 46, 1, 28888, '');
