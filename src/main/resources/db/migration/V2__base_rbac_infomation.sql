-- rbac_user
INSERT INTO demodb.rbac_user(user_id, create_date, creator, isvalid, activated, email, lang_key, real_name, tel, user_name, user_pwd)
VALUES (1,NOW(),'admin','1','1','1252833909@qq.com','CN','Josh long','18769776857','Josh','$2a$10$po6bHCXVxpgFjBqXTiNiBeOzbH.QDBd4YU9ZVyxFuA8nCVsYm6xlS');

-- rbac_role
INSERT INTO rbac_role(role_id, commonts, create_date, creator, isvalid, main_page, role_description, role_name, upper_role_id)
VALUES (1,'ADMIN',NOW(),'admin','1','/','admin','ADMIN','0');
 
-- rbac_user_role
INSERT INTO rbac_user_role(rid, create_date, creator, isvalid, role_id, user_id)
VALUES (1,NOW(),'admin','1',1,1);
        
-- rbac_permission
INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','3','/trace',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'configprops',NOW(),'admin','1','configprops','Metrics','configprops','3','/configprops',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'mappings',NOW(),'admin','1','mappings','Metrics','mappings','3','/mappings',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'liquibase',NOW(),'admin','1','liquibase','Metrics','liquibase','3','/liquibase',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'info',NOW(),'admin','1','info','Metrics','info','3','/info',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'metrics',NOW(),'admin','1','metrics','Metrics','metrics','3','/metrics',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'env',NOW(),'admin','1','env','Metrics','env','3','/env',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'beans',NOW(),'admin','1','beans','Metrics','beans','3','/beans',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'dump',NOW(),'admin','1','dump','Metrics','dump','3','/dump',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'health',NOW(),'admin','1','health','Metrics','health','3','/health',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'autoconfig',NOW(),'admin','1','autoconfig','Metrics','autoconfig','3','/autoconfig',1);
        