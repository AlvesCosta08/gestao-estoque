-- Criar a tabela Tb_Categoria
CREATE TABLE Tb_Categoria (
    id_categoria SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Criar a tabela Tb_Produto
CREATE TABLE Tb_Produto (
    id_produto SERIAL PRIMARY KEY,
    referencia VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    unid_medida VARCHAR(10) CHECK (unid_medida IN ('pc', 'pco10x', 'pco100x', 'cx100x', 'cx50x')) NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL,
    foto_produto VARCHAR(255),
    qr_code VARCHAR(255),
    id_categoria INT,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_categoria) REFERENCES Tb_Categoria(id_categoria),
    INDEX idx_referencia (referencia),
    INDEX idx_descricao (descricao)
);

-- Criar a tabela Tb_Cliente
CREATE TABLE Tb_Cliente (
    id_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(150),
    endereco TEXT,
    cep VARCHAR(20),
    cidade VARCHAR(100),
    uf CHAR(2),
    telefone VARCHAR(20),
    tipo VARCHAR(20) CHECK (tipo IN ('Pessoa Física', 'Pessoa Jurídica')) NOT NULL,
    cpf VARCHAR(14) UNIQUE CHECK (tipo = 'Pessoa Física' OR cpf IS NULL),
    cnpj VARCHAR(18) UNIQUE CHECK (tipo = 'Pessoa Jurídica' OR cnpj IS NULL),
    nome_fantasia VARCHAR(255),
    razao_social VARCHAR(255),
    inscricao_estadual VARCHAR(50),
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (tipo = 'Pessoa Física' OR (cnpj IS NOT NULL AND razao_social IS NOT NULL)),
    CHECK (tipo = 'Pessoa Jurídica' OR (cpf IS NOT NULL))
);

-- Criar a tabela Tb_Pedido
CREATE TABLE Tb_Pedido (
    id_pedido SERIAL PRIMARY KEY,
    id_cliente INT,
    referencia VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    descricao_item TEXT NOT NULL,
    unid_medida VARCHAR(10) CHECK (unid_medida IN ('pc', 'pco10x', 'pco100x', 'cx100x', 'cx50x')) NOT NULL,
    valor_unitario DECIMAL(10, 2) NOT NULL,
    sub_total DECIMAL(10, 2) NOT NULL,
    forma_pagamento VARCHAR(50) CHECK (forma_pagamento IN ('Cartão', 'Dinheiro', 'Transferência', 'Boleto')) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) CHECK (status IN ('Pendente', 'Concluído', 'Cancelado')) NOT NULL DEFAULT 'Pendente',
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_cliente) REFERENCES Tb_Cliente(id_cliente)
);

-- Criar a tabela Tb_Estoque
CREATE TABLE Tb_Estoque (
    id_estoque SERIAL PRIMARY KEY,
    id_produto INT NOT NULL,
    quantidade_atual INT NOT NULL,
    quantidade_minima INT NOT NULL,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_produto) REFERENCES Tb_Produto(id_produto)
);

-- Criar a tabela Tb_Usuario
CREATE TABLE Tb_Usuario (
    id_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo_permissao VARCHAR(20) CHECK (tipo_permissao IN ('ADMIN', 'CLIENTE')) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Criar a tabela Tb_Log
CREATE TABLE Tb_Log (
    id_log SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    acao VARCHAR(100) NOT NULL,
    tabela_afetada VARCHAR(50) NOT NULL,
    registro_id INT NOT NULL,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descricao TEXT,
    FOREIGN KEY (id_usuario) REFERENCES Tb_Usuario(id_usuario)
);

-- Função para atualizar o campo atualizado_em
CREATE OR REPLACE FUNCTION set_updated_at()
RETURNS TRIGGER AS $$
BEGIN
    NEW.atualizado_em = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Triggers para atualizar o campo atualizado_em
CREATE TRIGGER trg_update_categoria
BEFORE UPDATE ON Tb_Categoria
FOR EACH ROW
EXECUTE FUNCTION set_updated_at();

CREATE TRIGGER trg_update_produto
BEFORE UPDATE ON Tb_Produto
FOR EACH ROW
EXECUTE FUNCTION set_updated_at();

CREATE TRIGGER trg_update_cliente
BEFORE UPDATE ON Tb_Cliente
FOR EACH ROW
EXECUTE FUNCTION set_updated_at();

CREATE TRIGGER trg_update_pedido
BEFORE UPDATE ON Tb_Pedido
FOR EACH ROW
EXECUTE FUNCTION set_updated_at();

CREATE TRIGGER trg_update_usuario
BEFORE UPDATE ON Tb_Usuario
FOR EACH ROW
EXECUTE FUNCTION set_updated_at();

CREATE TRIGGER trg_update_log
BEFORE UPDATE ON Tb_Log
FOR EACH ROW
EXECUTE FUNCTION set_updated_at();
