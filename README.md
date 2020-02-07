# Projet de CPOA Tennis


## Introduction au projet

Le projet est en lien avec le module de CPOA du Semestre 3 du DUT Informatique.

Il a pour but de développer deux applications indépendantes, à savoir une en Java proposant l'administration et la gestion des matchs et plannings d'un tournoi de tennis (en l'occurrence OpenParc), et l'autre étant un site Web sous Laravel (choisi par le groupe car utilisé au préalable par Ali Hussein), gérant la billetterie des matchs pour un utilisateur souhaitant acheter des billets, et également la présence d'une interface/panel d'administration pour le gérant de ces billets afin de définir la quantité de billets, leur prix, les réductions (leur code, leur montant en %, sur quels billets ils s'appliquent, quantité disponible de codes, etc...).

## Avancement du projet PHP

Le projet Laravel est entièrement fonctionnel (gestion de la billetterie).
Possibilité d'acheter des billets pour une date de match données et un court donné (seulement s'il existe un match programmé pour ces critères-là), pour une certaine quantité.

Billets disponibles et visibles dans le panier, possibilité d'ajouter un code de réduction selon billets compatibles avec celui-ci, et d'ajouter un code licencié pour ceux qui en possède un (réduction aux participants et intervenants du tournoi).

Panel d'administration également fonctionnel dans sa totalité.

## Comment accéder et utiliser le site Web

En accord avec les contraintes liées au projet (cahier des charges et volume horaire), voici comment ce-dernier est fonctionnel dans sa version actuelle en accord avec le contenu de la base de données.

### Pour la version client / acheter des billets

Lancer le projet via git ou bien sur <a href="http://cpoag1s3.epizy.com/projectPHP/public/">ce lien</a>
(lien disponible pour une durée limitée).

```
• Aller sur la page "ACCÉDER A LA BILLETTERIE"
  
• Saisir la date du 10/01/2020 pour le Court Central pour accéder aux billets

• Possibilité d'accéder au panier et à l'espace de paiement.

• Code promotionnels disponibles (voir panel admin), édition/suppression billets également.
```
  
### Pour l'interface administrateur

Pour accéder à l'interface administrateur, aller sur /public/login
(création d'un compte sur BD locale possible sur /public/register)
ou bien sur <a href="http://cpoag1s3.epizy.com/projectPHP/public/login">ce lien</a>

```
• Si sur le lien, se connecter avec veronique.deslandres@hotmail.fr:cpoag1s3

• Accès au panel d'administration

• Création/Édition/Suppression d'un type de billet possible

• Création/Édition/Suppression d'une réduction possible.
```

Projet de CPOA Tennis centré PHP/Laravel.

Site Web entièrement réalisé par HUSSEIN Ali.
