package classesJava;

public class MatchSimple extends Match {

   private int idGagnant;

   private Boolean tournoi;
   
   private Joueur[] lesJoueurs;

    public MatchSimple(int idGagnant, Boolean tournoi, Joueur[] lesJoueurs, ArbitreDeChaise arbitre, EquipeRamasseur[] equipeDeRamasseur) {
        this.idGagnant = idGagnant;
        this.tournoi = tournoi;
        this.lesJoueurs = lesJoueurs;
        this.arbitre = arbitre;
        this.equipeDeRamasseur = equipeDeRamasseur;
    }


    public Boolean getTournoi() {
        return tournoi;
    }

    public void setTournoi(Boolean tournoi) {
        this.tournoi = tournoi;
    }

    public ArbitreDeChaise getArbitre() {
        return arbitre;
    }

    public void setArbitre(ArbitreDeChaise arbitre) {
        this.arbitre = arbitre;
    }

    public EquipeRamasseur[] getEquipeDeRamasseur() {
        return equipeDeRamasseur;
    }

    public void setEquipeDeRamasseur(EquipeRamasseur[] equipeDeRamasseur) {
        this.equipeDeRamasseur = equipeDeRamasseur;
    }

   public ArbitreDeChaise arbitre;

   public EquipeRamasseur[] equipeDeRamasseur;

   public int getIdGagnant() {
      return idGagnant;
   }

   public void setIdGagnant(int newIdGagnant) {
      idGagnant = newIdGagnant;
   }
}