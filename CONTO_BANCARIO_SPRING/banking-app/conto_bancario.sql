CREATE DATABASE conto_bancario;

USE conto_bancario;

CREATE TABLE Account (
    ID INT AUTO_INCREMENT PRIMARY KEY,  -- Identificativo univoco per ogni account
    Nome VARCHAR(100) NOT NULL,         -- Nome dell'account
    Saldo DECIMAL(10, 2) NOT NULL       -- Saldo dell'account, con due decimali
);

CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    type VARCHAR(20) NOT NULL, -- "deposit", "withdrawal", "transfer"
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES Account(ID)  -- Correzione qui, usa Account invece di accounts
);

INSERT INTO Account (Nome, Saldo) VALUES ('Giuseppe Fileti', 1000.00);
INSERT INTO Account (Nome, Saldo) VALUES ('Marco Rossi', 1500.50);
INSERT INTO Account (Nome, Saldo) VALUES ('Laura Bianchi', 2500.75);
INSERT INTO Account (Nome, Saldo) VALUES ('Francesco Verdi', 1800.30);
INSERT INTO Account (Nome, Saldo) VALUES ('Anna Neri', 2200.40);

SELECT * FROM Account;


