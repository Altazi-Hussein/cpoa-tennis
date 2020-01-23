package classesJava;

import java.util.*;

public class Match {

   private int idMatch;
   
   private int idPlanning;
   
   private ArbitreDeChaise arbitreDeChaise;

   private EquipeArbitreDeLigne equipeArbitresDeLigne;

   private EquipeRamasseur equipeDeRamasseur;

   private Date dateDebut;
   
   private Date dateFin;
   
   private Court court;
   
   /**
    * Les lignes du tableau correspondent au différent manches, la première colonne stockera le score du Joueur ou de l'Equipe 1, et la deuxième celle de l'autre.
    */
   private ScoreMatch score;
   
   private int tour;
   
   private int idGagnant;

    public Match(int idMatch, int idPlanning, ArbitreDeChaise arbitreDeChaise, EquipeArbitreDeLigne equipeArbitresDeLigne, EquipeRamasseur equipeDeRamasseur, Date dateDébut, Date dateFin, Court court, ScoreMatch score, int tour, int idGagnant) {
        this.idMatch = idMatch;
        this.idPlanning = idPlanning;
        this.arbitreDeChaise = arbitreDeChaise;
        this.equipeArbitresDeLigne = equipeArbitresDeLigne;
        this.equipeDeRamasseur = equipeDeRamasseur;
        this.dateDebut = dateDébut;
        this.dateFin = dateFin;
        this.court = court;
        this.score = score;
        this.tour = tour;
        this.idGagnant = idGagnant;
    }

    public Match(int idPlanning, ArbitreDeChaise arbitreDeChaise, EquipeArbitreDeLigne equipeArbitresDeLigne, EquipeRamasseur equipeDeRamasseur, Date dateDebut, Date dateFin, Court court, int tour, int idGagnant) {
        this.idPlanning = idPlanning;
        this.arbitreDeChaise = arbitreDeChaise;
        this.equipeArbitresDeLigne = equipeArbitresDeLigne;
        this.equipeDeRamasseur = equipeDeRamasseur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.court = court;
        this.tour = tour;
        this.idGagnant = idGagnant;
    }
    
    

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public int getIdGagnant() {
        return idGagnant;
    }

    public void setIdGagnant(int idGagnant) {
        this.idGagnant = idGagnant;
    }

    public ArbitreDeChaise getArbitreDeChaise() {
        return arbitreDeChaise;
    }

    public void setArbitreDeChaise(ArbitreDeChaise arbitreDeChaise) {
        this.arbitreDeChaise = arbitreDeChaise;
    }

    public EquipeArbitreDeLigne getEquipeArbitresDeLigne() {
        return equipeArbitresDeLigne;
    }

    public void setEquipeArbitresDeLigne(EquipeArbitreDeLigne equipeArbitresDeLigne) {
        this.equipeArbitresDeLigne = equipeArbitresDeLigne;
    }

    public EquipeRamasseur getEquipeDeRamasseur() {
        return equipeDeRamasseur;
    }

    public void setEquipeDeRamasseur(EquipeRamasseur equipeDeRamasseur) {
        this.equipeDeRamasseur = equipeDeRamasseur;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public ScoreMatch getScore() {
        return score;
    }

    public void setScore(ScoreMatch score) {
        this.score = score;
    }

   public int getIdMatch() {
      return idMatch;
   }

   public void setIdMatch(int newIdMatch) {
      idMatch = newIdMatch;
   }

}