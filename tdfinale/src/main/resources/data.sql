INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, adhesion_date) 
VALUES ('M100', 'Jean', 'Dupont', '1985-05-15', 'MALE', '123 Rue de la Ferme', 'Agriculteur', 12345678, 'jean.dupont@agri.com', 'SENIOR', '2020-01-01');

INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, adhesion_date) 
VALUES ('M101', 'Marie', 'Curie', '1990-11-22', 'FEMALE', '456 Avenue des Champs', 'Chercheuse', 87654321, 'marie.curie@agri.com', 'SENIOR', '2021-06-12');

INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, adhesion_date)
VALUES ('M102', 'Paul', 'Rabe', '1995-03-10', 'MALE', '789 Route Principale', 'Eleveur', 34567890, 'paul.rabe@agri.com', 'JUNIOR', '2024-02-20');

INSERT INTO collectivity (id, name, location, specialty, creation_date, president_id, vice_president_id, treasurer_id, secretary_id) 
VALUES ('C100', 'Collectivite Antsirabe', 'Antsirabe', 'Riziculture', '2023-01-01', 'M100', 'M101', 'M100', 'M101');

INSERT INTO collectivity_members (collectivity_id, member_id) VALUES ('C100', 'M100');
INSERT INTO collectivity_members (collectivity_id, member_id) VALUES ('C100', 'M101');
INSERT INTO collectivity_members (collectivity_id, member_id) VALUES ('C100', 'M102');

INSERT INTO member_referees (member_id, referee_id, relationship_nature) VALUES ('M102', 'M100', 'famille');
INSERT INTO member_referees (member_id, referee_id, relationship_nature) VALUES ('M102', 'M101', 'collegue');


SELECT r.*
FROM member r
JOIN member_referees mr ON mr.referee_id = r.id
WHERE mr.member_id = 'M102';


SELECT m.*
FROM member m
JOIN collectivity_members cm ON cm.member_id = m.id
WHERE cm.collectivity_id = 'C100';

SELECT m.id, m.first_name, m.last_name, r.id AS referee_id, r.first_name AS referee_first_name, r.last_name AS referee_last_name
FROM member m
JOIN member_referees mr ON mr.member_id = m.id
JOIN member r ON r.id = mr.referee_id;
