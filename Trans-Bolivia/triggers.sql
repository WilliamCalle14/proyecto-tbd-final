-- deteccion de licencias por caducar
delimiter //
create trigger detectar_licencias_por_caducar
after insert on conductor
for each row
begin
	if datediff(new.FECHA_VENCIMIENTO_LICENCIA, date(now())) <= 25
    then
		insert into renovar_licencia
        (NOMBRE_CONDUCTOR, CATEGORIA_LICENCIA, FECHA_VENCIMIENTO_LICENCIA)
        values
        (new.NOMBRE_CONDUCTOR, new.CATEGORIA_LICENCIA, new.FECHA_VENCIMIENTO_LICENCIA);
	end if;
end;
//
delimiter ;

-- detectar conductores ocupados
delimiter //
create trigger control_asignacion
before insert on contrato
for each row
begin
	if (select count(contrato.CI_CONDUCTOR) 
			from contrato
            where contrato.FECHA_REG_CONTRATO = new.FECHA_REG_CONTRATO) > 0
	then
		signal sqlstate '45000'
			set message_text = 'El conductor no se puede aignar mas de una vez al día';
	end if;
end;
//
delimiter ;

-- verificar consistencia de datos
delimiter //
create trigger validacion
before insert on conductor
for each row
begin
	if (new.NOMBRE_CONDUCTOR regexp '[^a-zA-Z^ :space: ]')
    then
		signal sqlstate '45000' set message_text = '¡El nombre ingresado es invalido!';
	end if;
    if (new.FECHA_NACIMIENTO > '2001-01-01')
    then
		signal sqlstate '45000' set message_text = '¡El conductor NO es mayor de edad!';
	end if;
end;
//
delimiter ;
