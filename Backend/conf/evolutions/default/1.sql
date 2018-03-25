# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table buzz_me.passenger (
  passenger_id                  integer auto_increment not null,
  passenger_name                varchar(255) not null,
  passenger_contact_number      integer not null,
  password                      varchar(255) not null,
  time_stamp                    datetime(6) not null,
  constraint pk_passenger primary key (passenger_id)
);

create table buzz_me.driver (
  driver_id                     integer auto_increment not null,
  driver_name                   varchar(255) not null,
  driver_nic                    varchar(255) not null,
  driver_address                varchar(255) not null,
  driver_password               varchar(255) not null,
  time_stamp                    datetime(6) not null,
  constraint pk_driver primary key (driver_id)
);


# --- !Downs

drop table if exists buzz_me.driver;

drop table if exists buzz_me.passenger;

