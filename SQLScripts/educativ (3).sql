Drop
DATABASE if exists educativ;
CREATE
DATABASE if not exists educativ;
use
educativ;
create table curso
(
    id_curso int auto_increment
        primary key,
    nombre varchar(45) null
);

create table asignatura
(
    nombre varchar(100) null,
    id_asignatura int auto_increment
        primary key,
    id_curso int null,
    constraint asignatura_curso_id_curso_fk
        foreign key (id_curso) references curso (id_curso)
);

create table examenes
(
    id_examen int auto_increment
        primary key,
    fecha_Examen date null,
    id_nota int null,
    puntos double default 10 null
);

create table login
(
    id_login int auto_increment
        primary key,
    nombre_usuario varchar(45) null,
    contraseña varchar(45) null,
    seguridad int null,
    tipo_usuario varchar(45) null,
    id_aj int null,
    nombre varchar(100) null
);

create table alumno
(
    id_alumno int auto_increment
        primary key,
    DNI varchar(45) null,
    fecha_nacimiento date null,
    nombre varchar(100) null,
    id_login int null,
    constraint alumnos_login_id_login_fk
        foreign key (id_login) references login (id_login)
);

create table alumnos_curso
(
    id_alumno int null,
    id_curso int null,
    id int auto_increment
        primary key,
    constraint alumnos_curso_alumnos_id_alumnos_fk
        foreign key (id_alumno) references alumno (id_alumno),
    constraint alumnos_curso_curso_id_curso_fk
        foreign key (id_curso) references curso (id_curso)
);

create table asistencia
(
    id_asistencia int auto_increment
        primary key,
    id_alumno int null,
    asiste tinyint(1) null,
    id_asignatura int null,
    dia_semana varchar(45) null,
    fecha varchar(45) null,
    constraint asistencia_alumnos_id_alumnos_fk
        foreign key (id_alumno) references alumno (id_alumno),
    constraint asistencia_asignatura_id_asignatura_fk
        foreign key (id_asignatura) references asignatura (id_asignatura)
);

create table jefedeestudios
(
    id_jefedeestudios int auto_increment
        primary key,
    DNI varchar(45) null,
    nombre varchar(100) null,
    telefono int null,
    direccion varchar(45) null,
    fechaNac date null,
    correo varchar(45) null,
    id_login int null,
    constraint jefedeestudios_login_id_login_fk
        foreign key (id_login) references login (id_login)
);

create table notas
(
    id_boletin int auto_increment
        primary key,
    notas int null,
    Observaciones varchar(45) null,
    Documentacion_centro varchar(45) null,
    id_asignaturas int null,
    id_alumno int null,
    constraint notas_alumnos_id_alumno_fk
        foreign key (id_alumno) references alumno (id_alumno),
    constraint notas_asignatura_id_asignatura_fk
        foreign key (id_asignaturas) references asignatura (id_asignatura)
);

create table padres
(
    id_padres int auto_increment
        primary key,
    nombre varchar(45) null,
    DNi varchar(45) null,
    telefono int null,
    email varchar(45) null,
    estado_civil varchar(45) null,
    fecha_nacimiento date null,
    direccion varchar(45) null,
    Documentos_bancarios varchar(45) null,
    id_alumno int null,
    id_login int null,
    constraint padres_alumnos_id_alumno_fk
        foreign key (id_alumno) references alumno (id_alumno),
    constraint padres_login_id_login_fk
        foreign key (id_login) references login (id_login)
);

create table profesor
(
    id_profesor int auto_increment
        primary key,
    DNI varchar(45) null,
    nombre varchar(100) null,
    telefono int null,
    direccion varchar(45) null,
    fecha_Nac date null,
    correo varchar(45) null,
    id_usuario int null,
    constraint profesor_login_id_login_fk
        foreign key (id_usuario) references login (id_login)
);

create table clase
(
    id_clase int auto_increment
        primary key,
    id_asignatura int null,
    id_profesor int null,
    fecha datetime null,
    constraint clase_asignaturas_id_asignatura_fk
        foreign key (id_asignatura) references asignatura (id_asignatura),
    constraint clase_profesor_id_profesor_fk
        foreign key (id_profesor) references profesor (id_profesor)
);

create table horario
(
    id_horario int auto_increment
        primary key,
    id_asignatura int null,
    id_profesor int null,
    hora_inicio time null,
    hora_fin time null,
    dia_semana int null,
    constraint horario_asignatura_id_asignatura_fk
        foreign key (id_asignatura) references asignatura (id_asignatura),
    constraint horario_profesor_id_profesor_fk
        foreign key (id_profesor) references profesor (id_profesor)
);

create table profesor_asignatura
(
    id_profesor int null,
    id_asignatura int null,
    id int auto_increment
        primary key,
    constraint profesor_asignatura_asignatura_id_asignatura_fk
        foreign key (id_asignatura) references asignatura (id_asignatura),
    constraint profesor_asignatura_profesor_id_profesor_fk
        foreign key (id_profesor) references profesor (id_profesor)
);

create table reuniones
(
    id_reuniones int auto_increment
        primary key,
    lugar varchar(45) null,
    fecha date null,
    curso varchar(45) null
);

create definer = root@localhost view alumno_cursos as
select `a`.`nombre` AS `Alumnos`, `c`.`nombre` AS `curso`
from ((`educativ`.`alumnos_curso` left join `educativ`.`curso` `c` on ((`c`.`id_curso` = `educativ`.`alumnos_curso`.`id_curso`)))
         left join `educativ`.`alumno` `a` on ((`a`.`id_alumno` = `educativ`.`alumnos_curso`.`id_alumno`)));

create definer = root@localhost view alumnos_asignatura as
select `educativ`.`alumno`.`nombre`    AS `nombre`,
       `educativ`.`alumno`.`id_alumno` AS `id_alumno`,
       `a`.`nombre`                    AS `nombreAsignatura`,
       `a`.`id_asignatura`             AS `id_asignatura`
from ((`educativ`.`alumno` left join `educativ`.`alumnos_curso` `ac` on ((`educativ`.`alumno`.`id_alumno` = `ac`.`id_alumno`)))
         left join `educativ`.`asignatura` `a` on ((`ac`.`id_curso` = `a`.`id_curso`)));

create definer = root@localhost view asignatura_asistencia as
select `a2`.`nombre`                        AS `nombre`,
       `educativ`.`asistencia`.`asiste`     AS `asiste`,
       `educativ`.`asistencia`.`dia_semana` AS `dia_semana`,
       `a`.`nombre`                         AS `asignaturanombre`,
       `educativ`.`asistencia`.`fecha`      AS `fecha`
from ((`educativ`.`asistencia` left join `educativ`.`asignatura` `a` on ((`educativ`.`asistencia`.`id_asignatura` = `a`.`id_asignatura`)))
         left join `educativ`.`alumno` `a2` on ((`a2`.`id_alumno` = `educativ`.`asistencia`.`id_alumno`)));

create definer = root@localhost view asignatura_profesor as
select `educativ`.`asignatura`.`id_asignatura` AS `id_asignatura`,
       `educativ`.`asignatura`.`nombre`        AS `nombreAsig`,
       `c`.`id_profesor`                       AS `id_profesor`,
       `p`.`nombre`                            AS `nombre`
from (((`educativ`.`asignatura` left join `educativ`.`clase` `c` on ((`educativ`.`asignatura`.`id_asignatura` = `c`.`id_asignatura`))) left join `educativ`.`profesor_asignatura` `pa` on ((`educativ`.`asignatura`.`id_asignatura` = `pa`.`id_asignatura`)))
         left join `educativ`.`profesor` `p` on ((`c`.`id_profesor` = `p`.`id_profesor`)));



INSERT INTO educativ.login (id_login, nombre_usuario, contraseña, seguridad, tipo_usuario, id_aj, nombre) VALUES (1, 'Sblanquer', '1234', 8, 'Alumno', null, 'Salvador Blanquer');
INSERT INTO educativ.login (id_login, nombre_usuario, contraseña, seguridad, tipo_usuario, id_aj, nombre) VALUES (2, 'Iajenjo', '2345', 8, 'Profesor', null, 'Ivan Ajenjo');
INSERT INTO educativ.login (id_login, nombre_usuario, contraseña, seguridad, tipo_usuario, id_aj, nombre) VALUES (5, 'Fmiralles', '0000', null, 'Profesor', null, 'Fernando Miralles');
INSERT INTO educativ.login (id_login, nombre_usuario, contraseña, seguridad, tipo_usuario, id_aj, nombre) VALUES (6, 'Nsenent', '1111', null, 'Jefedeestudios', null, 'Neus Senent');
INSERT INTO educativ.login (id_login, nombre_usuario, contraseña, seguridad, tipo_usuario, id_aj, nombre) VALUES (7, 'Cvicente', '12', null, 'Director', null, 'Cristina Vicente');
INSERT INTO educativ.login (id_login, nombre_usuario, contraseña, seguridad, tipo_usuario, id_aj, nombre) VALUES (8, 'Pescobar', '11', null, 'Padres', null, 'Pablo Escobar');

INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (3, '12345678A', '2010-04-29', 'Salvador Blanquer', 1);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (4, '88888888Z', '1999-12-15', 'Lucia Calabrese', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (5, '87654321B', '2015-11-18', 'Pedro Sanchez', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (6, '65412321M', '1986-04-05', 'Angel Beltran', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (7, '52155621N', '1995-04-07', 'Lucas gonsalvo', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (8, '55864512P', '2004-11-18', 'Javier Ruiz Perez', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (9, '56231428O', '1999-05-05', 'Nicolas Bustos', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (10, '12369854B', '1994-04-07', 'Sergio Lorente', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (11, '55287951P', '2014-04-04', 'Antonio Castillo', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (12, '65212536B', '2000-09-17', 'Carmen Marti', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (14, '11234356N', '1998-03-03', 'Juana de Arco', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (15, '12345467N', '1998-04-04', 'Lucas Pan', null);
INSERT INTO educativ.alumno (id_alumno, DNI, fecha_nacimiento, nombre, id_login) VALUES (16, '12345678N', '1990-03-04', 'Juan Cruz', null);

INSERT INTO educativ.curso (id_curso, nombre) VALUES (1, 'Dam');
INSERT INTO educativ.curso (id_curso, nombre) VALUES (2, 'Mip');
INSERT INTO educativ.curso (id_curso, nombre) VALUES (3, 'CIN');

INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (3, 1, 1);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (4, 1, 2);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (5, 2, 3);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (6, 2, 4);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (7, 2, 5);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (8, 1, 6);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (9, 1, 7);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (10, 2, 8);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (11, 1, 9);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (12, 1, 10);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (15, 3, 11);
INSERT INTO educativ.alumnos_curso (id_alumno, id_curso, id) VALUES (16, 1, 12);


INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Programación', 3, 1);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Marketing', 4, 2);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Bases de Datos', 5, 1);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Entornos de desarrollo', 6, 1);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Ingles Tecnico', 7, 1);

INSERT INTO educativ.profesor (id_profesor, DNI, nombre, telefono, direccion, fecha_Nac, correo, id_usuario) VALUES (2, '00000000C', 'Ivan Ajenjo', 666666666, 'Calle Colon 1', '1997-09-30', 'i@i.com', 2);
INSERT INTO educativ.profesor (id_profesor, DNI, nombre, telefono, direccion, fecha_Nac, correo, id_usuario) VALUES (3, '11111111M', 'Fernando Miralles', 654654654, 'Calle Xativa 4', '2006-04-26', 'f@f.com', 5);
INSERT INTO educativ.profesor (id_profesor, DNI, nombre, telefono, direccion, fecha_Nac, correo, id_usuario) VALUES (4, '22222222N', 'Laura Trillo', 111111111, 'Calle pepe 5', '1987-04-24', 'l@l.com', null);

INSERT INTO educativ.clase (id_clase, id_asignatura, id_profesor, fecha) VALUES (1, 3, 2, '2021-04-23 08:15:00');
INSERT INTO educativ.clase (id_clase, id_asignatura, id_profesor, fecha) VALUES (2, 4, 3, '2021-04-29 09:45:38');
INSERT INTO educativ.clase (id_clase, id_asignatura, id_profesor, fecha) VALUES (3, 6, 4, '2021-04-26 11:30:00');
INSERT INTO educativ.clase (id_clase, id_asignatura, id_profesor, fecha) VALUES (4, 5, 2, '2021-04-30 10:53:42');

INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (3, 3, 2, '08:15:00', '11:00:00', 1);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (8, 6, null, '11:30:00', '14:15:00', 1);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (9, 7, null, '08:15:00', '09:10:00', 2);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (10, 8, null, '09:10:00', '10:05:00', 2);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (11, 9, null, '10:05:00', '11:00:00', 2);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (12, 9, null, '11:30:00', '14:15:00', 2);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (13, 10, null, '08:15:00', '11:00:00', 3);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (16, 8, null, '11:30:00', '13:20:00', 3);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (17, 7, null, '13:20:00', '14:15:00', 3);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (4, 3, 2, '11:30:00', '14:15:00', 4);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (5, 5, 2, '08:15:00', '11:30:00', 4);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (6, 3, 2, '09:10:00', '11:00:00', 5);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (7, 5, 2, '11:30:00', '13:20:00', 5);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (14, 9, null, '08:15:00', '09:10:00', 5);
INSERT INTO educativ.horario (id_horario, id_asignatura, id_profesor, hora_inicio, hora_fin, dia_semana) VALUES (15, 7, null, '13:20:00', '14:15:00', 5);


INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Programación', 3, 1);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Marketing digital', 4, 2);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Bases de Datos', 5, 1);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Entornos de desarrollo', 6, 1);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Ingles Tecnico', 7, 1);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Fol', 8, 1);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Sistemas', 9, 1);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Lenguaje de marcas', 10, 1);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Gestion economica y financiera de la empresa', 13, 3);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Gestion administrativa del comercio internacional', 14, 3);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Logica del almacenamiento', 15, 3);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Transporte internacional de mercancias', 16, 3);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Ingles', 17, 3);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('FOL', 18, 3);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Ingles tecnico', 19, 3);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Gestion economica y financiera de la empresa', 20, 2);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Politicas de marketing', 21, 2);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Investigacion comercial', 22, 2);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Ingles', 23, 2);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Fol', 24, 2);
INSERT INTO educativ.asignatura (nombre, id_asignatura, id_curso) VALUES ('Ingles Tecnico', 25, 2);

INSERT INTO educativ.jefedeestudios (id_jefedeestudios, DNI, nombre, telefono, direccion, fechaNac, correo, id_login) VALUES (1, '00000000M', 'Neus Senent', 698574236, null, null, null, null);

INSERT INTO educativ.padres (id_padres, nombre, DNi, telefono, email, estado_civil, fecha_nacimiento, direccion, Documentos_bancarios, id_alumno, id_login) VALUES (1, 'Pablo Escobar', null, null, null, null, null, null, null, 3, 8);