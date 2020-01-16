create or replace table Joueur(
	idJoueur int not null,
	idEquipeJ int,
	nationaliteJ varchar(254),
	nomJ varchar(254),
	prenomJ varchar(254),
	primary key (idJoueur)
);

create or replace table Arbitre (
    idArbitre int not null primary key,
	nom varchar(254),
	prenom varchar(254),
	nationalite varchar(254),
	categorie varchar(254)    
);
insert into Arbitre values(1, "Vignat", "Jean", "Français", "Deux");

create or replace table ArbitreDeLigne (
    idArbitreL int not null primary key,
    idEquipeL int,
    foreign key (idArbitreL) references Arbitre(idArbitre)
);

create or replace table ArbitreDeChaise(
	idArbitreC int not null primary key,
	nbMatchSimple int,
	nbMatchDouble int,
	foreign key (idArbitreC) references Arbitre(idArbitre)
	
);

create or replace table RamasseurDeBalle(
	idRamasseur int not null,
	idEquipeR int,
	nomR varchar(254),
	prenomR varchar(254),
	primary key(idRamasseur)
);