INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, adhesion_date) VALUES
('C1-M1','Prenom membre 1','Nom membre 1','1980-02-01','M','Lot II V M Ambato.','Riziculteur','0341234567','member.1@fed-agri.mg','PRESIDENT','2025-01-01'),
('C1-M2','Prenom membre 2','Nom membre 2','1982-03-05','M','Lot II F Ambato.','Agriculteur','0321234567','member.2@fed-agri.mg','VICE_PRESIDENT','2025-01-01'),
('C1-M3','Prenom membre 3','Nom membre 3','1992-03-10','M','Lot II J Ambato.','Collecteur','0331234567','member.3@fed-agrimg','SECRETARY','2025-01-01'),
('C1-M4','Prenom membre 4','Nom membre 4','1988-05-22','F','Lot A K 50 Ambato.','Distributeur','0381234567','member.4@fed-agri.mg','TREASURER','2025-01-01'),
('C1-M5','Prenom membre 5','Nom membre 5','1999-08-21','M','Lot UV 80 Ambato.','Riziculteur','0373434567','member.5@fed-agri.mg','SENIOR','2025-01-01'),
('C1-M6','Prenom membre 6','Nom membre 6','1998-08-22','F','Lot UV 6 Ambato.','Riziculteur','0372234567','member.6@fed-agri.mg','SENIOR','2025-01-01'),
('C1-M7','Prenom membre 7','Nom membre 7','1998-01-31','M','Lot UV 7 Ambato.','Riziculteur','0374234567','member.7@fed-agri.mg','SENIOR','2025-01-01'),
('C1-M8','Prenom membre 8','Nom membre 8','1975-08-20','M','Lot UV 8 Ambato.','Riziculteur','0370234567','member.8@fed-agri.mg','SENIOR','2025-01-01'),
('C3-M1','Prenom membre 9','Nom membre 9','1988-01-02','M','Lot 33 J Antsirabe','Apiculteur','034034567','member.9@fed-agri.mg','PRESIDENT','2025-01-01'),
('C3-M2','Prenom membre 10','Nom membre 10','1982-03-05','M','Lot 2 J Antsirabe','Agriculteur','0338634567','member.10@fed-agri.mg','VICE_PRESIDENT','2025-01-01'),
('C3-M3','Prenom membre 11','Nom membre 11','1992-03-12','M','Lot 8 KM Antsirabe','Collecteur','0338234567','member.11@fed-agrimg','SECRETARY','2025-01-01'),
('C3-M4','Prenom membre 12','Nom membre 12','1988-05-10','F','Lot A K 50 Antsirabe','Distributeur','0382334567','member.12@fed-agri.mg','TREASURER','2025-01-01'),
('C3-M5','Prenom membre 13','Nom membre 13','1999-08-11','M','Lot UV 80 Antsirabe','Apiculteur','0373365567','member.13@fed-agri.mg','SENIOR','2025-01-01'),
('C3-M6','Prenom membre 14','Nom membre 14','1998-08-09','F','Lot UV 6 Antsirabe','Apiculteur','0378234567','member.14@fed-agri.mg','SENIOR','2025-01-01'),
('C3-M7','Prenom membre 15','Nom membre 15','1998-01-13','M','Lot UV 7 Antsirabe','Apiculteur','0374914567','member.15@fed-agri.mg','SENIOR','2025-01-01'),
('C3-M8','Prenom membre 16','Nom membre 16','1975-08-02','M','Lot UV 8 Antsirabe','Apiculteur','0370634567','member.16@fed-agri.mg','SENIOR','2025-01-01');

INSERT INTO collectivity (id, number, unique_name, location, specialty, president_id, vice_president_id, treasurer_id, secretary_id) VALUES
('col-1','1','Mpanorina','Ambatondrazaka','Riziculture','C1-M1','C1-M2','C1-M4','C1-M3'),
('col-2','2','Dobo voalohany','Ambatondrazaka','Pisciculture','C1-M5','C1-M6','C1-M8','C1-M7'),
('col-3','3','Tantely mamy','Brickaville','Apiculture','C3-M1','C3-M2','C3-M4','C3-M3');

INSERT INTO collectivity_members (collectivity_id, member_id) VALUES
('col-1','C1-M1'),('col-1','C1-M2'),('col-1','C1-M3'),('col-1','C1-M4'),
('col-1','C1-M5'),('col-1','C1-M6'),('col-1','C1-M7'),('col-1','C1-M8'),
('col-2','C1-M1'),('col-2','C1-M2'),('col-2','C1-M3'),('col-2','C1-M4'),
('col-2','C1-M5'),('col-2','C1-M6'),('col-2','C1-M7'),('col-2','C1-M8'),
('col-3','C3-M1'),('col-3','C3-M2'),('col-3','C3-M3'),('col-3','C3-M4'),
('col-3','C3-M5'),('col-3','C3-M6'),('col-3','C3-M7'),('col-3','C3-M8');

INSERT INTO member_referee (member_id, referee_id, relationship_nature) VALUES
('C1-M3','C1-M1','referent'),('C1-M3','C1-M2','referent'),
('C1-M4','C1-M1','referent'),('C1-M4','C1-M2','referent'),
('C1-M5','C1-M1','referent'),('C1-M5','C1-M2','referent'),
('C1-M6','C1-M1','referent'),('C1-M6','C1-M2','referent'),
('C1-M7','C1-M1','referent'),('C1-M7','C1-M2','referent'),
('C1-M8','C1-M6','referent'),('C1-M8','C1-M7','referent'),
('C3-M1','C1-M1','referent'),('C3-M1','C1-M2','referent'),
('C3-M2','C1-M1','referent'),('C3-M2','C1-M2','referent'),
('C3-M3','C3-M1','referent'),('C3-M3','C3-M2','referent'),
('C3-M4','C3-M1','referent'),('C3-M4','C3-M2','referent'),
('C3-M5','C3-M1','referent'),('C3-M5','C3-M2','referent'),
('C3-M6','C3-M1','referent'),('C3-M6','C3-M2','referent'),
('C3-M7','C3-M1','referent'),('C3-M7','C3-M2','referent'),
('C3-M8','C3-M1','referent'),('C3-M8','C3-M2','referent');

INSERT INTO membership_fee (id, collectivity_id, label, status, frequency, amount, eligible_from) VALUES
('cot-1','col-1','Cotisation annuelle','ACTIVE','ANNUALLY',100000,'2026-01-01'),
('cot-2','col-2','Cotisation annuelle','ACTIVE','ANNUALLY',100000,'2026-01-01'),
('cot-3','col-3','Cotisation annuelle','ACTIVE','ANNUALLY',50000,'2026-01-01');

INSERT INTO financial_account (id, collectivity_id, account_type, mobile_service, holder_name, mobile_number, amount) VALUES
('C1-A-CASH','col-1','CASH',NULL,'Mpanorina',NULL,0),
('C1-A-MOBILE-1','col-1','ORANGE_MONEY','ORANGE_MONEY','Mpanorina','0370489612',0),
('C2-A-CASH','col-2','CASH',NULL,'Dobo voalohany',NULL,0),
('C2-A-MOBILE-1','col-2','ORANGE_MONEY','ORANGE_MONEY','Dobo voalohany','0320489612',0),
('C3-A-CASH','col-3','CASH',NULL,'Tantely mamy',NULL,0);

INSERT INTO member_payment (id, collectivity_id, member_id, amount, account_credited_id, payment_mode, payment_date) VALUES
('MP-C1-1','col-1','C1-M1',100000,'C1-A-CASH','CASH','2026-01-01'),
('MP-C1-2','col-1','C1-M2',100000,'C1-A-CASH','CASH','2026-01-01'),
('MP-C1-3','col-1','C1-M3',100000,'C1-A-CASH','CASH','2026-01-01'),
('MP-C1-4','col-1','C1-M4',100000,'C1-A-CASH','CASH','2026-01-01'),
('MP-C1-5','col-1','C1-M5',100000,'C1-A-CASH','CASH','2026-01-01'),
('MP-C1-6','col-1','C1-M6',100000,'C1-A-CASH','CASH','2026-01-01'),
('MP-C1-7','col-1','C1-M7',60000,'C1-A-CASH','CASH','2026-01-01'),
('MP-C1-8','col-1','C1-M8',90000,'C1-A-CASH','CASH','2026-01-01'),
('MP-C2-1','col-2','C1-M1',60000,'C2-A-CASH','CASH','2026-01-01'),
('MP-C2-2','col-2','C1-M2',90000,'C2-A-CASH','CASH','2026-01-01'),
('MP-C2-3','col-2','C1-M3',100000,'C2-A-CASH','CASH','2026-01-01'),
('MP-C2-4','col-2','C1-M4',100000,'C2-A-CASH','CASH','2026-01-01'),
('MP-C2-5','col-2','C1-M5',100000,'C2-A-CASH','CASH','2026-01-01'),
('MP-C2-6','col-2','C1-M6',100000,'C2-A-CASH','CASH','2026-01-01'),
('MP-C2-7','col-2','C1-M7',40000,'C2-A-MOBILE-1','MOBILE_BANKING','2026-01-01'),
('MP-C2-8','col-2','C1-M8',60000,'C2-A-MOBILE-1','MOBILE_BANKING','2026-01-01');

INSERT INTO collectivity_transaction (id, collectivity_id, debited_member_id, amount, account_credited_id, payment_mode, creation_date) VALUES
('TX-C1-1','col-1','C1-M1',100000,'C1-A-CASH','CASH','2026-01-01'),
('TX-C1-2','col-1','C1-M2',100000,'C1-A-CASH','CASH','2026-01-01'),
('TX-C1-3','col-1','C1-M3',100000,'C1-A-CASH','CASH','2026-01-01'),
('TX-C1-4','col-1','C1-M4',100000,'C1-A-CASH','CASH','2026-01-01'),
('TX-C1-5','col-1','C1-M5',100000,'C1-A-CASH','CASH','2026-01-01'),
('TX-C1-6','col-1','C1-M6',100000,'C1-A-CASH','CASH','2026-01-01'),
('TX-C1-7','col-1','C1-M7',60000,'C1-A-CASH','CASH','2026-01-01'),
('TX-C1-8','col-1','C1-M8',90000,'C1-A-CASH','CASH','2026-01-01'),
('TX-C2-1','col-2','C1-M1',60000,'C2-A-CASH','CASH','2026-01-01'),
('TX-C2-2','col-2','C1-M2',90000,'C2-A-CASH','CASH','2026-01-01'),
('TX-C2-3','col-2','C1-M3',100000,'C2-A-CASH','CASH','2026-01-01'),
('TX-C2-4','col-2','C1-M4',100000,'C2-A-CASH','CASH','2026-01-01'),
('TX-C2-5','col-2','C1-M5',100000,'C2-A-CASH','CASH','2026-01-01'),
('TX-C2-6','col-2','C1-M6',100000,'C2-A-CASH','CASH','2026-01-01'),
('TX-C2-7','col-2','C1-M7',40000,'C2-A-MOBILE-1','MOBILE_BANKING','2026-01-01'),
('TX-C2-8','col-2','C1-M8',60000,'C2-A-MOBILE-1','MOBILE_BANKING','2026-01-01');
