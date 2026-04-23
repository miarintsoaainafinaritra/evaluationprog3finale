CREATE TABLE IF NOT EXISTS member (
    id VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    address VARCHAR(255) NOT NULL,
    profession VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    email VARCHAR(150) NOT NULL,
    occupation VARCHAR(30) NOT NULL,
    adhesion_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS collectivity (
    id VARCHAR(50) PRIMARY KEY,
    number VARCHAR(20) UNIQUE NOT NULL,
    unique_name VARCHAR(150) UNIQUE NOT NULL,
    location VARCHAR(150) NOT NULL,
    specialty VARCHAR(150) NOT NULL,
    president_id VARCHAR(50),
    vice_president_id VARCHAR(50),
    treasurer_id VARCHAR(50),
    secretary_id VARCHAR(50),
    FOREIGN KEY (president_id) REFERENCES member(id),
    FOREIGN KEY (vice_president_id) REFERENCES member(id),
    FOREIGN KEY (treasurer_id) REFERENCES member(id),
    FOREIGN KEY (secretary_id) REFERENCES member(id)
);

CREATE TABLE IF NOT EXISTS collectivity_members (
    collectivity_id VARCHAR(50) NOT NULL,
    member_id VARCHAR(50) NOT NULL,
    PRIMARY KEY (collectivity_id, member_id),
    FOREIGN KEY (collectivity_id) REFERENCES collectivity(id),
    FOREIGN KEY (member_id) REFERENCES member(id)
);

CREATE TABLE IF NOT EXISTS member_referee (
    member_id VARCHAR(50) NOT NULL,
    referee_id VARCHAR(50) NOT NULL,
    relationship_nature VARCHAR(100),
    PRIMARY KEY (member_id, referee_id),
    FOREIGN KEY (member_id) REFERENCES member(id),
    FOREIGN KEY (referee_id) REFERENCES member(id)
);

CREATE TABLE IF NOT EXISTS membership_fee (
    id VARCHAR(50) PRIMARY KEY,
    collectivity_id VARCHAR(50) NOT NULL,
    label VARCHAR(150) NOT NULL,
    status VARCHAR(20) NOT NULL,
    frequency VARCHAR(20) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    eligible_from DATE NOT NULL,
    FOREIGN KEY (collectivity_id) REFERENCES collectivity(id)
);

CREATE TABLE IF NOT EXISTS financial_account (
    id VARCHAR(50) PRIMARY KEY,
    collectivity_id VARCHAR(50) NOT NULL,
    account_type VARCHAR(30) NOT NULL,
    mobile_service VARCHAR(30),
    holder_name VARCHAR(100),
    mobile_number VARCHAR(20),
    amount DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (collectivity_id) REFERENCES collectivity(id)
);

CREATE TABLE IF NOT EXISTS member_payment (
    id VARCHAR(50) PRIMARY KEY,
    collectivity_id VARCHAR(50) NOT NULL,
    member_id VARCHAR(50) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    account_credited_id VARCHAR(50) NOT NULL,
    payment_mode VARCHAR(30) NOT NULL,
    payment_date DATE NOT NULL,
    FOREIGN KEY (collectivity_id) REFERENCES collectivity(id),
    FOREIGN KEY (member_id) REFERENCES member(id),
    FOREIGN KEY (account_credited_id) REFERENCES financial_account(id)
);

CREATE TABLE IF NOT EXISTS collectivity_transaction (
    id VARCHAR(50) PRIMARY KEY,
    collectivity_id VARCHAR(50) NOT NULL,
    debited_member_id VARCHAR(50) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    account_credited_id VARCHAR(50) NOT NULL,
    payment_mode VARCHAR(30) NOT NULL,
    creation_date DATE NOT NULL,
    FOREIGN KEY (collectivity_id) REFERENCES collectivity(id),
    FOREIGN KEY (debited_member_id) REFERENCES member(id),
    FOREIGN KEY (account_credited_id) REFERENCES financial_account(id)
);
