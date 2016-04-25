
--LINEAS Y PLANES
--LINEAS
INSERT INTO `LineaCredito` (`id`,`admite_embargo`,`antiguedadLaboral_min`,`edad_max`,`edad_min`,`estrategiaAntiguedad`,`estrategiaBcra`,`estrategiaEdad`,`estrategiaEmbargo`,`estrategiaScore`,`estrategiaSueldo`,`estrategiaTipoEmpleo`,`nombre`,`score`,`situacionBCRA`,`sueldo_min`,`tipoEmpleo`) VALUES (34,0,0,79,73,1,1,1,1,1,1,1,'Linea IPS 3',400,'MALA',1000,'PUBLICO');
INSERT INTO `LineaCredito` (`id`,`admite_embargo`,`antiguedadLaboral_min`,`edad_max`,`edad_min`,`estrategiaAntiguedad`,`estrategiaBcra`,`estrategiaEdad`,`estrategiaEmbargo`,`estrategiaScore`,`estrategiaSueldo`,`estrategiaTipoEmpleo`,`nombre`,`score`,`situacionBCRA`,`sueldo_min`,`tipoEmpleo`) VALUES (33,0,0,79,73,1,1,1,1,1,1,1,'Linea IPS 2',1,'BUENA',1000,'PUBLICO');
INSERT INTO `LineaCredito` (`id`,`admite_embargo`,`antiguedadLaboral_min`,`edad_max`,`edad_min`,`estrategiaAntiguedad`,`estrategiaBcra`,`estrategiaEdad`,`estrategiaEmbargo`,`estrategiaScore`,`estrategiaSueldo`,`estrategiaTipoEmpleo`,`nombre`,`score`,`situacionBCRA`,`sueldo_min`,`tipoEmpleo`) VALUES (30,0,0,79,73,1,1,1,1,1,1,1,'Linea IPS 1',1,'REGULAR',1000,'PUBLICO');
INSERT INTO `LineaCredito` (`id`,`admite_embargo`,`antiguedadLaboral_min`,`edad_max`,`edad_min`,`estrategiaAntiguedad`,`estrategiaBcra`,`estrategiaEdad`,`estrategiaEmbargo`,`estrategiaScore`,`estrategiaSueldo`,`estrategiaTipoEmpleo`,`nombre`,`score`,`situacionBCRA`,`sueldo_min`,`tipoEmpleo`) VALUES (29,0,9,74,21,1,1,1,1,1,1,1,'Full',700,'MALA',1100,'PRIVADO');
INSERT INTO `LineaCredito` (`id`,`admite_embargo`,`antiguedadLaboral_min`,`edad_max`,`edad_min`,`estrategiaAntiguedad`,`estrategiaBcra`,`estrategiaEdad`,`estrategiaEmbargo`,`estrategiaScore`,`estrategiaSueldo`,`estrategiaTipoEmpleo`,`nombre`,`score`,`situacionBCRA`,`sueldo_min`,`tipoEmpleo`) VALUES (24,0,12,79,18,1,1,1,1,1,1,1,'Linea 3',400,'BUENA',1000,'PUBLICO');
INSERT INTO `LineaCredito` (`id`,`admite_embargo`,`antiguedadLaboral_min`,`edad_max`,`edad_min`,`estrategiaAntiguedad`,`estrategiaBcra`,`estrategiaEdad`,`estrategiaEmbargo`,`estrategiaScore`,`estrategiaSueldo`,`estrategiaTipoEmpleo`,`nombre`,`score`,`situacionBCRA`,`sueldo_min`,`tipoEmpleo`) VALUES (25,0,12,79,18,1,1,1,1,1,1,1,'Linea 2',1,'BUENA',1000,'PUBLICO');
INSERT INTO `LineaCredito` (`id`,`admite_embargo`,`antiguedadLaboral_min`,`edad_max`,`edad_min`,`estrategiaAntiguedad`,`estrategiaBcra`,`estrategiaEdad`,`estrategiaEmbargo`,`estrategiaScore`,`estrategiaSueldo`,`estrategiaTipoEmpleo`,`nombre`,`score`,`situacionBCRA`,`sueldo_min`,`tipoEmpleo`) VALUES (26,0,12,79,18,1,1,1,1,1,1,1,'Linea 1',0,'REGULAR',1000,'PUBLICO');
INSERT INTO `LineaCredito` (`id`,`admite_embargo`,`antiguedadLaboral_min`,`edad_max`,`edad_min`,`estrategiaAntiguedad`,`estrategiaBcra`,`estrategiaEdad`,`estrategiaEmbargo`,`estrategiaScore`,`estrategiaSueldo`,`estrategiaTipoEmpleo`,`nombre`,`score`,`situacionBCRA`,`sueldo_min`,`tipoEmpleo`) VALUES (27,0,9,74,21,1,1,1,1,1,1,1,'Basica',400,'MALA',1100,'PRIVADO');

--PLANES
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (1,24,NULL,2000,2,1,66,26);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (2,36,' ',8000,3,1,100,23);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (3,24,NULL,6000,2,1,100,23);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (4,12,NULL,4000,1,1,100,23);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (5,24,NULL,4000,2,1,100,27);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (6,12,NULL,2000,1,1,100,27);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (7,36,NULL,8000,3,1,66,24);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (8,24,NULL,6000,2,1,66,24);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (9,12,NULL,3000,1,1,100,24);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (10,9,NULL,1000,1,1,66,26);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (11,24,NULL,3000,3,1,66,26);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (12,24,NULL,5000,4,1,66,26);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (13,9,NULL,2000,1,1,66,25);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (14,24,NULL,4000,2,1,66,25);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (15,36,NULL,5000,3,1,66,25);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (16,36,NULL,8000,4,1,66,25);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (17,36,NULL,10000,4,1,66,24);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (18,36,NULL,5000,3,1,100,27);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (19,36,NULL,8000,4,1,100,27);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (20,36,NULL,10000,4,1,100,23);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (21,33,NULL,3333,2,1,33,NULL);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (22,12,NULL,4000,1,1,100,29);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (23,24,NULL,6000,2,1,100,29);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (24,36,NULL,8000,3,1,100,29);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (25,36,NULL,10000,4,1,100,29);
INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (27,6,NULL,1000,1,0,100,30);


--MANTIENE LOS COMPONENTES (PANTALLAS EN PRINCIPIO) A LAS CUALES SE PUEDEN ACCEDER
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (1, 'Pantalla de creación y edición de perfiles','PERFILES');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (2, 'Pantalla de depósitos','DEPOSITOS');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (3, 'Listado de petición de créditos','PETICION_CREDITO');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (4, 'Pantalla de creación y edición de Líneas de crédito','ABM_LINEA_CREDITO');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (5, 'Pantalla cálculo de líneas de crédito','CALCULO_SOLICITUD_CREDITOS');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (6, 'Pantalla de creación y edición de usuarios','ALTA_EDICION_USUARIO');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (7, 'Listado de usuarios','LISTADO_USUARIOS');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (8, 'Pantalla solicitud de financiacion de deuda','SOLICITUD_FINANCIACION_CREDITO');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (9, 'Pantalla de Búsqueda de clientes','BUSQUEDA_CLIENTES ');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (10, 'Pantalla de solicitud de refinanciación de crédito','SOLICITUD_REFINANCIACION_CREDITO');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (11, 'Pantalla para la solicitud de Crédito Paralelo','SOLICITUD_PARALELO_CREDITO');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (12, 'Pantalla para la creación y edición de clientes','ALTA_EDICION_CLIENTE');
insert into ComponenteDePantalla (id, descripcion,  nombre) values (13, 'Pantalla para filtro y listado bancario','LISTADO_BANCARIO');
insert into ComponenteDePantalla (id, descripcion,  nombre) values (14, 'Pantalla agendar llamadas para call center','AGENDAR_LLAMADA_CALLCENTER');


--CREA LOS PERFILES NECESARIOS
INSERT INTO `Perfil` (`id`,`descripcion`,`nombre`,`listacomponentes`) VALUES (1,'Son aquellos que tienen acceso a las pantallas ADMINISTRADOR','ADMINISTRADOR','1,2,3,4,5,6,7,8,9,10,11,12,13,14,15');
INSERT INTO `Perfil` (`id`,`descripcion`,`nombre`,`listacomponentes`) VALUES (2,'Son aquellos que tienen acceso a las pantallas de ventas de créditos','VENTAS','5,8,9');
INSERT INTO `Perfil` (`id`,`descripcion`,`nombre`,`listacomponentes`) VALUES (3,'Son aquellos que tienen acceso a las pantallas de call center','CALLCENTER','5,8,11');

--SUCURSALES
INSERT INTO `Sucursal` (`id`,`nombre`) VALUES (1,'La Plata Central');
INSERT INTO `Sucursal` (`id`,`nombre`) VALUES (2,'Plaza Italia');
INSERT INTO `Sucursal` (`id`,`nombre`) VALUES (3,'Quilmes');
INSERT INTO `Sucursal` (`id`,`nombre`) VALUES (4,'Mar del Plata');
INSERT INTO `Sucursal` (`id`,`nombre`) VALUES (5,'Lomas de Zamora');
INSERT INTO `Sucursal` (`id`,`nombre`) VALUES (6,'Necochea');


INSERT INTO `Usuario` (`id`,`admin`,`apellido`,`nombre`,`nombreUsuario`,`password`,`supervisor`,`sucursal_id`,`borrado`,`perfil_id`) VALUES (1,0,'cortazar','julio','julio.cortazar','f4eb27cea7255cea4d1ffabf593372e8',1,1,0,1);
INSERT INTO `Usuario` (`id`,`admin`,`apellido`,`nombre`,`nombreUsuario`,`password`,`supervisor`,`sucursal_id`,`borrado`,`perfil_id`) VALUES (2,0,'borges','jorge','jorge.borges','f4eb27cea7255cea4d1ffabf593372e8',0,3,0,2);


--BANCO
insert into Banco (id, nombre, codigo) values (1, "Bapro", "BAPRO");
insert into Banco (id, nombre, codigo) values (2, "Banco Frances", "FRANCES");


--CORRECCIONES EN CUOTA
--USE cristal_desa;
--update `Cuota` set estado = 'IMPAGA' where id < 100 && ESTADO = 'ACTIVA';
--update Cliente set banco_id = 1;

--20120217
update `cristal`.`Cliente` set banco_id = 1 where banco_id is Null and id < 1000;

--20120223 mmanto data para reparticiones
use cristal_test;
insert into Reparticion (descripcion, nombre, numeroReparticion) values ("descripcion1", "Reparticion1", 1);
insert into Reparticion (descripcion, nombre, numeroReparticion) values ("descripcion2", "Reparticion2", 2);
insert into Reparticion (descripcion, nombre, numeroReparticion) values ("descripcion3", "Reparticion3", 3);
insert into Reparticion (descripcion, nombre, numeroReparticion) values ("descripcion4", "Reparticion4", 4);
insert into Provincia (codigo,nombre) values (1, "Buenos Aires");
insert Localidad (nombre,codigo,provincia_id) values ("La Plata",1,1);
insert Localidad (nombre,codigo,provincia_id) values ("Ensenada",1,1);
update Cliente set localidad_id = 1 where id = 92;



UPDATE Cliente SET ESTADO = "ACTIVO" WHERE ESTADO IS NULL;

--insert into ComponenteDePantalla (id, descripcion idPerfil, nombre) values (13, "Pantalla para filtro y listado bancario",null,"LISTADO_BANCARIO");

--UPDATE cristal_desa.Perfil SET listacomponentes=1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16 WHERE id=1;


update `cristal_desa`.`SolicitudAprobacionCredito` set sucursal = "La Plata Central" where sucursal is null;

--20120314 Agrego componente Pago Cuota
--insert into ComponenteDePantalla (id, descripcion, idPerfil, nombre) values (14, "Pantalla para el pago de cuotas",null,"PAGO_CUOTAS");

--mmanto
-- modifico el nombe de la empresa por Cooperativa Cristal
--UPDATE cristal_desa.Empresa SET nombre= "Cooperativa Cristal"  WHERE id=2; ESTO NO VA, PORQUE NO SE ASOCIARÁ MÁS CON EL NOMBRE DE LA EMPRESA, SINO CON EL ID

update Credito set empresa_id = 2 where empresa_id is null;
update SolicitudAprobacionCredito set empresa_id = 2 where empresa_id is null;



--20120323 Agrego componente Asignar Llamada
--insert into ComponenteDePantalla (id, descripcion, idPerfil, nombre) values (15, "Pantalla para la asignación de llamadas en call center",null,"ASIGNACION_LLAMADA");

alter table SolicitudAprobacionCredito drop column empresa



--insert que setean los templates y directorios de cobranzas. 
--Tambien crear en el root context del server los directorios:
--/COBRANZAS/REPORTES/ Y /COBRANZAS/TEMPLATES_COBRANZAS/ Y /COBRANZAS/
--Poner dentro de TEMPLATE_COBRANZAS LOS REMPLATES DE MOROSOS_2 Y PREJUDICIAL PARA LAS DOS EMPRESAS Y 
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`) values('1','COBRANZAS','MOROSO_2','Nombre del template usado en cobranzas para  la notificacion de morosos 2','2','UAD_COOP_CRISTAL','UAD_COOP_CRISTAL.odt','/REPORTES/','/TEMPLATES_COBRANZAS/','\0');
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`) values('2','COBRANZAS','PREJUDICIAL','Nombre del template usado en cobranzas para  la notificacion prejudicial','2','PREJU_COOP_CRISTAL','PREJU_COOP_CRISTAL.odt','/REPORTES/','/TEMPLATES_COBRANZAS/','\0');
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`) values('3','COBRANZAS','RECIBODEPAGO','El recibo de pago de muchas cuotas juntas sumarizados los totaltes','1','ReciboLaLuisinaReporte','ReciboLaLuisina.odt','/COBRANZAS/','/TEMPLATES_COBRANZAS/','\0');
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`) values('4','COBRANZAS','RECIBODEPAGO','El recibo de pago de muchas cuotas juntas sumarizados los totaltes','2','ReciboCristalReporte','ReciboCristal.odt','/COBRANZAS/','/TEMPLATES_COBRANZAS/','\0');
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`) values('5','COBRANZAS','PREJUDICIAL','Nombre del template usado en cobranzas para nofit prejudiciales','1','PREJU_LA_LUISINA','PREJU_LA_LUISINA.odt','/REPORTES/','/TEMPLATES_COBRANZAS/','\0');
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`) values('6','COBRANZAS','MOROSO_2','El template para moroso 2 ','1','UAD_LA_LUISINA','UAD_LA_LUISINA.odt','/REPORTES/','/TEMPLATES_COBRANZAS/','\0');


--EMPRESAS
insert into `Empresa` (`id`, `cuil`, `nombre`) values('1','29-33737373737-0','La Luisina SRL');
insert into `Empresa` (`id`, `cuil`, `nombre`) values('2','30709041009','Cooperativa Cristal');


-- REPORTES COBRANZAS(MOROSOS2 PREJUDICIAL) - IMPRESION DE PAGO DE CUOTAS.
--Tambien crear en el server que corre el glassfish los directoros y darle permisos de lectura y escritura a todos:
--sudo su root
--mkdir /opt/COBRANZAS/REPORTES
--mkdir /opt/COBRANZAS/TEMPLATES_COBRANZAS
--mkdir /opt/COBRANZAS/RECIBOS_DE_PAGOS/
--chmod -R 777 /opt/COBRANZAS
--copiar dentro de TEMPLATES_COBRANZAS todos los templates de cobranzas.

insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`, `realPathDocumentos`, `contextRootName`) values('1','COBRANZAS','MOROSO_2','Nombre del template usado en cobranzas para  la notificacion de morosos 2','2','UAD_COOP_CRISTAL','UAD_COOP_CRISTAL.odt','/REPORTES/','/TEMPLATES_COBRANZAS/','\0','/opt/COBRANZAS','/cristalTest/');
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`, `realPathDocumentos`, `contextRootName`) values('2','COBRANZAS','PREJUDICIAL','Nombre del template usado en cobranzas para  la notificacion prejudicial','2','PREJU_COOP_CRISTAL','PREJU_COOP_CRISTAL.odt','/REPORTES/','/TEMPLATES_COBRANZAS/','\0','/opt/COBRANZAS','/cristalTest/');
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`, `realPathDocumentos`, `contextRootName`) values('3','COBRANZAS','RECIBODEPAGO','El recibo de pago de muchas cuotas juntas sumarizados los totaltes','1','ReciboLaLuisinaReporte','ReciboLaLuisina.odt','/RECIBOS_DE_PAGOS/','/TEMPLATES_COBRANZAS/','\0','/opt/COBRANZAS','/cristalTest/');
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`, `realPathDocumentos`, `contextRootName`) values('4','COBRANZAS','RECIBODEPAGO','El recibo de pago de muchas cuotas juntas sumarizados los totaltes','2','ReciboCristalReporte','ReciboCristal.odt','/RECIBOS_DE_PAGOS/','/TEMPLATES_COBRANZAS/','\0','/opt/COBRANZAS','/cristalTest/');
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`, `realPathDocumentos`, `contextRootName`) values('5','COBRANZAS','PREJUDICIAL','Nombre del template usado en cobranzas para nofit prejudiciales','1','PREJU_LA_LUISINA','PREJU_LA_LUISINA.odt','/REPORTES/','/TEMPLATES_COBRANZAS/','\0','/opt/COBRANZAS','/cristalTest/');
insert into `DatosTemplate` (`id`, `codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`, `permiteMultipleEnvio`, `realPathDocumentos`, `contextRootName`) values('6','COBRANZAS','MOROSO_2','El template para moroso 2 ','1','UAD_LA_LUISINA','UAD_LA_LUISINA.odt','/REPORTES/','/TEMPLATES_COBRANZAS/','\0','/opt/COBRANZAS','/cristalTest/');



--TABLAS:
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('1','aux','morosos 2 area de cobranzas','Morosos_2','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('2','aux..','instancia prejudicial','Prejudicial','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('3','aux','morosos 2 area de cobranzas','Morosos_2','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('4','aux..','instancia prejudicial','Prejudicial','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('5','aux','morosos 2 area de cobranzas','Morosos_2','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('6','aux..','instancia prejudicial','Prejudicial','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('7','aux','morosos 2 area de cobranzas','Morosos_2','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('8','aux..','instancia prejudicial','Prejudicial','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('9','aux','morosos 2 area de cobranzas','Morosos_2','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('10','aux..','instancia prejudicial','Prejudicial','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('11','aux','morosos 2 area de cobranzas','Morosos_2','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('12','aux..','instancia prejudicial','Prejudicial','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('13','aux','morosos 2 area de cobranzas','Morosos_2','COBRANZAS',NULL);
insert into `Tablas` (`id`, `aux_1`, `descripcion`, `nombre`, `tipo`, `codigo`) values('14','aux..','instancia prejudicial','Prejudicial','COBRANZAS',NULL);






--20120323 Agrego componente Asignar Llamada
--insert into ComponenteDePantalla (id, descripcion, idPerfil, nombre) values (15, "Pantalla para la asignación de llamadas en call center",null,"ASIGNAR_LLAMADAS");

ALTER TABLE `cristal_desa`.`Tablas` DROP COLUMN `aux_1` ;

alter table SolicitudAprobacionCredito drop column empresa
alter table SolicitudAprobacionCredito drop column empresa


--20120329 Agrego componente Asignar Llamada
insert into ComponenteDePantalla (id, descripcion, idPerfil, nombre) values (16, "Pantalla para el seguimiento de llamadas de un cliente",null,"SEGUIMIENTO");
INSERT INTO `Perfil` (`id`,`descripcion`,`nombre`,`listacomponentes`) VALUES (3,'Son aquellos que tienen acceso a las pantallas de call center','CALLCENTER','5,8,11,15,12,9,16');



--20120404 Se incorporan componente y perfil para la pantalla de reporte de efectividad
INSERT INTO cristal_desa.ComponenteDePantalla (descripcion,  nombre) values ('Pantalla para reporte de efectividad','REPORTE_EFECTIVIDAD'); 
UPDATE `cristal_desa`.`Perfil` SET `listacomponentes`='5,8,11,15,12,9,18' WHERE `id`='3';

INSERT INTO `cristal_desa`.`Tablas` (`codigo`, `descripcion`, `nombre`, `tipo`, `aux1`) VALUES ('MOROSO_1', 'resultado predefinido de moroso 1 en callcenter', 'resultado predefinido de moroso 1 en callcenter', 'EFECTIVIDAD_CALLCENTER_MOROSO1', '');
INSERT INTO `cristal_desa`.`Tablas` (`codigo`, `descripcion`, `nombre`, `tipo`) VALUES ('MOROSO_2', 'resultado predefinido de moroso 2 en callcenter', 'resultado predefinido de moroso 2 en callcenter', 'EFECTIVIDAD_CALLCENTER_MOROSO2');
INSERT INTO `cristal_desa`.`Tablas` (`codigo`, `descripcion`, `nombre`, `tipo`) VALUES ('RECUPEROS_', 'call center asignación de llamadas', 'Recupero', '');



--------------------------------------------------------------------------------------------------------------------------------
-- SPRINT 5 SPRINT 5SPRINT 5SPRINT 5SPRINT 5SPRINT 5 SPRINT 5 SPRINT 5 SPRINT 5 SPRINT 5 SPRINT 5 SPRINT 5 SPRINT 5

--09042012 
UPDATE `cristal_desa`.`Tablas` SET `nombre`='Moroso 1' WHERE `id`='39';
UPDATE `cristal_desa`.`Tablas` SET `nombre`='Moroso 2' WHERE `id`='40';

ALTER TABLE `cristal_desa`.`Llamado` ADD COLUMN `LlamadoExitoso` BIT(1) NULL  AFTER `cantidadLlamadas` ;
update cristal_desa.Llamado set LlamadoExitoso = 0;
UPDATE `cristal_test`.`Tablas` SET `nombre`='Moroso 1' WHERE `id`='37';
UPDATE `cristal_test`.`Tablas` SET `nombre`='Moroso  2' WHERE `id`='38';

UPDATE `cristal_test`.`Tablas` SET `nombre`='Morososidad', `tipo`='EFECTIVIDAD_CALLCENTER_MOROSO' WHERE `id`='37';
UPDATE `cristal_test`.`Tablas` SET `nombre`='Colocación', `tipo`='EFECTIVIDAD_CALLCENTER_COLOCACION', `codigo`='COLOCACION' WHERE `id`='38';
INSERT INTO `cristal_test`.`Tablas` (`descripcion`, `nombre`, `tipo`, `codigo`) VALUES ('resultado predefinido para prejudicial CallCenter', 'Prejudicial', 'EFECTIVIDAD_CALLCENTER_PREJUDICIAL', 'PREJUDICIAL');
INSERT INTO `cristal_desa`.`DatosTemplate` (`codigoArea`, `codigoReporte`, `descripcion`, `nombreSalida`, `pathDestino`, `realPathDocumentos`, `contextRootName`) VALUES ('COBRANZAS', 'EFECTIVIDAD', 'Estadistica de efectividad por operador', 'REPORTE_EFECTIVIDAD', '/REPORTES/EFECTIVIDAD/', '/opt/COBRANZAS', '/cristalTest/');
UPDATE `cristal_desa`.`DatosTemplate` SET `permiteMultipleEnvio`=0 WHERE `id`='8';
UPDATE `cristal_desa`.`DatosTemplate` SET `nombreTemplate`='REPORTE_EFECTIVIDAD' WHERE `id`='8';

-- datos provisorios para abogados
insert into cristal_desa.Abogado set nombre='Abogado1';
insert into cristal_desa.Abogado set nombre='Abogado2';
insert into cristal_desa.Abogado set nombre='Abogado3';
insert into cristal_desa.Abogado set nombre='Abogado4';



insert into cristal_desa.Juzgado (descripcion, nombre, numero) values ("Dscripcion 1", "Juzgado1", "1");
insert into cristal_desa.Juzgado (descripcion, nombre, numero) values ("Dscripcion 2", "Juzgado2", "2");
insert into cristal_desa.Juzgado (descripcion, nombre, numero) values ("Dscripcion 3", "Juzgado3", "3");
insert into cristal_desa.Juzgado (descripcion, nombre, numero) values ("Dscripcion 4", "Juzgado4", "4");

/* ya no son validos 24/10/20125
insert into cristal_desa.TipoDocumentoLegal (nombre) values ("Demanda");
insert into cristal_desa.TipoDocumentoLegal (nombre) values ("Planilla de Inicio");
insert into cristal_desa.TipoDocumentoLegal (nombre) values ("Oficio de Apertura");
insert into cristal_desa.TipoDocumentoLegal (nombre) values ("Mandamiento");
insert into cristal_desa.TipoDocumentoLegal (nombre) values ("Oficio de Embargo");
insert into cristal_desa.TipoDocumentoLegal (nombre) values ("Oficio de Reiteratorio");
insert into cristal_desa.TipoDocumentoLegal (nombre) values ("Oficio de Ampliatorio");
*/


UPDATE `cristal_desa`.`DatosTemplate` SET `codigoArea`='LEGALES', `codigoReporte`='LEGALESC', `descripcion`='Reporte para legales generales', `idEmpresa`=1, `nombreSalida`='ReporteLegales', `nombreTemplate`='ReporteLegales', `pathDestino`='/REPORTE/LEGALES', `pathOrigen`='/TEMPLATES_LEGAES', `permiteMultipleEnvio`=0 WHERE `id`='9';
UPDATE `cristal_desa`.`DatosTemplate` SET `pathOrigen`='/TEMPLATES_COBRANZAS/' WHERE `id`='6';

INSERT INTO `cristal_desa`.`DatosTemplate` (`codigoArea`, `codigoReporte`, `descripcion`, `idEmpresa`, `nombreSalida`, `nombreTemplate`, `pathDestino`, `pathOrigen`) VALUES ('LEGALES', 'LEGALES', 'Reporte documentos legales ', 0, 'REPORTE_LEGALES_X:JUZGADO', 'REPORTE_LEGALES_X_JUZGADO.jrxml', '/REPORTES/LEGALES/', '/TEMPLATES_LEGALES/');

UPDATE `cristal_desa`.`DatosTemplate` SET `nombreSalida`='REPORTE_LEGALES_X_JUZGADO' WHERE `id`='12';
UPDATE `cristal_desa`.`Cliente` SET `nroCuenta`=11111111111 WHERE `id`='92';
UPDATE `cristal_desa`.`DatosTemplate` SET `contextRootName`='/COBRANZAS/' WHERE `id`='12';

-- IMPORTANTE CUANDO SE HAGA PRÓXIMO DEPLOY EN VIEW
-- EN LA TABLA LLAMADO, CAMBIAR EL TIPO DE DATOS LlamadoExistoso deberá ser INT(11) , 



------------------------
SPRINT 6
--24/04/2012 daniel.madera corrí el siguiente script en todos los ambientes. Se deberá corregir el código para evitar este tipo de problemas
--update `cristal`.`Cliente` set localidad_id = 1 where  localidad_id is null ;
--update `cristal`.`Cliente` set reparticion_id = 10 where  reparticion_id is null ;
--update `cristal`.`Cliente` set banco_id = 1 where  banco_id is null ;
--insert into cristal.ComponenteDePantalla (id, descripcion, nombre) values (26, "Pantalla creación de Comercializadores y administración de gastos","COMERCIALIZADORES_GASTOS");
--commit;

--
--insert into cristal.ComponenteDePantalla (id, descripcion, nombre) values (27, "Liquidacion mensual de ventas de comercializadores","LIQUIDACION_COMERCIALIZADORES");
--insert into cristal.ComponenteDePantalla (id, descripcion, nombre) values (28, "Convenio Extrajudicial","CONVENIO_EXTRAJUDICIAL");
--insert into cristal.ComponenteDePantalla (id, descripcion, nombre) values (29, "Pantalla para el otorgamiento de Bonificaciones y Reintegros","BONIFICACION_REINTEGRO");

-- 08/205/2012
--insert into ComponenteDePantalla (id, descripcion,  nombre) values (30, 'Pantalla ABM de Giros','PANTALLA_GIROS');

-- 09/205/2012
insert into cristal_desa.TipoReporte (descripcion,nombre) values ('Descripcion del tipo de reporte 1', 'TipoReporte1');
insert into cristal_desa.TipoReporte (descripcion,nombre) values ('Descripcion del tipo de reporte 2', 'Incobrables');
insert into cristal_desa.TipoReporte (descripcion,nombre) values ('Descripcion del tipo de reporte 3', 'Cuota Social');

INSERT INTO `cristal_desa`.`DatosTemplate` (`codigoArea`, `codigoReporte`, `contextRootDirFullpath`, `descripcion`, `directorioDestino`, `directorioOrigen`, `extencionDefault`, `idEmpresa`, `nombreArchivoSalida`, `nombreTemplate`) VALUES ('COBRANZAS', 'INCOBRABLES', '/home/glassfish3/glassfish/domains/domain1/applications', 'Reporte incobrables', '/cristalDesa/COBRANZAS/REPORTES/INCOBRABLES/', '/opt', 'xls', 0, 'incobrables', 'incobrables.jasper');
ALTER TABLE `cristal_desa`.`TipoReporte` ADD COLUMN `codigoReporte` VARCHAR(45) NULL  AFTER `nombre` ;
UPDATE `cristal_desa`.`TipoReporte` SET `codigoReporte`='CUOTA_SOCIAL' WHERE `id`='7';
UPDATE `cristal_desa`.`TipoReporte` SET `codigoReporte`='INCOBRABLES' WHERE `id`='6';

UPDATE `cristal_desa`.`DatosTemplate` SET `pathBasicoDocumentos`='/COBRANZAS/' WHERE `id`='15';
INSERT INTO `cristal_desa`.`DatosTemplate` (`codigoArea`, `codigoReporte`, `descripcion`, `directorioDestino`, `directorioOrigen`, `extencionDefault`, `idEmpresa`, `nombreArchivoSalida`, `nombreTemplate`, `pathBasicoDocumentos`) VALUES ('COBRANZAS', 'CREDITOS_OTORGADOS', 'Créditos otorgados por período', '/cristalDesa/COBRANZAS/REPORTES/CREDITOS_OTORGADOS/', '/opt', 'xls', 0, 'creditosOtorgados', 'creditosOtorgados.jasper', '/COBRANZAS/');
UPDATE `cristal_desa`.`DatosTemplate` SET `descripcion`='Reporte incobrables por período' WHERE `id`='15';
UPDATE `cristal_desa`.`TipoReporte` SET `nombre`='Creditos Otorgados', `codigoReporte`='CREDITOS_OTORGADOS' WHERE `id`='5';
UPDATE `cristal_desa`.`DatosTemplate` SET `contextRootDirFullpath`='/home/glassfish3/glassfish/domains/domain1/applications' WHERE `id`='16';
INSERT INTO `cristal_desa`.`TipoReporte` (`descripcion`, `nombre`, `codigoReporte`) VALUES ('Envío a BAPRO por rango', 'Envío a BAPRO', 'ENVIO_BAPRO');
UPDATE `cristal_desa`.`TipoReporte` SET `descripcion`='Creditos Otorgados por rango' WHERE `id`='5';
UPDATE `cristal_desa`.`TipoReporte` SET `descripcion`='Incobrables por rango' WHERE `id`='6';
UPDATE `cristal_desa`.`TipoReporte` SET `descripcion`='Cuota social por rango' WHERE `id`='7';
INSERT INTO `cristal_desa`.`TipoReporte` (`descripcion`, `nombre`, `codigoReporte`) VALUES ('Cuotas mensuales por rango', 'Cuotas Mensuales', 'CUOTAS_MENSUALES');
INSERT INTO `cristal_desa`.`TipoReporte` (`descripcion`, `nombre`, `codigoReporte`) VALUES ('Total créditos pendientes', 'Créditos Pendientes', 'CREDITOS_PENDIENTES');

INSERT INTO `cristal_desa`.`DatosTemplate` (`codigoArea`, `codigoReporte`, `contextRootDirFullpath`, `descripcion`, `directorioDestino`, `directorioOrigen`, `extencionDefault`, `idEmpresa`, `nombreArchivoSalida`, `nombreTemplate`, `pathBasicoDocumentos`) VALUES ('COBRANZAS', 'CUOTAS_MENSUALES', '/home/glassfish3/glassfish/domains/domain1/applications', 'Cuotas mensuales por período', '/cristalDesa/COBRANZAS/REPORTES/CUOTAS_MENSUALES/', '/opt', 'xls', 0, 'cuotasMensuales', 'cuotasMensaules.jasper', '/COBRANZAS/');
INSERT INTO `cristal_desa`.`DatosTemplate` (`codigoArea`, `codigoReporte`, `contextRootDirFullpath`, `descripcion`, `directorioDestino`, `directorioOrigen`, `extencionDefault`, `idEmpresa`, `nombreArchivoSalida`, `nombreTemplate`, `pathBasicoDocumentos`) VALUES ('COBRANZAS', 'ENVIO_BAPRO', '/home/glassfish3/glassfish/domains/domain1/applications', 'Envío a bapro por período', '/cristalDesa/COBRANZAS/REPORTES/ENVIO_BAPRO/', '/opt', 'xls', 0, 'envioBAPRO', 'envioBapro.jasper', '/COBRANZAS/');
INSERT INTO `cristal_desa`.`DatosTemplate` (`codigoArea`, `codigoReporte`, `contextRootDirFullpath`, `descripcion`, `directorioDestino`, `directorioOrigen`, `extencionDefault`, `idEmpresa`, `nombreArchivoSalida`, `nombreTemplate`, `pathBasicoDocumentos`) VALUES ('COBRANZAS', 'CREDITOS_PENDIENTES', '/home/glassfish3/glassfish/domains/domain1/applications', 'Creditos pendientes por período', '/cristalDesa/COBRANZAS/REPORTES/CREDITOS_PENDIENTES/', '/opt', 'xls', 0, 'creditosPendientes', 'creditosPendientes.jasper', '/COBRANZAS/');
--insert into ComponenteDePantalla (id, descripcion,  nombre) values (30, 'Pantalla ABM de Giros','PANTALLA_GIROS');


--10/05/2012 Corrido solo en desa
update `cristal_desa`.`Credito` set tipoCredito = 'PERSONAL' where montoFinal > 2000;
update `cristal_desa`.`Credito` set tipoCredito = 'VIVIENDA' where montoFinal <= 2000;



insert into cristal.Perfil (`descripcion`,`nombre`, listacomponentes ) values ('Usuarios con perfil de comercializador', 'COMERCIALIZADOR', '5,8,9,3,1,11,12,10,25,16')

--No corresponde correrlo en todos los ambientes
UPDATE `cristal_desa`.`DatosTemplate` SET `nombreArchivoSalida`='resumenEnvioBapro', `nombreTemplate`='resumenEnvioBapro.jasper' WHERE `id`='18';
UPDATE `cristal_desa`.`Aux_disco` SET `montoCuota`=670, `montoCuotaSocial`=25 WHERE `id`='1165';
UPDATE `cristal_desa`.`Aux_disco` SET `montoCuota`=670, `montoCuotaSocial`=25 WHERE `id`='1166';
UPDATE `cristal_desa`.`Aux_disco` SET `montoCuota`=670, `montoCuotaSocial`=25 WHERE `id`='1167';
UPDATE `cristal_desa`.`Aux_disco` SET `montoCuotaSocial`=25 WHERE `id`='1145';
UPDATE `cristal_desa`.`Aux_disco` SET `montoCuotaSocial`=25 WHERE `id`='1144';
UPDATE `cristal_desa`.`Aux_disco` SET `montoCuota`=440, `montoCuotaSocial`=25 WHERE `id`='1153';
UPDATE `cristal_desa`.`Aux_disco` SET `montoCuota`=440 WHERE `id`='1149';
UPDATE `cristal_desa`.`Aux_disco` SET `montoCuota`=570, `montoCuotaSocial`=25 WHERE `id`='1169';
UPDATE `cristal_desa`.`Aux_disco` SET `montoCuota`=570, `montoCuotaSocial`=25 WHERE `id`='1168';

UPDATE `cristal_desa`.`Aux_disco` SET `punitorioCuota_id`=951 WHERE `id`='1167';
UPDATE `cristal_desa`.`Aux_disco` SET `punitorioCuota_id`=951 WHERE `id`='1166';




ALTER TABLE cristal_test.Cuota
ADD CONSTRAINT uc_cuotasId UNIQUE (nroCuota,credito_id);


--No es necesario si se corrió el migrador de datos
UPDATE cristal_migra.Banco set codigo = 'OTRO' where nombre not in ('BAPRO','Frances');

--No es necesario si se corrió el migrador de datos
update cristal_migra.SolicitudAprobacionCredito set tipoSolicitud = "ORIGINAL" WHERE tipoSolicitud = "Renovación";
update cristal_migra.SolicitudAprobacionCredito set tipoSolicitud = "PARALELO" WHERE tipoSolicitud = "Paralelo";
update cristal_migra.SolicitudAprobacionCredito set tipoSolicitud = "REFINANCIACION" WHERE tipoSolicitud = "Refinanciación";
update cristal_migra.SolicitudAprobacionCredito set tipoSolicitud = "FINANCIACION" WHERE tipoSolicitud = "Financiación de Deuda";
update cristal_migra.SolicitudAprobacionCredito set tipoSolicitud = "ANTICIPO_SUELDO" WHERE tipoSolicitud = "Anticipo Sueldo";
update cristal_migra.SolicitudAprobacionCredito set tipoSolicitud = "OTRO" WHERE tipoSolicitud IS null;


INSERT INTO `cristal_desa`.`TipoReporte` (`descripcion`, `nombre`, `codigoReporte`) VALUES ('Total deuda prejudiciales', 'Prejudiciales', 'PREJUDICIAL');
UPDATE `cristal_desa`.`DatosTemplate` SET `nombreArchivoSalida`='Prejudiciales', `pathBasicoDocumentos`='/COBRANZAS/' WHERE `id`='20';
UPDATE `cristal_desa`.`TipoReporte` SET `codigoReporte`='PREJUDICIAL' WHERE `id`='11';
update cristal_migra.SolicitudAprobacionCredito set tipoSolicitud = "OTRO" WHERE tipoSolicitud IS null;


--Marisa 17/05/2012

insert into ComponenteDePantalla values(31,'ComponenteDePantalla','ComponenteDePantalla');







INSERT INTO `cristal_migra`.`Abogado`(id,`nombre`,`descripcion`)VALUES(1, "Abogado Migración","Abogado Migración");
INSERT INTO `cristal_migra`.`Abogado`(id, `nombre`,`descripcion`)VALUES(2, "Daniel M. Liguori","inscripto al Tomo LIV, Folio 141 del C.A.L.P.,Legajo Previsional Nº 3-23599624-1 del C.A.L.P., CUIT e Ingresos Brutos Nº 20-23599624-4,Responsable Monotributista");
INSERT INTO `cristal_migra`.`Abogado`(id,`nombre`,`descripcion`)VALUES(3, "Silvia Soledad Sosa","inscripta al Tomo LV, Folio 300 del C.A.L.P., CUIT e Ingresos Brutos Nº 27-28-366671-4, Responsable Monotributista");

 

INSERT INTO `cristal_migra`.`Juzgado`(id, `descripcion`,`nombre`,`numero`)VALUES(1, "Juzgado0","Juzgado0",0);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(2,"Juzgado1","Juzgado1",1);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(3,"Juzgado2","Juzgado2",2);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(4,"Juzgado4","Juzgado4",4);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(5,"Juzgado5","Juzgado5",5);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(6,"Juzgado6","Juzgado6",6);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(7,"Juzgado7","Juzgado7",7);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(8,"Juzgado8","Juzgado8",8);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(9,"Juzgado9","Juzgado9",9);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(10,"Juzgado10","Juzgado10",10);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(11,"Juzgado11","Juzgado11",11);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(12,"Juzgado12","Juzgado12",12);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(13,"Juzgado13","Juzgado13",13);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(14,"Juzgado14","Juzgado14",14);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(16,"Juzgado16","Juzgado16",16);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(17,"Juzgado17","Juzgado17",17);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(18,"Juzgado18","Juzgado18",18);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(19,"Juzgado19","Juzgado19",19);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(20,"Juzgado20","Juzgado20",20);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(21,"Juzgado21","Juzgado21",21);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(22,"Juzgado22","Juzgado22",22);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(23,"Juzgado23","Juzgado23",23);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(25,"Juzgado25","Juzgado25",25);
INSERT INTO `cristal_migra`.`Juzgado`(`descripcion`,`nombre`,`numero`)VALUES(27,"Juzgado27","Juzgado27",27);



--Marisa 21/05/2012
insert into  ComponenteDePantalla values (32,'ABM Localidades','ABM_LOCALIDAD');


INSERT INTO Tablas (id,codigo,descripcion,nombre,tipo,aux1) VALUES (63,'COLOCACION','call center asignación de llamadas telemarketing/colocacion','Colocación','CALLCENTER_ASIGNACION_LLAMADA',NULL);
INSERT INTO Tablas (id,codigo,descripcion,nombre,tipo,aux1) VALUES (64,'OTROS','call center asignación de llamadas OTROS','Otros','CALLCENTER_ASIGNACION_LLAMADA',NULL);
INSERT INTO Tablas (id,codigo,descripcion,nombre,tipo,aux1) VALUES (65,'COBRANZAS_CONVENIOS','call center asignación de llamadas','Cobranzas Convenios','CALLCENTER_ASIGNACION_LLAMADA',NULL);
INSERT INTO Tablas (id,codigo,descripcion,nombre,tipo,aux1) VALUES (66,'RECORDATORIO_PAGO','call center asignación de llamadas','Recordatorio de Pago','CALLCENTER_ASIGNACION_LLAMADA',NULL);

/* -- cambiar el directorio destino según la ejecución del script -*/
INSERT INTO `cristal_desa`.`DatosTemplate` (id, `codigoArea`, `codigoReporte`, `contextRootDirFullpath`, `descripcion`, `directorioDestino`, `directorioOrigen`, `extencionDefault`, `idEmpresa`, `nombreArchivoSalida`, `nombreTemplate`, `pathBasicoDocumentos`) VALUES (21, 'COBRANZAS', 'PENDIENTE_DEPOSITO', '/home/glassfish3/glassfish/domains/domain1/applications', 'Reprote créditos pendiente de depósito', '/cristalDesa/COBRANZAS/REPORTES/PREJUDICIALES/', '/opt', 'xls', 0, 'CreditosPendienteDeposito', 'creditosPendienteDeDeposito.jasper', '/COBRANZAS/');
UPDATE `cristal_desa`.`DatosTemplate` SET `pathBasicoDocumentos`='/COBRANZAS/' WHERE `id`='20';



-- 24/10/2012 
insert into cristal.TipoDocumentoLegal (nombre) values('Acompania_reporte-Denuncia_Automotores_Solicita_Embargo_2012');
insert into cristal.TipoDocumentoLegal (nombre) values('adjunta_oficio');
insert into cristal.TipoDocumentoLegal (nombre) values('denuncio_nuevo_empleo');
insert into cristal.TipoDocumentoLegal (nombre) values('oficio_apertura_de_cuenta');
insert into cristal.TipoDocumentoLegal (nombre) values('manifiesta');
insert into cristal.TipoDocumentoLegal (nombre) values('denuncia_domicilio_solicita_MBR');
insert into cristal.TipoDocumentoLegal (nombre) values('apela');
insert into cristal.TipoDocumentoLegal (nombre) values('acompania_croquis-solicita_mandamiento');
insert into cristal.TipoDocumentoLegal (nombre) values('acompania_ius');



--update cristal.SolicitudAprobacionCredito set idPlanFinanciacionOptimo = 28 where fechaHoraSolicitud < '2012-05-29'
--INSERT INTO `LineaCredito` (`id`,`admite_embargo`,`antiguedadLaboral_min`,`edad_max`,`edad_min`,`estrategiaAntiguedad`,`estrategiaBcra`,`estrategiaEdad`,`estrategiaEmbargo`,`estrategiaScore`,`estrategiaSueldo`,`estrategiaTipoEmpleo`,`nombre`,`score`,`situacionBCRA`,`sueldo_min`,`tipoEmpleo`) VALUES (35,0,1200,99,99,1,1,1,1,1,1,1,'MIGRACION-NO USAR',10000,'BUENA',99999,'PRIVADO');
--INSERT INTO `PlanFinanciacion` (`id`,`cantidadCuotasMaximo`,`descripcion`,`montoMaximo`,`numeroCredito`,`permitePlanParalelo`,`porcentajeRefinanciacion`,`lineaCredPertenece_id`) VALUES (28,36,NULL,0,1,1,66,35);

--07/06/2012
ALTER TABLE Empresa  ADD COLUMN participacionDirecta DOUBLE NOT NULL DEFAULT 0;
ALTER TABLE Empresa  ADD COLUMN participacionIndirecta DOUBLE NOT NULL DEFAULT 0;

insert into  ComponenteDePantalla values (33,'Cambio de Password','USUARIO_CAMBIO_PASSWORD');

insert into  ComponenteDePantalla values (34,'ABM Empresas','ABM_EMPRESA');

insert into  ComponenteDePantalla values (35,'ABM Sucursal','ABM_SUCURSAL');
INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (36,'Reportes','REPORTES');

INSERT INTO `ComponenteDePantalla` (`id`,`descripcion`,`nombre`) VALUES (37,'Administración de discos, ENVIADO, ANULADO...','ADMINISTRACION_DISCOS');

