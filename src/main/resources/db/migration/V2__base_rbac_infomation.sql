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
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/trace',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/configprops',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/mappings',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/liquibase',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/info',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/metrics',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/env',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/beans',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/dump',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/health',1);

INSERT INTO rbac_permission(ps_id, commonts, create_date, creator, isvalid, ps_description, ps_group, ps_name, ps_type, ps_url, role_id)
VALUES (1,'trace',NOW(),'admin','1','trace','Metrics','trace','1','/autoconfig',1);
        