INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, adhesion_date)
VALUES ('M100', 'Jean', 'Dupont', '1985-05-15', 'MALE', 'Antananarivo', 'Agriculteur', 12345678, 'jean@agri.mg', 'SENIOR', '2025-01-01');

INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, adhesion_date)
VALUES ('M101', 'Marie', 'Rakoto', '1990-11-22', 'FEMALE', 'Antsirabe', 'Commercante', 87654321, 'marie@agri.mg', 'SENIOR', '2025-01-01');

INSERT INTO collectivity (id, unique_name, location, specialty, president_id, vice_president_id, treasurer_id, secretary_id)
VALUES ('C100', 'Collectivite Antsirabe', 'Antsirabe', 'Riziculture', 'M100', 'M101', 'M100', 'M101');

INSERT INTO collectivity_members (collectivity_id, member_id) VALUES ('C100', 'M100');
INSERT INTO collectivity_members (collectivity_id, member_id) VALUES ('C100', 'M101');

INSERT INTO financial_account (id, collectivity_id, account_type, holder_name, amount)
VALUES ('FA-CASH-C100', 'C100', 'CASH', 'Collectivite Antsirabe', 50000.00);
