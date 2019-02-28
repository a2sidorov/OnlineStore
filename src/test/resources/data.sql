
INSERT INTO users (user_id, email, active, password) VALUES (122, 'test@test.dev', 1, 'test');

INSERT INTO roles (role_id, name) VALUES (122, 'ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (122, 122);

