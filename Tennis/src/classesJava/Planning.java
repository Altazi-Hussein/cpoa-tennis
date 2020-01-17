package classesJava;

import java.util.ArrayList;
import java.util.Date;

public class Planning {

   private int idPlanning;

   private int nomPlanning;

   private Date dateDebut;

   private Date dateFin;

   public ArrayList<Match> lesMatchs;
   
   public ArrayList<ReservationEntrainement> lesReservations;

    public Planning(int idPlanning, int nomPlanning, Date dateDebut, Date dateFin, ArrayList<Match> lesMatchs, ArrayList<ReservationEntrainement> lesReservations) {
        this.idPlanning = idPlanning;
        this.nomPlanning = nomPlanning;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lesMatchs = lesMatchs;
        this.lesReservations = lesReservations;
    }

    public ArrayList<ReservationEntrainement> getLesReservations() {
        return lesReservations;
    }

    public void setLesReservations(ArrayList<ReservationEntrainement> lesReservations) {
        this.lesReservations = lesReservations;
    }

    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public int getNomPlanning() {
        return nomPlanning;
    }

    public void setNomPlanning(int nomPlanning) {
        this.nomPlanning = nomPlanning;
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

    public ArrayList<Match> getLesMatchs() {
        return lesMatchs;
    }

    public void setLesMatchs(ArrayList<Match> lesMatchs) {
        this.lesMatchs = lesMatchs;
    }

   
}