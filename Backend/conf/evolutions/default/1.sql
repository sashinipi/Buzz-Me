# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table buzz_me.driver (
  driver_id                     integer auto_increment not null,
  driver_name                   varchar(255) not null,
  driver_nic                    varchar(255) not null,
  driver_address                varchar(255) not null,
  driver_password               varchar(255) not null,
  time_stamp                    datetime(6) not null,
  constraint pk_driver primary key (driver_id)
);

create table buzz_me.owner (
  owner_id                      integer auto_increment not null,
  owner_name                    varchar(255) not null,
  owner_contact_number          integer not null,
  password                      varchar(255) not null,
  registration_number           varchar(255) not null,
  time_stamp                    datetime(6) not null,
  constraint pk_owner primary key (owner_id)
);

create table buzz_me.passenger (
  passenger_id                  integer auto_increment not null,
  passenger_name                varchar(255) not null,
  passenger_contact_number      integer not null,
  password                      varchar(255) not null,
  time_stamp                    datetime(6) not null,
  constraint pk_passenger primary key (passenger_id)
);

create table buzz_me.rating (
  rating_id                     integer auto_increment not null,
  rating                        integer not null,
  bus_id                        integer not null,
  count                         integer not null,
  time_stamp                    datetime(6) not null,
  constraint pk_rating primary key (rating_id)
);

create table buzz_me.ride (
  ride_id                       integer auto_increment not null,
  bus_id                        integer not null,
  people_counter                integer not null,
  current_location              varchar(255) not null,
  current_speed                 varchar(255) not null,
  time_stamp                    datetime(6) not null,
  constraint pk_ride primary key (ride_id)
);


# --- !Downs

drop table if exists buzz_me.driver;

drop table if exists buzz_me.owner;

drop table if exists buzz_me.passenger;

drop table if exists buzz_me.rating;

drop table if exists buzz_me.ride;

