create or replace table Joueur(
	idJoueur int not null primary key,
	idEquipeJ int,
	nationaliteJ varchar(254),
	nomJ varchar(254),
	prenomJ varchar(254)
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
	idRamasseur int not null primary key,
	idEquipeR int,
	nomR varchar(254),
	prenomR varchar(254)
);

create or replace table Court (
	idCourt int not null primary key,
	typeCourt varchar(254) check (typeCourt in ('Annexe','Principal'))
);

create or replace table ScoreMatch(
	idScore int not null primary key,
	manche int not null,
	score1 int not null,
	score2 int not null
);

create or replace table `Match`(
	idMatch int not null primary key,
	idAChaise int,
	idEquipeAL int,
	idEquipeR int,
	dateDebutM Datetime,
	dateFinM Datetime,
	idCourt int,
	idGagnant int,
	tour int,
	idPlanning int

);

create or replace table MatchSimple(
	idMatchSimple int not null primary key,
	idJoueur1 int,
	idJoueur2 int,
	tournoi boolean
);

create or replace table MatchDouble(
	idMatchDouble int not null primary key,
	idEquipeJ1 int,
	idEquipeJ2 int
);

create or replace table ReservationEntrainement(
	idReservation int not null,
	dateDebutR Datetime,
	dateFinR Datetime,
	idCourt int not null,
	idJoueur int not null,
	idPlanning int not null,
	primary key(idCourt, idJoueur, idReservation, dateDebut)
);

create or replace table Planning(
	idPlanning int not null primary key,
	dateDebutP Datetime,
	dateFinP Datetime
);