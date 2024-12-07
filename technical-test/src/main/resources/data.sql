CREATE TABLE IF NOT EXISTS task(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    description VARCHAR(100),
    status INT
);

INSERT INTO task(title, description, status) VALUES ('correo electronico', 'Responder a correos urgentes.', 0);