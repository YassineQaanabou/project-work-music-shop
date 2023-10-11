INSERT INTO tipologia (nome,slug,url_foto) VALUES('pianoforti','pianoforti','https://shop.scavino.it/files/scavino_Files/Foto/1754757_2.PNG');
INSERT INTO tipologia (nome,slug,url_foto) VALUES('chitarre','chitarre','https://shop.scavino.it/files/scavino2_Files/Foto/398639_3.PNG');
INSERT INTO tipologia (nome,slug,url_foto) VALUES('sassofoni','sassofoni','https://m.media-amazon.com/images/I/71S4Ef7BQpL.jpg');
INSERT INTO tipologia (nome,slug,url_foto) VALUES('batterie','batterie','https://www.tuttomusicasrl.it/wp-content/uploads/2022/05/BATTERIA-ACUSTICA-SOUNDSATION-JDK100-BL-JUNIOR-PER-BAMBINI-2.png');




INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (1, 'Yamaha ARIUS YDP-145 Digital Piano', 'https://m.media-amazon.com/images/I/61nxpt3BpdL._AC_SL1500_.jpg', 'Pianoforte Digitale da Casa per Dilettanti, Design Classico ed Elegante, Suonabilità Autentica del Pianoforte Acustico, Bianco', 912.99, 'yamaha-arius-ydp-145-digital-piano');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (1, 'Donner Professionale Pianoforte', 'https://m.media-amazon.com/images/I/61sp7SOrwAL._AC_SL1485_.jpg', 'Digitale 88 Tasti Pesati con Supporto per Pianoforte e Pedale, Full Weighted Piano Elettroniche Fullsize per Principianti, DEP-20S', 529.00, 'donner-professionale-pianoforte');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (1, 'Medeli Grand 510 BK', 'https://m.media-amazon.com/images/I/51b7QNffLAL._AC_SL1200_.jpg', 'Pianoforte Digitale a Coda', 3049.00, 'medeli-grand-510-bk');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (2, 'Yamaha C40BLII Chitarra Classica', 'https://m.media-amazon.com/images/I/413+FNbhyOL._AC_UL480_FMwebp_QL65_.jpg', 'Chitarra 4/4 Classica in Legno (65 cm, scala da 25 9/16”) - 6 Corde in Nylon, Nero', 160.90, 'yamaha-c40blii-chitarra-classica');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (2, 'Gibson Hummingbird Studio RW Natural', 'https://m.media-amazon.com/images/I/71aadZCyTfL._AC_SL1500_.jpg', 'Chitarra acustica', 3451.53, 'gibson-hummingbird-studio-rw-natural');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (2, 'Cordoba 55 FCE Negra Ziricote', 'https://m.media-amazon.com/images/I/61Ii0s697SL._AC_SL1500_.jpg', 'Chitarra classica', 1689.99, 'cordoba-55-fce-negra-ziricote');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (3, 'Btuty Sassofono', 'https://m.media-amazon.com/images/I/61zRYliCb2L._AC_SL1500_.jpg', 'Sassofono contralto in ottone lucido inciso Eb E-Flat Natural White Shell Button Strumento a fiato con custodia Guanti muto Panno di pulizia Spazzola per cintura', 280.99, 'btuty-sassofono');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (3, 'soundman Tuyama TAS-131', 'https://m.media-amazon.com/images/I/61Gw2xJ45+L._AC_SL1500_.jpg', 'Sassofono Contralto in Mib', 336.99, 'soundman-tuyama-tas-131');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (3, 'Odyssey OAS130', 'https://m.media-amazon.com/images/I/71TJekp7IWL._AC_SL1500_.jpg', 'Kit sassofono alto, colore: Oro', 498.45, 'odyssey-oas130');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (4, 'NATAL - DNA STEALTH KIT', 'https://m.media-amazon.com/images/I/71wMe7pEZnL._AC_SL1500_.jpg', 'SET Batteria Acustica Grancassa 18" x 16", Tom 10" x 7", Timpano 14" x 12" e Rullante 13” x 5,5” con rivestimento in finitura Black Stealth Wrap', 468.00, 'natal-dna-stealth-kit');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (4, 'XDrum Semi 20', 'https://m.media-amazon.com/images/I/71x5CIMK0XL._AC_SL1500_.jpg', 'Studio Batteria Midnight Black (nera)', 369.00, 'xdrum-semi-20');
INSERT INTO strumento (tipologia_id, nome, url_foto, descrizione, prezzo, slug) VALUES (4, 'Batteria Acustica', 'https://m.media-amazon.com/images/I/618j+k5Zz8S._AC_SL1200_.jpg', 'Completa BDK-1 Rosso', 413.27, 'batteria-acustica');

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

INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (1, 1, 500.99);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (1, 2, 1000.99);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (1, 3, 400.99);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (2, 1, 550.99);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (3, 2, 600.99);
INSERT INTO fornitore_strumento(strumento_id, fornitore_id, prezzo) VALUES (3, 3, 400.99);






INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-09",3,2);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-04",1,7);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-04",2,4);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-01",5,1);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-02",1,2);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-12-03",1,12);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-05",4,8);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-07",2,11);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-07",1,3);
INSERT INTO acquisto(data_acquisto,quantity,strumento_id) VALUES ("2023-07-09",2,5);






































