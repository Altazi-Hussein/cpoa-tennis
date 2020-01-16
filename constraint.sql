ALTER TABLE ArbitreDeLigne
ADD FOREIGN KEY (idArbitreL) REFERENCES Abitre(idArbitre); 

ALTER TABLE ArbitreDeChaise
ADD FOREIGN KEY (idArbitreC) REFERENCES Abitre(idArbitre); 