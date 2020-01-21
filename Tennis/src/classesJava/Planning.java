package classesJava;

import java.util.ArrayList;
import java.util.Date;

public class Planning {

   private int idPlanning;

   private Date dateDebut;

   private Date dateFin;
   
   private String nomPlanning;

    public Planning(int idPlanning, Date dateDebut, Date dateFin, String nomPlanning) {
        this.idPlanning = idPlanning;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nomPlanning = nomPlanning;
    }

    public Planning(Date dateDebut, Date dateFin, String nomPlanning) {
        this.idPlanning = 0;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nomPlanning = nomPlanning;
    }

    public String getNomPlanning() {
        return nomPlanning;
    }

    public void setNomPlanning(String nomPlanning) {
        this.nomPlanning = nomPlanning;
    }

    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
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
   
}