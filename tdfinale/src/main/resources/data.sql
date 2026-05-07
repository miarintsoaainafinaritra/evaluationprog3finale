INSERT INTO collectivity (id, number, name, location, specialization) VALUES 
('col-1', 1, 'Mpanorina', 'Ambatondrazaka', 'Riziculture'),
('col-2', 2, 'Dobo voalohany', 'Ambatondrazaka', 'Pisciculture'),
('col-3', 3, 'Tantely mamy', 'Brickaville', 'Apiculture');


INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, membership_date) VALUES 
('C1-M1', 'Prénom membre 1', 'Nom membre 1', '1980-02-01', 'M', 'Lot II V M Ambato.', 'Riziculteur', '0341234567', 'member.1@fed-agri.mg', 'PRESIDENT', '2026-01-01'),
('C1-M2', 'Prénom membre 2', 'Nom membre 2', '1982-03-05', 'M', 'Lot II F Ambato.', 'Agriculteur', '0321234567', 'member.2@fed-agri.mg', 'VICE_PRESIDENT', '2026-01-01'),
('C1-M3', 'Prénom membre 3', 'Nom membre 3', '1992-03-10', 'M', 'Lot II J Ambato.', 'Collecteur', '0331234567', 'member.3@fed-agrimg', 'SECRETARY', '2026-01-01'),
('C1-M4', 'Prénom membre 4', 'Nom membre 4', '1988-05-22', 'F', 'Lot A K 50 Ambato.', 'Distributeur', '0381234567', 'member.4@fed-agri.mg', 'TREASURER', '2026-01-01'),
('C1-M5', 'Prénom membre 5', 'Nom membre 5', '1999-08-21', 'M', 'Lot UV 80 Ambato.', 'Riziculteur', '0373434567', 'member.5@fed-agri.mg', 'SENIOR', '2026-01-01'),
('C1-M6', 'Prénom membre 6', 'Nom membre 6', '1998-08-22', 'F', 'Lot UV 6 Ambato.', 'Riziculteur', '0372234567', 'member.6@fed-agri.mg', 'SENIOR', '2026-01-01'),
('C1-M7', 'Prénom membre 7', 'Nom membre 7', '1998-01-31', 'M', 'Lot UV 7 Ambato.', 'Riziculteur', '0374234567', 'member.7@fed-agri.mg', 'SENIOR', '2026-01-01'),
('C1-M8', 'Prénom membre 6', 'Nom membre 8', '1975-08-20', 'M', 'Lot UV 8 Ambato.', 'Riziculteur', '0370234567', 'member.8@fed-agri.mg', 'SENIOR', '2026-01-01');


INSERT INTO collectivity_member (id, member_id, collectivity_id) VALUES 
('CM-C1-M1', 'C1-M1', 'col-1'), ('CM-C1-M2', 'C1-M2', 'col-1'), ('CM-C1-M3', 'C1-M3', 'col-1'), ('CM-C1-M4', 'C1-M4', 'col-1'),
('CM-C1-M5', 'C1-M5', 'col-1'), ('CM-C1-M6', 'C1-M6', 'col-1'), ('CM-C1-M7', 'C1-M7', 'col-1'), ('CM-C1-M8', 'C1-M8', 'col-1');


UPDATE collectivity SET president_id = 'C1-M1', vice_president_id = 'C1-M2', treasurer_id = 'C1-M4', secretary_id = 'C1-M3' WHERE id = 'col-1';


INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, membership_date) VALUES 
('C2-M1', 'Prénom membre 1', 'Nom membre 1', '1980-02-01', 'M', 'Lot II V M Ambato.', 'Riziculteur', '0341234567', 'member.1@fed-agri.mg', 'SENIOR', '2026-01-01'),
('C2-M2', 'Prénom membre 2', 'Nom membre 2', '1982-03-05', 'M', 'Lot II F Ambato.', 'Agriculteur', '0321234567', 'member.2@fed-agri.mg', 'SENIOR', '2026-01-01'),
('C2-M3', 'Prénom membre 3', 'Nom membre 3', '1992-03-10', 'M', 'Lot II J Ambato.', 'Collecteur', '0331234567', 'member.3@fed-agrimg', 'SENIOR', '2026-01-01'),
('C2-M4', 'Prénom membre 4', 'Nom membre 4', '1988-05-22', 'F', 'Lot A K 50 Ambato.', 'Distributeur', '0381234567', 'member.4@fed-agri.mg', 'SENIOR', '2026-01-01'),
('C2-M5', 'Prénom membre 5', 'Nom membre 5', '1999-08-21', 'M', 'Lot UV 80 Ambato.', 'Riziculteur', '0373434567', 'member.5@fed-agri.mg', 'PRESIDENT', '2026-01-01'),
('C2-M6', 'Prénom membre 6', 'Nom membre 6', '1998-08-22', 'F', 'Lot UV 6 Ambato.', 'Riziculteur', '0372234567', 'member.6@fed-agri.mg', 'VICE_PRESIDENT', '2026-01-01'),
('C2-M7', 'Prénom membre 7', 'Nom membre 7', '1998-01-31', 'M', 'Lot UV 7 Ambato.', 'Riziculteur', '0374234567', 'member.7@fed-agri.mg', 'SECRETARY', '2026-01-01'),
('C2-M8', 'Prénom membre 6', 'Nom membre 8', '1975-08-20', 'M', 'Lot UV 8 Ambato.', 'Riziculteur', '0370234567', 'member.8@fed-agri.mg', 'TREASURER', '2026-01-01');

INSERT INTO collectivity_member (id, member_id, collectivity_id) VALUES 
('CM-C2-M1', 'C2-M1', 'col-2'), ('CM-C2-M2', 'C2-M2', 'col-2'), ('CM-C2-M3', 'C2-M3', 'col-2'), ('CM-C2-M4', 'C2-M4', 'col-2'),
('CM-C2-M5', 'C2-M5', 'col-2'), ('CM-C2-M6', 'C2-M6', 'col-2'), ('CM-C2-M7', 'C2-M7', 'col-2'), ('CM-C2-M8', 'C2-M8', 'col-2');

UPDATE collectivity SET president_id = 'C2-M5', vice_president_id = 'C2-M6', treasurer_id = 'C2-M8', secretary_id = 'C2-M7' WHERE id = 'col-2';


INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, membership_date) VALUES 
('C3-M1', 'Prénom membre 9', 'Nom membre 9', '1988-01-02', 'M', 'Lot 33 J Antsirabe', 'Apiculteur', '034034567', 'member.9@fed-agri.mg', 'PRESIDENT', '2026-01-01'),
('C3-M2', 'Prénom membre 10', 'Nom membre 10', '1982-03-05', 'M', 'Lot 2 J Antsirabe', 'Agriculteur', '0338634567', 'member.10@fed-agri.mg', 'VICE_PRESIDENT', '2026-01-01'),
('C3-M3', 'Prénom membre 11', 'Nom membre 11', '1992-03-12', 'M', 'Lot 8 KM Antsirabe', 'Collecteur', '0338234567', 'member.11@fed-agrimg', 'SECRETARY', '2026-01-01'),
('C3-M4', 'Prénom membre 12', 'Nom membre 12', '1988-05-10', 'F', 'Lot A K 50 Antsirabe', 'Distributeur', '0382334567', 'member.12@fed-agri.mg', 'TREASURER', '2026-01-01'),
('C3-M5', 'Prénom membre 13', 'Nom membre 13', '1999-08-11', 'M', 'Lot UV 80 Antsirabe.', 'Apiculteur', '0373365567', 'member.13@fed-agri.mg', 'SENIOR', '2026-01-01'),
('C3-M6', 'Prénom membre 14', 'Nom membre 14', '1998-08-09', 'F', 'Lot UV 6 Antsirabe.', 'Apiculteur', '0378234567', 'member.14@fed-agri.mg', 'SENIOR', '2026-01-01'),
('C3-M7', 'Prénom membre 15', 'Nom membre 15', '1998-01-13', 'M', 'Lot UV 7 Antsirabe', 'Apiculteur', '0374914567', 'member.15@fed-agri.mg', 'SENIOR', '2026-01-01'),
('C3-M8', 'Prénom membre 16', 'Nom membre 16', '1975-08-02', 'M', 'Lot UV 8 Antsirabe', 'Apiculteur', '0370634567', 'member.16@fed-agri.mg', 'SENIOR', '2026-01-01');

INSERT INTO collectivity_member (id, member_id, collectivity_id) VALUES 
('CM-C3-M1', 'C3-M1', 'col-3'), ('CM-C3-M2', 'C3-M2', 'col-3'), ('CM-C3-M3', 'C3-M3', 'col-3'), ('CM-C3-M4', 'C3-M4', 'col-3'),
('CM-C3-M5', 'C3-M5', 'col-3'), ('CM-C3-M6', 'C3-M6', 'col-3'), ('CM-C3-M7', 'C3-M7', 'col-3'), ('CM-C3-M8', 'C3-M8', 'col-3');

UPDATE collectivity SET president_id = 'C3-M1', vice_president_id = 'C3-M2', treasurer_id = 'C3-M4', secretary_id = 'C3-M3' WHERE id = 'col-3';

INSERT INTO financial_account (id, collectivity_id, type, amount, holder_name, phone_number, bank_name, bank_code, branch_code, account_number, rib_key) VALUES 
('C1-A-CASH', 'col-1', 'CASH', 650000, '-', '-', NULL, NULL, NULL, NULL, NULL),
('C1-A-MOBILE-1', 'col-1', 'MOBILE_BANKING', 550000, 'Mpanorina', '0370489612', 'ORANGE_MONEY', NULL, NULL, NULL, NULL),
('C2-A-CASH', 'col-2', 'CASH', 1100000, '-', '-', NULL, NULL, NULL, NULL, NULL),
('C2-A-MOBILE-1', 'col-2', 'MOBILE_BANKING', 200000, 'Dobo voalohany', '0320489612', 'ORANGE_MONEY', NULL, NULL, NULL, NULL),
('C3-A-CASH', 'col-3', 'CASH', 60000, '-', '-', NULL, NULL, NULL, NULL, NULL),
('C3-A-BANK-1', 'col-3', 'BANK_TRANSFER', 150000, 'Kolo', NULL, 'BMOI', '00004', '00001', '1234567890', '12'),
('C3-A-BANK-2', 'col-3', 'BANK_TRANSFER', 95000, 'Naivo', NULL, 'BRED', '00008', '00003', '4567890123', '58'),
('C3-A-MOBILE-1', 'col-3', 'MOBILE_BANKING', 30000, 'Koto', '0341889612', 'MVOLA', NULL, NULL, NULL, NULL);


INSERT INTO membership_fee (id, collectivity_id, label, active, frequency, eligible_from, amount) VALUES 
('cot-1', 'col-1', 'Cotisation annuelle', TRUE, 'ANNUALLY', '2026-01-01', 200000),
('cot-2', 'col-1', 'Famangiana', TRUE, 'PUNCTUALLY', '2026-04-30', 20000),
('cot-3', 'col-2', 'Cotisation annuelle', TRUE, 'ANNUALLY', '2026-01-01', 200000),
('cot-4', 'col-2', 'Cotisation 2025', FALSE, 'ANNUALLY', '2025-01-01', 100000),
('cot-5', 'col-3', 'Cotisation mensuelle', TRUE, 'MONTHLY', '2026-04-01', 25000);


INSERT INTO payment (amount, payment_date, member_id, fee_id, account_id, payment_mode) VALUES 
(200000, '2026-01-01 00:00:00', 'C1-M1', 'cot-1', 'C1-A-CASH', 'CASH'),
(200000, '2026-01-01 00:00:00', 'C1-M2', 'cot-1', 'C1-A-CASH', 'CASH'),
(200000, '2026-01-01 00:00:00', 'C1-M3', 'cot-1', 'C1-A-MOBILE-1', 'MOBILE_BANKING'),
(200000, '2026-01-01 00:00:00', 'C1-M4', 'cot-1', 'C1-A-MOBILE-1', 'MOBILE_BANKING'),
(150000, '2026-01-01 00:00:00', 'C1-M5', 'cot-1', 'C1-A-MOBILE-1', 'MOBILE_BANKING'),
(100000, '2026-05-01 00:00:00', 'C1-M6', 'cot-1', 'C1-A-CASH', 'CASH'),
(60000, '2026-05-01 00:00:00', 'C1-M7', 'cot-1', 'C1-A-CASH', 'CASH'),
(90000, '2026-05-01 00:00:00', 'C1-M8', 'cot-1', 'C1-A-CASH', 'CASH'),
(120000, '2026-01-01 00:00:00', 'C1-M1', 'cot-3', 'C2-A-CASH', 'CASH'),
(180000, '2026-01-01 00:00:00', 'C1-M2', 'cot-3', 'C2-A-CASH', 'CASH'),
(200000, '2026-01-01 00:00:00', 'C1-M3', 'cot-3', 'C2-A-CASH', 'CASH'),
(200000, '2026-01-01 00:00:00', 'C1-M4', 'cot-3', 'C2-A-CASH', 'CASH'),
(200000, '2026-01-01 00:00:00', 'C1-M5', 'cot-3', 'C2-A-CASH', 'CASH'),
(200000, '2026-01-01 00:00:00', 'C1-M6', 'cot-3', 'C2-A-CASH', 'CASH'),
(80000, '2026-01-01 00:00:00', 'C1-M7', 'cot-3', 'C2-A-MOBILE-1', 'MOBILE_BANKING'),
(120000, '2026-01-01 00:00:00', 'C1-M8', 'cot-3', 'C2-A-MOBILE-1', 'MOBILE_BANKING'),
(25000, '2026-04-01 00:00:00', 'C3-M1', 'cot-5', 'C3-A-BANK-1', 'BANK_TRANSFER'),
(25000, '2026-04-01 00:00:00', 'C3-M2', 'cot-5', 'C3-A-BANK-1', 'BANK_TRANSFER'),
(25000, '2026-04-01 00:00:00', 'C3-M3', 'cot-5', 'C3-A-BANK-1', 'BANK_TRANSFER'),
(25000, '2026-04-01 00:00:00', 'C3-M4', 'cot-5', 'C3-A-BANK-1', 'BANK_TRANSFER'),
(25000, '2026-04-01 00:00:00', 'C3-M5', 'cot-5', 'C3-A-BANK-2', 'BANK_TRANSFER'),
(25000, '2026-04-01 00:00:00', 'C3-M6', 'cot-5', 'C3-A-BANK-2', 'BANK_TRANSFER'),
(25000, '2026-04-01 00:00:00', 'C3-M7', 'cot-5', 'C3-A-CASH', 'CASH'),
(25000, '2026-04-01 00:00:00', 'C3-M8', 'cot-5', 'C3-A-CASH', 'CASH'),
(25000, '2026-05-01 00:00:00', 'C3-M1', 'cot-5', 'C3-A-BANK-1', 'BANK_TRANSFER'),
(25000, '2026-05-01 00:00:00', 'C3-M2', 'cot-5', 'C3-A-BANK-1', 'BANK_TRANSFER'),
(15000, '2026-05-01 00:00:00', 'C3-M3', 'cot-5', 'C3-A-MOBILE-1', 'MOBILE_BANKING'),
(15000, '2026-05-01 00:00:00', 'C3-M4', 'cot-5', 'C3-A-MOBILE-1', 'MOBILE_BANKING'),
(20000, '2026-05-01 00:00:00', 'C3-M5', 'cot-5', 'C3-A-BANK-2', 'BANK_TRANSFER'),
(25000, '2026-05-01 00:00:00', 'C3-M6', 'cot-5', 'C3-A-BANK-2', 'BANK_TRANSFER'),
(5000, '2026-05-01 00:00:00', 'C3-M7', 'cot-5', 'C3-A-CASH', 'CASH'),
(5000, '2026-05-01 00:00:00', 'C3-M8', 'cot-5', 'C3-A-CASH', 'CASH');


INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, membership_date) VALUES 
('C1-M9', 'Prenom1', 'Nom1', '2000-01-01', 'M', 'Adresse1', 'Prof1', '0612345678', 'email1@test.com', 'JUNIOR', '2026-04-01'),
('C1-M10', 'Prenom2', 'Nom2', '2000-01-01', 'M', 'Adresse2', 'Prof2', '0612345679', 'email2@test.com', 'JUNIOR', '2026-04-01'),
('C1-M11', 'Prenom3', 'Nom3', '2000-01-01', 'M', 'Adresse3', 'Prof3', '0612345680', 'email3@test.com', 'JUNIOR', '2026-05-01'),
('C1-M12', 'Prenom4', 'Nom4', '2000-01-01', 'M', 'Adresse4', 'Prof4', '0612345681', 'email4@test.com', 'JUNIOR', '2026-06-01'),
('C2-M9', 'Prenom5', 'Nom5', '2000-01-01', 'M', 'Adresse5', 'Prof5', '0612345682', 'email5@test.com', 'JUNIOR', '2026-03-01'),
('C2-M10', 'Prenom6', 'Nom6', '2000-01-01', 'M', 'Adresse6', 'Prof6', '0612345683', 'email6@test.com', 'JUNIOR', '2026-03-01'),
('C2-M11', 'Prenom7', 'Nom7', '2000-01-01', 'M', 'Adresse7', 'Prof7', '0612345684', 'email7@test.com', 'JUNIOR', '2026-03-01'),
('C3-M9', 'Prenom8', 'Nom8', '2000-01-01', 'M', 'Adresse8', 'Prof8', '0612345685', 'email8@test.com', 'JUNIOR', '2026-01-01'),
('C3-M10', 'Prenom9', 'Nom9', '2000-01-01', 'M', 'Adresse9', 'Prof9', '0612345686', 'email9@test.com', 'JUNIOR', '2026-02-01'),
('C3-M11', 'Prenom10', 'Nom10', '2000-01-01', 'M', 'Adresse10', 'Prof10', '0612345687', 'email10@test.com', 'JUNIOR', '2026-02-01'),
('C3-M12', 'Prenom11', 'Nom11', '2000-01-01', 'M', 'Adresse11', 'Prof11', '0612345688', 'email11@test.com', 'JUNIOR', '2026-03-01'),
('C3-M13', 'Prenom12', 'Nom12', '2000-01-01', 'M', 'Adresse12', 'Prof12', '0612345689', 'email12@test.com', 'JUNIOR', '2026-03-01'),
('C3-M14', 'Prenom13', 'Nom13', '2000-01-01', 'M', 'Adresse13', 'Prof13', '0612345690', 'email13@test.com', 'JUNIOR', '2026-03-01');

INSERT INTO collectivity_member (id, member_id, collectivity_id) VALUES 
('CM-C1-M9', 'C1-M9', 'col-1'), ('CM-C1-M10', 'C1-M10', 'col-1'), ('CM-C1-M11', 'C1-M11', 'col-1'), ('CM-C1-M12', 'C1-M12', 'col-1'),
('CM-C2-M9', 'C2-M9', 'col-2'), ('CM-C2-M10', 'C2-M10', 'col-2'), ('CM-C2-M11', 'C2-M11', 'col-2'),
('CM-C3-M9', 'C3-M9', 'col-3'), ('CM-C3-M10', 'C3-M10', 'col-3'), ('CM-C3-M11', 'C3-M11', 'col-3'), ('CM-C3-M12', 'C3-M12', 'col-3'), ('CM-C3-M13', 'C3-M13', 'col-3'), ('CM-C3-M14', 'C3-M14', 'col-3');

INSERT INTO member_referee (id, member_refereed_id, member_referee_id) VALUES 
('REF-C1-M9-1', 'C1-M9', 'C1-M1'), ('REF-C1-M9-2', 'C1-M9', 'C1-M2'),
('REF-C1-M10-1', 'C1-M10', 'C1-M1'), ('REF-C1-M10-2', 'C1-M10', 'C1-M2'),
('REF-C1-M11-1', 'C1-M11', 'C1-M1'), ('REF-C1-M11-2', 'C1-M11', 'C1-M2'),
('REF-C1-M12-1', 'C1-M12', 'C1-M1'), ('REF-C1-M12-2', 'C1-M12', 'C1-M2'),
('REF-C2-M9-1', 'C2-M9', 'C1-M1'), ('REF-C2-M9-2', 'C2-M9', 'C1-M2'),
('REF-C2-M10-1', 'C2-M10', 'C1-M1'), ('REF-C2-M10-2', 'C2-M10', 'C1-M2'),
('REF-C2-M11-1', 'C2-M11', 'C1-M1'), ('REF-C2-M11-2', 'C2-M11', 'C1-M2'),
('REF-C3-M9-1', 'C3-M9', 'C3-M1'), ('REF-C3-M9-2', 'C3-M9', 'C3-M2'),
('REF-C3-M10-1', 'C3-M10', 'C3-M1'), ('REF-C3-M10-2', 'C3-M10', 'C3-M2'),
('REF-C3-M11-1', 'C3-M11', 'C3-M1'), ('REF-C3-M11-2', 'C3-M11', 'C3-M2'),
('REF-C3-M12-1', 'C3-M12', 'C3-M1'), ('REF-C3-M12-2', 'C3-M12', 'C3-M2'),
('REF-C3-M13-1', 'C3-M13', 'C3-M1'), ('REF-C3-M13-2', 'C3-M13', 'C3-M2'),
('REF-C3-M14-1', 'C3-M14', 'C3-M1'), ('REF-C3-M14-2', 'C3-M14', 'C3-M2');
