package classesJava;

import java.util.*;

public class ReservationEntrainement {

   private int idReservation;

   private Date dateDebutR;
   
   private Date dateFinR;
   
   private int idCourt;
   
   private int idJoueur;
   
   private int idPlanning;

    public ReservationEntrainement(int idReservation, Date dateDebutEntrainement, Date dateFinEntrainement, int idCourt, int idJoueur, int idPlanning) {
        this.idReservation = idReservation;
        this.dateDebutR = dateDebutEntrainement;
        this.dateFinR = dateFinEntrainement;
        this.idCourt = idCourt;
        this.idJoueur = idJoueur;
        this.idPlanning = idPlanning;
    }

    public int getIdCourt() {
        return idCourt;
    }

    public void setIdCourt(int idCourt) {
        this.idCourt = idCourt;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public Date getDateDebutR() {
        return dateDebutR;
    }

    public void setDateDebutR(Date dateDebutR) {
        this.dateDebutR = dateDebutR;
    }

    public Date getDateFinR() {
        return dateFinR;
    }

    public void setDateFinR(Date dateFinR) {
        this.dateFinR = dateFinR;
    }

   public int getIdReservation() {
      return idReservation;
   }

   public void setIdReservation(int newIdReservation) {
      idReservation = newIdReservation;
   }

}