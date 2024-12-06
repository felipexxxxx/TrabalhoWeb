CREATE TABLE IF NOT EXISTS Passeio(
            id INT AUTO_INCREMENT NOT NULL,
            nome VARCHAR(255) NOT NULL,
            lugar VARCHAR(255) NOT NULL,
            descricao TEXT NOT NULL,
            data DATE NOT NULL,
            hora TIME NOT NULL,
            valor DECIMAL(10,2) NOT NULL,
            PRIMARY KEY (id)
);