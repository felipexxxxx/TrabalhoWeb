CREATE TABLE IF NOT EXISTS Reserva (
            ID_reserva INT AUTO_INCREMENT NOT NULL,
            ID_cliente INT NOT NULL,
            ID_passeio INT NOT NULL,
            valor_total DECIMAL(10,2) NOT NULL,
            data DATETIME NOT NULL,
            status_reserva ENUM('PENDENTE','CONFIRMADO', 'CANCELADO') DEFAULT'PENDENTE' NOT NULL ,
            PRIMARY KEY (ID_reserva, ID_cliente),
            FOREIGN KEY (ID_cliente) REFERENCES usuario (id),
            FOREIGN KEY (ID_passeio) REFERENCES passeio (id)
);

