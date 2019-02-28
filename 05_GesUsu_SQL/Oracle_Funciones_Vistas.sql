CREATE VIEW Usuarios_Programadores
AS
	SELECT (u.nombre||' '||u.apellidos) as Nombre_apell,
			edad,email,fecha_registro
			FROM usuario u
			JOIN USU_DEPT UD ON U.id = UD.ID_USU
			JOIN departamento d ON UD.ID_DEPT = D.id
			WHERE d.nombre = 'Programacion';
			
/* Crear una vista que indique el numero de usuarios por departamento
	NOMBRE		CANTIDAD
	--------------------
	Programacion 5
	Diseño		 3
	Marketing	 2
	*/
CREATE VIEW Usuarios_Departamento
AS
	SELECT UD.ID_DEPT,d.nombre,COUNT(*) AS NUMERO_DE_USUARIOS FROM usuario u
			JOIN USU_DEPT UD ON U.id = UD.ID_USU
			JOIN departamento d ON UD.ID_DEPT = D.id
			GROUP BY UD.ID_DEPT,d.nombre
            ORDER BY UD.ID_DEPT;