CREATE TABLE IF NOT EXISTS member (
    id VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    birth_date DATE,
    gender VARCHAR(20),
    address VARCHAR(255),
    profession VARCHAR(100),
    phone_number INT,
    email VARCHAR(150),
    occupation VARCHAR(30),
    adhesion_date DATE
);

CREATE TABLE IF NOT EXISTS collectivity (
    id VARCHAR(50) PRIMARY KEY,
    unique_name VARCHAR(150),
    location VARCHAR(150),
    specialty VARCHAR(150),
    president_id VARCHAR(50),
    vice_president_id VARCHAR(50),
    treasurer_id VARCHAR(50),
    secretary_id VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS collectivity_members (
    collectivity_id VARCHAR(50),
    member_id VARCHAR(50),
    PRIMARY KEY (collectivity_id, member_id)
);

CREATE TABLE IF NOT EXISTS financial_account (
    id VARCHAR(50) PRIMARY KEY,
    collectivity_id VARCHAR(50),
    account_type VARCHAR(30),
    holder_name VARCHAR(100),
    amount DECIMAL(15,2)
);

CREATE TABLE IF NOT EXISTS member_referee (
    member_id VARCHAR(50),
    referee_id VARCHAR(50),
    relationship_nature VARCHAR(100),
    PRIMARY KEY (member_id, referee_id)
);

