SELECT Nombre,edad,fecha_registro FROM USUARIO ORDER BY fecha_registro;
SELECT Nombre,edad,fecha_registro FROM USUARIO ORDER BY edad DESC;
SELECT Nombre,edad,fecha_registro FROM USUARIO ORDER BY Nombre;

SELECT Nombre,edad,fecha_registro 
	FROM USUARIO WHERE edad < 35 and fecha_registro < '10/10/19';
	
SELECT SUM(nota) FROM USUARIO;
SELECT AVG(nota) FROM USUARIO;
SELECT MAX(nota) FROM USUARIO;

SELECT Nombre FROM USUARIO WHERE Nombre LIKE '%aa%';
SELECT COUNT(Nombre) FROM USUARIO WHERE Nombre LIKE '%aa%';

SELECT edad, count(*) FROM USUARIO GROUP BY edad;

/* Que devuelva el usuario con menor nota de los aprobados */

SELECT min(nota) FROM usuario where nota >=5;
--Para que funcione bien seria asi:--
SELECT * FROM USUARIO WHERE nota = (SELECT min(nota) FROM usuario where nota >=5);
SELECT * FROM USUARIO WHERE ROWNUM <= 5;--ESTO ES COMO EL LIMIT EN MYSQL--
/*Que nos devuelva la diferencia con respecto a la media de los usuario suspendido*/
select Nombre, nota, (nota - (SELECT avg(nota) FROM usuario)) from usuario where nota <=5;