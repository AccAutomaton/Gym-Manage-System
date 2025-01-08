create table coach
(
    coachId      int auto_increment
        primary key,
    coachName    varchar(20)   null,
    coachPhone   varchar(50)   null,
    coachSex     int           null,
    CoachAge     int           null,
    CoachData    date          null,
    Teach        int           null,
    CoachWages   double        null,
    CoachAddress varchar(100)  null,
    CoachStatic  int default 0 null
)
    charset = utf8mb3;

INSERT INTO gym.coach (coachName, coachPhone, coachSex, CoachAge, CoachData, Teach, CoachWages, CoachAddress, CoachStatic) VALUES ('范天雷', '18012345678', 0, 33, '2024-12-01', 30, 18888, '狼牙特战旅红细胞特别行动小组', 0);
INSERT INTO gym.coach (coachName, coachPhone, coachSex, CoachAge, CoachData, Teach, CoachWages, CoachAddress, CoachStatic) VALUES ('czw', '15797851904', 0, 33, '2025-01-02', 12, 123, '123', 0);
