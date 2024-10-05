/**
 * Author:  faustino
 * Created: 29/03/2024
 */
CREATE SCHEMA IF NOT EXISTS es;

create table es.catalog (
id varchar(255) primary key not null,
name varchar(255),
decription varchar(255),
type varchar(255));

INSERT INTO es.CATALOG VALUES('01', 'GUATEMALA', 'GUATEMALA', 'DEPARTAMENTO');
INSERT INTO ES.CATALOG VALUES('02', 'EL PROGRESO', 'GUATEMALA', 'DEPARTAMENTO');
INSERT INTO ES.CATALOG VALUES('03', 'SACATEPEQUEZ', 'GUATEMALA', 'DEPARTAMENTO');