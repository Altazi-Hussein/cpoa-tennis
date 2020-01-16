package classesJava;

import java.util.ArrayList;

public class EquipeRamasseur {

   private int idEquipeR;

   private ArrayList<RamasseurDeBalle> lesRamasseurs;

    public EquipeRamasseur(int idEquipeR, ArrayList<RamasseurDeBalle> lesRamasseurs) {
        this.idEquipeR = idEquipeR;
        this.lesRamasseurs = lesRamasseurs;
    }

    public void setIdEquipeR(int idEquipeR) {
        this.idEquipeR = idEquipeR;
    }

    public ArrayList<RamasseurDeBalle> getLesRamasseurs() {
        return lesRamasseurs;
    }

    public void setLesRamasseurs(ArrayList<RamasseurDeBalle> lesRamasseurs) {
        this.lesRamasseurs = lesRamasseurs;
    }
   
   public int getIdEquipeR() {
      return idEquipeR;
   }

}