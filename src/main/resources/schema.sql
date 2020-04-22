create table if not exists USER
(
    ID       INT auto_increment,
    NAME     VARCHAR(256),
    PASSWORD VARCHAR(256),
    constraint USER_PK
        primary key (ID)
);

create unique index if not exists USER_ID_UINDEX
    on USER (ID);


create table if not exists TASK
(
    ID          INT auto_increment,
    OWNER_ID    INT,
    DESCRIPTION VARCHAR,
    STATUS      VARCHAR,
    constraint TASK_PK
        primary key (ID),
    constraint TASK_USER_ID_FK
        foreign key (OWNER_ID) references USER (ID) ON DELETE CASCADE
);

create unique index if not exists TASK_ID_UINDEX
    on TASK (ID);
