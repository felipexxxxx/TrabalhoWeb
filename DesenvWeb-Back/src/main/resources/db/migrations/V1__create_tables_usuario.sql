CREATE TABLE IF NOT EXISTS  Usuario(
            id INT AUTO_INCREMENT NOT NULL,
            nome VARCHAR(255) NOT NULL,
            email VARCHAR(255) NOT NULL UNIQUE,
            senha VARCHAR(255) NOT NULL,
            data_nascimento DATE NOT NULL,
            cpf VARCHAR(11) UNIQUE NOT NULL,
            tipo_usuario ENUM('CLIENTE','ADM') NOT NULL,
            PRIMARY KEY (id)
);

