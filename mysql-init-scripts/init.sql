CREATE DATABASE IF NOT EXISTS mydatabase;
USE mydatabase;

CREATE TABLE IF NOT EXISTS user_table (
    id SERIAL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    dni VARCHAR(255) NOT NULL UNIQUE,
    sexo VARCHAR(50),
    birth_date VARCHAR(50),
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(50),
    status BIT(1) NOT NULL DEFAULT 1
);

-- Datos dummy
INSERT INTO user_table (name, last_name, dni, sexo, birth_date, email, phone, status) VALUES
('Sam', 'Perez', '12345678A', 'Masculino', '1990-01-15', 'tovar.samuel@gmail.com', '123456789', 1),
('Ana', 'Gomez', '87654321B', 'Femenino', '1992-05-20', 'ana.gomez@example.com', '987654321', 0),
('Carlos', 'Lopez', '11223344C', 'Masculino', '1988-11-30', 'carlos.lopez@example.com', '555112233', 0);