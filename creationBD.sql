create or replace table Joueur(
	idJoueur int not null,
	idEquipe int,
	nationaliteJoueur varchar(254),
	nomJoueur varchar(254),
	nomPrenomJoueur varchar(254),
	primary key (idJoueur)
);

create or replace table EquipeJoueur(
	idEquipe int not null,
	idJoueur1 int,
	idJoueur2,
	primary key (idEquipe)
);

create or replace table ArbitreDeLigne(
	idArbitre int not null,
	nomArbitre varchar(254),
	nomPrenomArbitre varchar(254),
	nationaliteArbitre varchar(254),
	categorieArbitre varchar(254),
	primary key (idArbitre)
);

create or replace table ArbitreDeChaise(
	idArbitre int not null,
	nomArbitre varchar(254),
	nomPrenomArbitre varchar(254),
	nationaliteArbitre varchar(254),
	categorieArbitre varchar(254),
	nbMatchSimple int,
	nbMatchDouble int,
	primary key (idArbitre)
);

create or replace table EquipeArbitreDeLigne(
	idEquipe int not null,
	primary key (idEquipe)
);