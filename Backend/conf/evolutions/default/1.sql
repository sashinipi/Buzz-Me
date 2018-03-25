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


# --- !Downs

drop table if exists buzz_me.passenger;

