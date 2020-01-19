create or replace table Joueur(
	idJoueur int not null primary key,
	idEquipeJ int not null,
	nationaliteJ varchar(254) not null,
	nomJ varchar(254) not null,
	prenomJ varchar(254) not null
);

create or replace table Arbitre (
	idArbitre int not null primary key,
	nom varchar(254) not null,
	prenom varchar(254) not null,
	nationalite varchar(254) not null,
	categorie varchar(254) not null
);
insert into Arbitre values(1, "Vignat", "Jean", "Français", "Deux");

create or replace table ArbitreDeLigne (
    idArbitreL int not null primary key,
    idEquipeL int,
    foreign key (idArbitreL) references Arbitre(idArbitre)
);

create or replace table ArbitreDeChaise(
	idArbitreC int not null primary key,
	nbMatchSimple int default 0,
	nbMatchDouble int default 0,
	foreign key (idArbitreC) references Arbitre(idArbitre)
	
);

create or replace table RamasseurDeBalle(
	idRamasseur int not null primary key,
	idEquipeR int not null,
	nomR varchar(254) not null,
	prenomR varchar(254) not null
);

create or replace table Court (
	idCourt int not null primary key,
	typeCourt varchar(254) not null check (typeCourt in ('Annexe','Principal'))
);

create or replace table ScoreMatch(
	idScore int not null primary key,
	manche int not null,
	score1 int not null,
	score2 int not null
);

create or replace table `Match`(
	idMatch int not null primary key,
	idAChaise int not null,
	idEquipeAL int not null,
	idEquipeR int not null,
	dateDebutM Datetime not null,
	dateFinM Datetime not null,
	idCourt int not null,
	idGagnant int default 0,
	tour int not null,
	idPlanning int not null

);

create or replace table MatchSimple(
	idMatchSimple int not null primary key,
	idJoueur1 int not null,
	idJoueur2 int not null,
	tournoi int
);

create or replace table MatchDouble(
	idMatchDouble int not null primary key,
	idEquipeJ1 int not null,
	idEquipeJ2 int not null
);

create or replace table ReservationEntrainement(
	idReservation int not null,
	dateDebutR Datetime not null,
	dateFinR Datetime not null,
	idCourt int not null,
	idJoueur int not null,
	idPlanning int not null,
	primary key(idCourt, idJoueur, idReservation, dateDebut)
);

create or replace table Planning(
	idPlanning int not null primary key,
	dateDebutP Datetime not null,
	dateFinP Datetime not null
);