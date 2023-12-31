INSERT INTO tipologia (nome,slug,url_foto) VALUES('pianoforti','pianoforti','https://shop.scavino.it/files/scavino_Files/Foto/1754757_2.PNG');
INSERT INTO tipologia (nome,slug,url_foto) VALUES('chitarre','chitarre','https://shop.scavino.it/files/scavino2_Files/Foto/398639_3.PNG');
INSERT INTO tipologia (nome,slug,url_foto) VALUES('sassofoni','sassofoni','https://m.media-amazon.com/images/I/71S4Ef7BQpL.jpg');
INSERT INTO tipologia (nome,slug,url_foto) VALUES('batterie','batterie','https://www.tuttomusicasrl.it/wp-content/uploads/2022/05/BATTERIA-ACUSTICA-SOUNDSATION-JDK100-BL-JUNIOR-PER-BAMBINI-2.png');




INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (1, 'Donner Professionale Pianoforte', 'https://m.media-amazon.com/images/I/61sp7SOrwAL._AC_SL1485_.jpg', 'Digitale 88 Tasti Pesati con Supporto per Pianoforte e Pedale, Full Weighted Piano Elettroniche Fullsize per Principianti, DEP-20S', 529.00, 'donner-professionale-pianoforte',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (1, 'Yamaha ARIUS YDP-145 Digital Piano', 'https://m.media-amazon.com/images/I/61nxpt3BpdL._AC_SL1500_.jpg', 'Pianoforte Digitale da Casa per Dilettanti, Design Classico ed Elegante, Suonabilità Autentica del Pianoforte Acustico, Bianco', 912.99, 'yamaha-arius-ydp-145-digital-piano',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (1, 'Medeli Grand 510 BK Pianoforte', 'https://m.media-amazon.com/images/I/51b7QNffLAL._AC_SL1200_.jpg', 'Pianoforte Digitale a Coda', 3049.00, 'medeli-grand-510-bk',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (2, 'Yamaha C40BLII Chitarra Classica', 'https://m.media-amazon.com/images/I/413+FNbhyOL._AC_UL480_FMwebp_QL65_.jpg', 'Chitarra 4/4 Classica in Legno (65 cm, scala da 25 9/16”) - 6 Corde in Nylon, Nero', 160.90, 'yamaha-c40blii-chitarra-classica',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (2, 'Gibson Hummingbird Studio', 'https://m.media-amazon.com/images/I/71aadZCyTfL._AC_SL1500_.jpg', 'Chitarra acustica', 3451.53, 'gibson-hummingbird-studio-rw-natural',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (2, 'Cordoba 55 FCE Ziricote', 'https://m.media-amazon.com/images/I/61Ii0s697SL._AC_SL1500_.jpg', 'Chitarra classica', 1689.99, 'cordoba-55-fce-negra-ziricote',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (3, 'Btuty Sassofono C40BLII', 'https://m.media-amazon.com/images/I/61zRYliCb2L._AC_SL1500_.jpg', 'Sassofono contralto in ottone lucido inciso Eb E-Flat Natural White Shell Button Strumento a fiato con custodia Guanti muto Panno di pulizia Spazzola per cintura', 280.99, 'btuty-sassofono',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (3, 'soundman Tuyama TAS-131', 'https://m.media-amazon.com/images/I/61Gw2xJ45+L._AC_SL1500_.jpg', 'Sassofono Contralto in Mib', 336.99, 'soundman-tuyama-tas-131',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (3, 'Odyssey OAS130', 'https://m.media-amazon.com/images/I/71TJekp7IWL._AC_SL1500_.jpg', 'Kit sassofono alto, colore: Oro', 498.45, 'odyssey-oas130',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (4, 'NATAL - DNA STEALTH KIT', 'https://m.media-amazon.com/images/I/71wMe7pEZnL._AC_SL1500_.jpg', 'SET Batteria Acustica Grancassa 18" x 16", Tom 10" x 7", Timpano 14" x 12" e Rullante 13” x 5,5” con rivestimento in finitura Black Stealth Wrap', 468.00, 'natal-dna-stealth-kit',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (4, 'XDrum Semi 20', 'https://m.media-amazon.com/images/I/71x5CIMK0XL._AC_SL1500_.jpg', 'Studio Batteria Midnight Black (nera)', 369.00, 'xdrum-semi-20',1);
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug,in_vendita) VALUES (4, 'Batteria Acustica', 'https://m.media-amazon.com/images/I/618j+k5Zz8S._AC_SL1200_.jpg', 'Completa BDK-1 Rosso', 413.27, 'batteria-acustica',1);

INSERT INTO utente(nome,cognome,email,password,registrato )VALUES ('Mario','Rossi','Mariorossi7@gmail.com','password',true);
INSERT INTO utente(nome,cognome,email,password,registrato )VALUES ('Mario','Bianchi','Mariobianchi7@gmail.com',null,false);

INSERT INTO magazzino(quantity,strumento_id) VALUES (0,1);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,2);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,3);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,4);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,5);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,6);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,7);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,8);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,9);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,10);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,11);
INSERT INTO magazzino(quantity,strumento_id) VALUES (0,12);


INSERT INTO dati_utente(citta,cap,indirizzo,telefono,utente_id) VALUES ('Milano','20833','Via 7','03243343',1)

INSERT INTO fornitore(nome, slug) VALUES ('amazon','amazon');
INSERT INTO fornitore(nome, slug) VALUES ('internet','internet');
INSERT INTO fornitore(nome, slug) VALUES ('ebay','ebay');

-- Inserisci i dati nella tabella fornitore_strumento per il primo strumento (Yamaha ARIUS YDP-145 Digital Piano)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (1, 1, 480.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (1, 2, 950.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (1, 3, 450.00);

-- Inserisci i dati nella tabella fornitore_strumento per il secondo strumento (Donner Professionale Pianoforte)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (2, 1, 520.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (2, 2, 1050.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (2, 3, 430.00);

-- Inserisci i dati nella tabella fornitore_strumento per il terzo strumento (Medeli Grand 510 BK)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (3, 1, 2900.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (3, 2, 3000.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (3, 3, 2700.00);

-- Inserisci i dati nella tabella fornitore_strumento per il quarto strumento (Yamaha C40BLII Chitarra Classica)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (4, 1, 140.00);

-- Inserisci i dati nella tabella fornitore_strumento per il quinto strumento (Gibson Hummingbird Studio RW Natural)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (5, 1, 3300.00);

-- Inserisci i dati nella tabella fornitore_strumento per il sesto strumento (Cordoba 55 FCE Negra Ziricote)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (6, 1, 1600.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (6, 2, 1700.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (6, 3, 1500.00);

-- Inserisci i dati nella tabella fornitore_strumento per il settimo strumento (Btuty Sassofono)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (7, 1, 260.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (7, 2, 280.00);

-- Inserisci i dati nella tabella fornitore_strumento per l'ottavo strumento (soundman Tuyama TAS-131)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (8, 1, 320.00);

-- Inserisci i dati nella tabella fornitore_strumento per il nono strumento (Odyssey OAS130)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (9, 1, 470.00);

-- Inserisci i dati nella tabella fornitore_strumento per il decimo strumento (NATAL - DNA STEALTH KIT)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (10, 1, 450.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (10, 2, 900.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (10, 3, 400.00);

-- Inserisci i dati nella tabella fornitore_strumento per l'undicesimo strumento (XDrum Semi 20)
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (11, 1, 340.00);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (11, 2, 680.00);







INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-12", 3, 6);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-15", 2, 9);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-20", 1, 10);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-25", 4, 13);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-08-01", 1, 5);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-08-05", 2, 7);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-08-10", 3, 8);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-08-15", 1, 9);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-08-20", 2, 4);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-08-25", 5, 6);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-09-01", 2, 10);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-09-05", 1, 11);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-09-10", 3, 12);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-09-15", 4, 13);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-09-20", 2, 3);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-09-25", 1, 2);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-09-30", 5, 1);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-10-05", 3, 10);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-10-10", 2, 8);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-10-15", 1, 7);






































