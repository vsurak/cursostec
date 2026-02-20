-- Crear tabla de clientes
CREATE TABLE clientes (
    clientid INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    cedula VARCHAR(20) UNIQUE NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100),
    posttime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crear tabla de préstamos
CREATE TABLE prestamos (
    prestamoid INT AUTO_INCREMENT PRIMARY KEY,
    clientid INT NOT NULL,
    monto DECIMAL(15,2) NOT NULL,
    saldo DECIMAL(15,2) NOT NULL,
    tasa DECIMAL(5,2) NOT NULL, -- en porcentaje
    inicio DATE NOT NULL,
    cierre DATE,
    cuotas INT NOT NULL,
    estado ENUM('AL_DIA', 'EN_MORA') DEFAULT 'AL_DIA',
    posttime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (clientid) REFERENCES clientes(clientid)
);

-- Crear tabla de transacciones de préstamo
CREATE TABLE transactions (
    transid INT AUTO_INCREMENT PRIMARY KEY,
    prestamoid INT NOT NULL,
    clientid INT NOT NULL,
    type ENUM('PAGO', 'DESEMBOLSO', 'AJUSTE') NOT NULL,
    posttime DATE NOT NULL,
    description VARCHAR(255),
    amount DECIMAL(15,2) NOT NULL,
    saldoBefore DECIMAL(15,2) NOT NULL,
    saldoDespues DECIMAL(15,2) NOT NULL,
    pago_a_principal DECIMAL(15,2) DEFAULT 0.00,
    pago_a_intereses DECIMAL(15,2) DEFAULT 0.00,
    FOREIGN KEY (prestamoid) REFERENCES prestamos(prestamoid),
    FOREIGN KEY (clientid) REFERENCES clientes(clientid)
);

-- Insertar clientes
INSERT INTO clientes (nombre, apellido, cedula, phone, email) VALUES
('Carlos', 'Mendez', '0101-1234-5678', '8888-1111', 'carlos.mendez@example.com'),
('Maria', 'Fernandez', '0202-2345-6789', '8888-2222', 'maria.fernandez@example.com'),
('Jorge', 'Ramirez', '0303-3456-7890', '8888-3333', 'jorge.ramirez@example.com'),
('Sofia', 'Lopez', '0404-4567-8901', '8888-4444', 'sofia.lopez@example.com'),
('Andres', 'Gomez', '0505-5678-9012', '8888-5555', 'andres.gomez@example.com'),
('Lucia', 'Vargas', '0606-6789-0123', '8888-6666', 'lucia.vargas@example.com'),
('Ricardo', 'Torres', '0707-7890-1234', '8888-7777', 'ricardo.torres@example.com');

-- Insertar préstamos (cierres entre 2026 y 2028)
INSERT INTO prestamos (clientid, monto, saldo, tasa, inicio, cierre, cuotas, estado) VALUES
(1, 10000.00, 5000.00, 12.50, '2024-01-15', '2026-08-15', 24, 'AL_DIA'),
(2, 20000.00, 12000.00, 10.00, '2024-02-10', '2027-01-10', 36, 'AL_DIA'),
(3, 30000.00, 24000.00, 9.75,  '2024-03-20', '2026-12-20', 30, 'AL_DIA'),
(4, 40000.00, 40000.00, 11.00, '2024-04-05', '2028-03-05', 48, 'EN_MORA'), -- único en mora
(5, 50000.00, 42000.00, 13.00, '2024-05-18', '2027-04-18', 36, 'AL_DIA'),
(6, 60000.00, 48000.00, 8.50,  '2024-06-12', '2028-05-12', 48, 'AL_DIA'),
(7, 70000.00, 60000.00, 12.00, '2024-02-25', '2027-01-25', 36, 'AL_DIA');

-- Insertar transacciones de pagos congruentes (de inicio hasta sep 2025)
INSERT INTO transactions (prestamoid, clientid, type, posttime, description, amount, saldoBefore, saldoDespues, pago_a_principal, pago_a_intereses) VALUES
-- Cliente 1 (pagos mensuales)
(1, 1, 'PAGO', '2024-02-15', 'Pago cuota 1', 500.00, 10000.00, 9500.00, 400.00, 100.00),
(1, 1, 'PAGO', '2024-03-15', 'Pago cuota 2', 500.00, 9500.00, 9000.00, 410.00, 90.00),
(1, 1, 'PAGO', '2024-04-15', 'Pago cuota 3', 500.00, 9000.00, 8500.00, 420.00, 80.00),
(1, 1, 'PAGO', '2024-05-15', 'Pago cuota 4', 500.00, 8500.00, 8000.00, 430.00, 70.00),
(1, 1, 'PAGO', '2025-09-10', 'Pago cuota 19', 500.00, 5500.00, 5000.00, 440.00, 60.00),

-- Cliente 2 (pagos trimestrales)
(2, 2, 'PAGO', '2024-05-10', 'Pago cuota 1', 2000.00, 20000.00, 18000.00, 1800.00, 200.00),
(2, 2, 'PAGO', '2024-08-10', 'Pago cuota 2', 2000.00, 18000.00, 16000.00, 1820.00, 180.00),
(2, 2, 'PAGO', '2025-02-10', 'Pago cuota 3', 2000.00, 14000.00, 12000.00, 1840.00, 160.00),

-- Cliente 3 (pagos bimestrales)
(3, 3, 'PAGO', '2024-05-20', 'Pago cuota 1', 3000.00, 30000.00, 27000.00, 2800.00, 200.00),
(3, 3, 'PAGO', '2024-07-20', 'Pago cuota 2', 3000.00, 27000.00, 24000.00, 2820.00, 180.00),

-- Cliente 4 (en mora, solo desembolso)
(4, 4, 'DESEMBOLSO', '2024-04-05', 'Desembolso inicial del préstamo', 40000.00, 0.00, 40000.00, 0.00, 0.00),

-- Cliente 5 (pagos mensuales)
(5, 5, 'PAGO', '2024-06-18', 'Pago cuota 1', 3000.00, 50000.00, 47000.00, 2800.00, 200.00),
(5, 5, 'PAGO', '2024-07-18', 'Pago cuota 2', 3000.00, 47000.00, 44000.00, 2810.00, 190.00),
(5, 5, 'PAGO', '2025-09-05', 'Pago cuota 15', 2000.00, 44000.00, 42000.00, 1820.00, 180.00),

-- Cliente 6 (pagos trimestrales)
(6, 6, 'PAGO', '2024-09-12', 'Pago cuota 1', 6000.00, 60000.00, 54000.00, 5700.00, 300.00),
(6, 6, 'PAGO', '2025-03-12', 'Pago cuota 2', 6000.00, 54000.00, 48000.00, 5720.00, 280.00),

-- Cliente 7 (pagos mensuales desde marzo 2024)
(7, 7, 'PAGO', '2024-03-25', 'Pago cuota 1', 4000.00, 70000.00, 66000.00, 3700.00, 300.00),
(7, 7, 'PAGO', '2024-04-25', 'Pago cuota 2', 4000.00, 66000.00, 62000.00, 3710.00, 290.00),
(7, 7, 'PAGO', '2025-09-01', 'Pago cuota 18', 2000.00, 62000.00, 60000.00, 1820.00, 180.00);
