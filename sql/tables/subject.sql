create table subject
(
    subId        int auto_increment
        primary key,
    subname      varchar(20) null,
    sellingPrice double      null
)
    charset = utf8mb3;

INSERT INTO gym.subject (subname, sellingPrice) VALUES ('武装越野', 188);
