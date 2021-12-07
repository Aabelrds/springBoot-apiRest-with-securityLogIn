INSERT INTO `usuarios` (user_name,password,enabled) VALUES('jose','$2a$10$HZNM0l8M70n1SK4OoZ2ebesOfeJtHIWDEfjmM8tRKb2G6zWG2pxlO',1);
INSERT INTO `usuarios` (user_name,password,enabled) VALUES('admin','$2a$10$k1H4nz0SaFvWwprAXGr1lufvRxzbdmwvBx1qSaI295HbCiHYi8l8a',1);

INSERT INTO `roles` (rol_name) VALUES('ROLE_USER');
INSERT INTO `roles` (rol_name) VALUES('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id,rol_id) VALUES(1,1);
INSERT INTO `usuarios_roles` (usuario_id,rol_id) VALUES(2,2);
INSERT INTO `usuarios_roles` (usuario_id,rol_id) VALUES(2,1);

