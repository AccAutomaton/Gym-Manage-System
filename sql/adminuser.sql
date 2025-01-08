create table adminuser
(
    adminId       int auto_increment
        primary key,
    adminName     varchar(20)  null,
    adminPassword varchar(256) null
)
    charset = utf8mb3;

INSERT INTO gym.adminuser (adminName, adminPassword) VALUES ('admin', '0192023a7bbd73250516f069df18b500');
