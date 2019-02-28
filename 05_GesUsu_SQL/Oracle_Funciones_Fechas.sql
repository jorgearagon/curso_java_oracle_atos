UPDATE USUARIO
	SET fecha_registro = 
		add_months(fecha_registro,
			-1 + ROUND(dbms_random.value(1,11)));
		--PARA LOS MESES HACE FALTA EL AD MONTHS PARA LOS DIAS NO--	
UPDATE USUARIO
	SET fecha_registro = fecha_registro -27
			+ ROUND(dbms_random.value(1,20)));
			
SELECT Nombre, fecha_registro FROM usuario WHERE	
	fecha_registro BETWEEN '1/1/2019' AND '1/4/2019';
	
SELECT Nombre, fecha_registro, NEXT_DAY(fecha_registro, 'LUNES') FROM usuario;

SELECT current_date FROM DUAL;--FECHA ACTUAL--
SELECT current_timestamp FROM DUAL;--FECHA Y HORA ACTUAL COMPLETA--
SELECT SYSDATE FROM DUAL;--FECHA ACTUAL TAMBIEN--

SELECT TO_DATE('05-SEP-2018 10:33 AM', 'DD-MON-YYY HH:MI AM') FROM DUAL;

SELECT fecha_registro, to_char(fecha_registro) FROM USUARIO;