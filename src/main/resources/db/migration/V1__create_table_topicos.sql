CREATE TABLE topicos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado_do_topico VARCHAR(50),
    autor VARCHAR(100),
    curso VARCHAR(100)
);
