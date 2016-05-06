
    create table authorities (
        id int4 not null,
        name varchar(255),
        primary key (id)
    );

    create table checkpoint (
        id int4 not null,
        name varchar(255),
        runway_id int4,
        stage_id int4,
        primary key (id)
    );

    create table department (
        id int4 not null,
        name varchar(255),
        primary key (id)
    );

    create table plan (
        id int4 not null,
        name varchar(255),
        department_id int4,
        primary key (id)
    );

    create table plan_checkpoint (
        plan_id int4 not null,
        checkpoint_id int4 not null
    );

    create table runway (
        id int4 not null,
        name varchar(255),
        plan_id int4,
        primary key (id)
    );

    create table stage (
        id int4 not null,
        name varchar(255),
        plan_id int4,
        primary key (id)
    );

    create table users (
        id int4 not null,
        name varchar(255),
        password varchar(255),
        department_id int4,
        plan_id int4,
        primary key (id)
    );

    create table users_authorities (
        users_id int4 not null,
        authorities_id int4 not null,
        primary key (users_id, authorities_id)
    );

    create table users_checkpoint (
        users_id int4 not null,
        checkpoint_id int4 not null
    );

    alter table checkpoint 
        add constraint FK_oiyswu7pdxn0dps6nkqiga4sq 
        foreign key (runway_id) 
        references runway;

    alter table checkpoint 
        add constraint FK_gbq2srqjvt9v8p9j8swbo0w5f 
        foreign key (stage_id) 
        references stage;

    alter table plan 
        add constraint FK_1ckna5ptp81j3dc03l57yfw35 
        foreign key (department_id) 
        references department;

    alter table plan_checkpoint 
        add constraint FK_r0v5gyo0kcqn4gs83c8ybl0uk 
        foreign key (checkpoint_id) 
        references checkpoint;

    alter table plan_checkpoint 
        add constraint FK_nwuo4a6j2b2i32qk01pn6bgb2 
        foreign key (plan_id) 
        references plan;

    alter table runway 
        add constraint FK_2myowg0wb36kv47fkqfgyhaqf 
        foreign key (plan_id) 
        references plan;

    alter table stage 
        add constraint FK_k6pwv821ovp7d177rjmcvy2m5 
        foreign key (plan_id) 
        references plan;

    alter table users 
        add constraint FK_7phkg3qghukhuw9kj3ahkmw 
        foreign key (department_id) 
        references department;

    alter table users 
        add constraint FK_km7rd8sgwa1qls24gkxoh2b2i 
        foreign key (plan_id) 
        references plan;

    alter table users_authorities 
        add constraint FK_4k9modmi5xv8km1qoyfyrjhjt 
        foreign key (authorities_id) 
        references authorities;

    alter table users_authorities 
        add constraint FK_rptayl7trfprewc0uljq5tp94 
        foreign key (users_id) 
        references users;

    alter table users_checkpoint 
        add constraint FK_qywldwxfmyfyx0710btoq8g3p 
        foreign key (checkpoint_id) 
        references checkpoint;

    alter table users_checkpoint 
        add constraint FK_2nw3e5rex5t96a130r3h01lc5 
        foreign key (users_id) 
        references users;

    create sequence hibernate_sequence minvalue 100;
