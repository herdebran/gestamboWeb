
--MANTIENE LOS COMPONENTES (PANTALLAS EN PRINCIPIO) A LAS CUALES SE PUEDEN ACCEDER
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`, `nombre`) VALUES ('1','Pantalla Seleccion de Establecimiento', 'ABM_SELECCION_ESTABLECIMIENTO');
INSERT INTO `cristal`.`ComponenteDePantalla` (`id`, `descripcion`, `nombre`) VALUES ('2', 'Pantalla ABM de Animales', 'ABM_ANIMALES');
INSERT INTO `cristal`.`ComponenteDePantalla` (`id`, `descripcion`, `nombre`) VALUES ('3', 'Pantalla Busqueda de Animales', 'BUSQUEDA_ANIMALES');
INSERT INTO `cristal`.`ComponenteDePantalla` (`id`, `descripcion`, `nombre`) VALUES ('4', 'Pantalla principal de Parte Diario', 'PARTE_DIARIO');

--CREA LOS PERFILES NECESARIOS
INSERT INTO `Perfil` (`id`,`descripcion`,`nombre`,`listacomponentes`) VALUES (1,'Son aquellos que tienen acceso a las pantallas ADMINISTRADOR','ADMINISTRADOR','1,2,3,4');
INSERT INTO `Perfil` (`id`, `descripcion`, `listacomponentes`, `nombre`) VALUES ('2', 'Perfil para usuario estándar', '1,2,3,4', 'USUARIO');

--TIPOS DE SERVICIO
INSERT INTO `cristal`.`TipoServicio` (`id`, `activo`, `descripcion`) VALUES ('1', 1, 'INSEMINACION ARTIFICIAL');
INSERT INTO `cristal`.`TipoServicio` (`id`, `activo`, `descripcion`) VALUES ('2', 1, 'NATURAL');
INSERT INTO `cristal`.`TipoServicio` (`id`, `activo`, `descripcion`) VALUES ('3', 1, 'A CAMPO');
INSERT INTO `cristal`.`TipoServicio` (`id`, `activo`, `descripcion`) VALUES ('4', 1, 'ROBO');
INSERT INTO `cristal`.`TipoServicio` (`id`, `activo`, `descripcion`) VALUES ('5', 1, 'IATF');

--TIPOS DE PARTO
INSERT INTO `cristal`.`TipoParto` (`id`, `activo`, `descripcion`) VALUES ('1', 1, 'NORMAL');
INSERT INTO `cristal`.`TipoParto` (`id`, `activo`, `descripcion`) VALUES ('2', 1, 'CESAREA');
INSERT INTO `cristal`.`TipoParto` (`id`, `activo`, `descripcion`) VALUES ('3', 1, 'ASISTIDO');
INSERT INTO `cristal`.`TipoParto` (`id`, `activo`, `descripcion`) VALUES ('4', 1, 'DISTOCICO');
INSERT INTO `cristal`.`TipoParto` (`id`, `activo`, `descripcion`) VALUES ('5', 1, 'ABORTO');
