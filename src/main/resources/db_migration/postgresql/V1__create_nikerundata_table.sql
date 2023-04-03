set search_path = runningdata;
create sequence nikerun_id_seq start with 1 increment by 50;
create table nikerundata
(
    id                     bigint default nextval('nikerun_id_seq') not null,
    run_active_duration    integer                                  not null,
    run_average_heart_rate float(53),
    run_average_pace       float(53),
    run_end_time           bigint                                   not null,
    run_name               varchar(255),
    run_start_time         bigint                                   not null,
    run_total_calories     float(53),
    run_total_distance     float(53),
    run_total_steps        integer,
    primary key (id)
)
