
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
INSERT INTO deliverer(id, jmbg, id_card_number, full_name) VALUES(1, 01051995211958, 392859, "Aleksandar Hardi");
INSERT INTO deliverer(id, jmbg, id_card_number, full_name) VALUES(2, 11051995211958, 392851, "Max Schwarz");    
INSERT INTO deliverer(id, jmbg, id_card_number, full_name) VALUES(3, 07051995211958, 392852, "John Teller");    
INSERT INTO deliverer(id, jmbg, id_card_number, full_name) VALUES(4, 08051995211958, 392853, "Michel Scofild");

INSERT INTO bill(id, bill_number, date, total_price) VALUES(1, 1232421, '2021-03-05', 44);
INSERT INTO bill(id, bill_number, date, total_price) VALUES(2, 1232422, '2021-04-05', 34);   
INSERT INTO bill(id, bill_number, date, total_price) VALUES(3, 1232423, '2021-05-05', 54);   
INSERT INTO bill(id, bill_number, date, total_price) VALUES(4, 1232424, '2021-06-05', 64);   
INSERT INTO bill(id, bill_number, date, total_price) VALUES(5, 1232425, '2021-07-05', 40);    

INSERT INTO orders(id, order_number, date, place_of_delivery, price, description, deliverer_id) VALUES(1, 521412, '2021-05-05', 'Paris', 12, 'Please hurry up!', 2);
INSERT INTO orders(id, order_number, date, place_of_delivery, price, description, deliverer_id, bill_id) VALUES(2, 521413, '2021-06-05', 'Belgrade', 22, 'Please hurry up!', 1, 2);       
INSERT INTO orders(id, order_number, date, place_of_delivery, price, description, deliverer_id) VALUES(3, 521414, '2021-07-05', 'Amsterdan', 32, 'Please hurry up!', 3);       
INSERT INTO orders(id, order_number, date, place_of_delivery, price, description, deliverer_id) VALUES(4, 521415, '2021-08-05', 'Budapest', 8, 'Please hurry up!', 4);       
INSERT INTO orders(id, order_number, date, place_of_delivery, price, description, deliverer_id) VALUES(5, 521416, '2021-09-05', 'Belgrade', 15, 'Please hurry up!', 1);     

                   