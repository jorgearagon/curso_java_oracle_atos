CREATE TABLE USUARIO (
	ID		NUMBER(10) NOT NULL,
	NOMBRE  VARCHAR2(100) NOT NULL,
	EMAIL	VARCHAR2(255) NOT NULL,
	EDAD 	NUMBER(3,0) NOT NULL,
	PASSWORD VARCHAR2(50) NOT NULL
);
ALTER TABLE USUARIO ADD(
	CONSTRAINT l_dept_pk PRIMARY KEY(ID)
);
ALTER TABLE USUARIO ADD
	CONSTRAINT l_uq_usuario_email UNIQUE(EMAIL);
	
CREATE SEQUENCE l_dept_seq START WITH 1;

CREATE OR REPLACE TRIGGER l_dept_bir
	BEFORE INSERT ON USUARIO
	FOR EACH ROW
	
	BEGIN
		SELECT l_dept_seq.NEXTVAL
		INTO :new.id
		FROM dual;
	END;

INSERT INTO USUARIO(nombre,email,edad,password)
	VALUES('Aaaaa', 'aaaa@aaaa.com', 20, 'aaa');
INSERT INTO USUARIO(nombre,email,edad,password)
	VALUES('Bbbbb', 'bbbb@bbbb.com', 20, 'bbb');
INSERT INTO USUARIO(nombre,email,edad,password)
	VALUES('Ccccc', 'cccc@cccc.com', 20, 'ccc');
INSERT INTO USUARIO(nombre,email,edad,password)
	VALUES('Ddddd', 'dddd@dddd.com', 20, 'ddd');
INSERT INTO USUARIO(nombre,email,edad,password)
	VALUES('Eeeee', 'eeee@eeee.com', 20, 'eee');
INSERT INTO USUARIO(nombre,email,edad,password)
	VALUES('Fffff', 'ffff@ffff.com', 20, 'fff');
INSERT INTO USUARIO(nombre,email,edad,password)
	VALUES('Ggggg', 'gggg@gggg.com', 19, 'ggg');
INSERT INTO USUARIO(nombre,email,edad,password)
	VALUES('Hhhhh', 'hhhh@hhhh.com', 34, 'hhh');
INSERT INTO USUARIO(nombre,email,edad,password)
	VALUES('Iiiii', 'iiii@iiii.com', 45, 'iii');
	
ALTER TABLE USUARIO ADD apellidos VARCHAR2(50);
ALTER TABLE USUARIO ADD fecha_registro DATE;
ALTER TABLE USUARIO ADD descripcion VARCHAR2(100) DEFAULT 'Un vago como todos';

ALTER TABLE USUARIO DROP COLUMN fecha_registro;
ALTER TABLE USUARIO ADD fecha_registro DATE DEFAULT SYSDATE;

CREATE INDEX I_usuario_edad ON usuario(edad);
CREATE INDEX I_usuario_nota ON usuario(nota);
	
