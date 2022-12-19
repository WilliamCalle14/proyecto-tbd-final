-- bitacora 1

create table bitacora_conductor (
	CI_CONDUCTOR int (11) not null,
    NRO_LICENCIA int (11) not null,
    CATEGORIA_LICENCIA char (10) not null,
    NOMBRE_CONDUCTOR char (40) not null,
    TELEFONO_CONDUCTOR char (40) not null,
    DIRECCION_CONDUCTOR char (40) not null,
    ESTADO_CONDUCTOR char (40) not null,
    FECHA_VENCIMIENTO_LICENCIA date,
    FECHA_NACIMIENTO date,
    USUARIO varchar (80),
    FECHA datetime
);

create trigger insert_conductor
after insert on conductor
for each row
	insert into bitacora_conductor
    (CI_CONDUCTOR, NRO_LICENCIA, CATEGORIA_LICENCIA, NOMBRE_CONDUCTOR, TELEFONO_CONDUCTOR, DIRECCION_CONDUCTOR, ESTADO_CONDUCTOR, FECHA_VENCIMIENTO_LICENCIA, FECHA_NACIMIENTO, USUARIO, FECHA)
    values
    (new.CI_CONDUCTOR, new.NRO_LICENCIA, new.CATEGORIA_LICENCIA, new.NOMBRE_CONDUCTOR, new.TELEFONO_CONDUCTOR, new.DIRECCION_CONDUCTOR, new.ESTADO_CONDUCTOR, new.FECHA_VENCIMIENTO_LICENCIA, new.FECHA_NACIMIENTO, current_user(), now());
    
create table bitacora_datos_antiguos_conductor (
	CI_CONDUCTOR int not null,
    OLD_NRO_LICENCIA int not null,
    OLD_CATEGORIA_LICENCIA char (10) not null,
    OLD_NOMBRE_CONDUCTOR char (40) not null,
    OLD_TELEFONO_CONDUCTOR char (40) not null,
    OLD_DIRECCION_CONDUCTOR char (40) not null,
    OLD_ESTADO_CONDUCTOR char (40) not null,
    OLD_FECHA_VENCIMIENTO_LICENCIA date,
    OLD_FECHA_NACIMIENTO date
);

create trigger update_conductor
after update on conductor
for each row
	insert into bitacora_datos_antiguos_conductor
    set
	CI_CONDUCTOR = old.CI_CONDUCTOR,
    OLD_NRO_LICENCIA = old.NRO_LICENCIA, 
    OLD_CATEGORIA_LICENCIA = old.CATEGORIA_LICENCIA,
    OLD_NOMBRE_CONDUCTOR = old.NOMBRE_CONDUCTOR,
    OLD_TELEFONO_CONDUCTOR = old.TELEFONO_CONDUCTOR,
    OLD_DIRECCION_CONDUCTOR = old.DIRECCION_CONDUCTOR,
    OLD_ESTADO_CONDUCTOR = old.ESTADO_CONDUCTOR,
    OLD_FECHA_VENCIMIENTO_LICENCIA = old.FECHA_VENCIMIENTO_LICENCIA,
    OLD_FECHA_NACIMIENTO = old.FECHA_NACIMIENTO;

-- bitacora 2
create table bitacora_vehiculo (
	PLACA varchar (11) not null,
    NUEVA_PLACA varchar (15) not null,
    MODELO char (50) not null,
    ESTADO char (40) not null,
    NUEVO_ESTADO char (40) not null,
    MARCA char (40) not null,
    TIPO char (40) not null,
    USUARIO varchar (50),
    FECHA_REGISTRO datetime,
    DESCRIPCION varchar (50)
);

create trigger insert_vehiculo
after insert on vehiculo
for each row
insert into bitacora_vehiculo
(PLACA, NUEVA_PLACA, MODELO, ESTADO, NUEVO_ESTADO, MARCA, TIPO, USUARIO, FECHA_REGISTRO, DESCRIPCION)
values
(new.PLACA, new.PLACA, new.MODELO, new.ESTADO, new.ESTADO, new.MARCA, new.TIPO, current_user(), now(), 'DATO INSERTADO');

