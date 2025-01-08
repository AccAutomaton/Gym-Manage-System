create table lose
(
    loosId         int auto_increment
        primary key,
    loosName       varchar(20) null,
    loosImages     varchar(50) null,
    loosAddress    varchar(50) null,
    loosjdate      datetime    null,
    loosStatus     int         null,
    scavenger      varchar(50) null,
    scavengerPhone varchar(50) null,
    ReceiveName    varchar(20) null,
    ReceivePhone   varchar(20) null,
    loosldate      datetime    null,
    admin          varchar(50) null
)
    charset = utf8mb3;

INSERT INTO gym.lose (loosName, loosImages, loosAddress, loosjdate, loosStatus, scavenger, scavengerPhone, ReceiveName, ReceivePhone, loosldate, admin) VALUES ('靶子', '1', '靶场', '2024-12-30 00:00:00', 0, '何晨光', '13812345678', null, null, null, 'admin');
INSERT INTO gym.lose (loosName, loosImages, loosAddress, loosjdate, loosStatus, scavenger, scavengerPhone, ReceiveName, ReceivePhone, loosldate, admin) VALUES ('瞄准镜', '1', '狙击阵地', '2025-01-08 00:00:00', 0, '李二牛', '13912345678', null, null, null, 'admin');
