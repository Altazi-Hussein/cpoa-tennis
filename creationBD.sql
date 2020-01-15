create or replace table Joueur(
	idJoueur int not null,
	idEquipeJ int,
	nationaliteJ varchar(254),
	nomJ varchar(254),
	prenomJ varchar(254),
	primary key (idJoueur)
);

create or replace table ArbitreDeLigne(
	idArbitreL int not null,
	nomL varchar(254),
	prenomL varchar(254),
	nationaliteL varchar(254),
	categorieL varchar(254),
	primary key (idArbitreL)
);

create or replace table ArbitreDeChaise(
	idArbitreC int not null,
	nomC varchar(254),
	prenomC varchar(254),
	nationaliteC varchar(254),
	categorieC varchar(254),
	nbMatchSimple int,
	nbMatchDouble int,
	primary key (idArbitreC)
);

create or replace table EquipeArbitreDeLigne(
	idEquipeL int,
	idArbitreL int
);

create or replace table RamasseurDeBalle(
	idRamasseur int not null,
	idEquipeR int,
	nomR varchar(254),
	prenomR varchar(254),
	primary key(idRamasseur)
);