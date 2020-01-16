package classesJava;

import java.util.*;

public class ReservationEntrainement {

   private int idReservation;

   private Date dateDebutEntrainement;
   
   private Date dateFinEntrainement;
   
   private Court court;
   
   private Joueur joueur;
   
   private int idPlanning;

    public ReservationEntrainement(int idReservation, Date dateDebutEntrainement, Date dateFinEntrainement, Court court, Joueur joueur, int idPlanning) {
        this.idReservation = idReservation;
        this.dateDebutEntrainement = dateDebutEntrainement;
        this.dateFinEntrainement = dateFinEntrainement;
        this.court = court;
        this.joueur = joueur;
        this.idPlanning = idPlanning;
    }

    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public Date getDateDebutEntrainement() {
        return dateDebutEntrainement;
    }

    public void setDateDebutEntrainement(Date dateDebutEntrainement) {
        this.dateDebutEntrainement = dateDebutEntrainement;
    }

    public Date getDateFinEntrainement() {
        return dateFinEntrainement;
    }

    public void setDateFinEntrainement(Date dateFinEntrainement) {
        this.dateFinEntrainement = dateFinEntrainement;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

   public int getIdReservation() {
      return idReservation;
   }

   public void setIdReservation(int newIdReservation) {
      idReservation = newIdReservation;
   }

}