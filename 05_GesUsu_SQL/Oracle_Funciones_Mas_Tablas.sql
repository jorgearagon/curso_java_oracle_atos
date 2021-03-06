CREATE TABLE DEPARTAMENTO (
	ID		NUMBER(10) NOT NULL,
	NOMBRE  VARCHAR2(100) NOT NULL,
	FECHA DATE NOT NULL
);

ALTER TABLE DEPARTAMENTO ADD(
	CONSTRAINT departamento_pk PRIMARY KEY(ID)
);
	
CREATE SEQUENCE departamento_seq START WITH 1;

CREATE OR REPLACE TRIGGER departamento_bir
	BEFORE INSERT ON DEPARTAMENTO
	FOR EACH ROW
	
	BEGIN
		SELECT departamento_seq.NEXTVAL
		INTO :new.id
		FROM dual;
	END;
	
INSERT INTO DEPARTAMENTO(NOMBRE, FECHA) VALUES ('Programacion', SYSDATE);
INSERT INTO DEPARTAMENTO(NOMBRE, FECHA) VALUES ('Diseño', '1/2/2019');
INSERT INTO DEPARTAMENTO(NOMBRE, FECHA) VALUES ('Marketing', '5/1/2019');
INSERT INTO DEPARTAMENTO(NOMBRE, FECHA) VALUES ('Direccion', '20/1/2019');

ALTER TABLE USUARIO ADD DEPART_PRINCIPAL NUMBER(10) DEFAULT 1 NOT NULL;

UPDATE USUARIO SET DEPART_PRINCIPAL = ROUND(dbms_random.value(1,4));

SELECT * FROM USUARIO JOIN DEPARTAMENTO
	ON USUARIO.DEPART_PRINCIPAL = DEPARTAMENTO.id;
	
SELECT * FROM USUARIO U JOIN DEPARTAMENTO D
	ON U.DEPART_PRINCIPAL = D.id 
	WHERE D.NOMBRE = 'Programacion';
	
ALTER TABLE USUARIO DROP COLUMN DEPART_PRINCIPAL;
CREATE TABLE USU_DEPT(
	ID_USU NUMBER(10) NOT NULL,
	ID_DEPT NUMBER(10) NOT NULL
);
ALTER TABLE USU_DEPT
	ADD CONSTRAINT FK_USU_DEPT_usu
	FOREIGN KEY (ID_USU) REFERENCES USUARIO(ID);
	
ALTER TABLE USU_DEPT
	ADD CONSTRAINT FK_USU_DEPT_departamento
	FOREIGN KEY (ID_DEPT) REFERENCES DEPARTAMENTO(ID);
	
ALTER TABLE USU_DEPT ADD(
	CONSTRAINT a_dept_usu_pk PRIMARY KEY(ID_USU,ID_DEPT)
);
	
INSERT INTO USU_DEPT(ID_USU, ID_DEPT) 
	VALUES (ROUND(dbms_random.value(1,(SELECT COUNT(*) FROM USUARIO))),
	ROUND(dbms_random.value(1,4)));
	
SELECT U.NOMBRE, D.NOMBRE FROM USUARIO U
	JOIN USU_DEPT UD ON U.ID = UD.ID_USU
	JOIN DEPARTAMENTO D ON UD.ID_DEPT = D.ID
		WHERE D.NOMBRE='Programacion';
	
	