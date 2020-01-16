package classesJava;

public class MatchDouble extends Match {

   private int idGagnants;
   
   private EquipeJoueur[] lesEquipesJoueur;

   private int idArbitreDeChaise;

   private EquipeArbitreDeLigne equipeArbitresDeLigne;

   private EquipeRamasseur equipeDeRamasseur;

    public EquipeJoueur[] getLesEquipesJoueur() {
        return lesEquipesJoueur;
    }

    public void setLesEquipesJoueur(EquipeJoueur[] lesEquipesJoueur) {
        this.lesEquipesJoueur = lesEquipesJoueur;
    }

    public int getIdArbitreDeChaise() {
        return idArbitreDeChaise;
    }

    public void setIdArbitreDeChaise(int idArbitreDeChaise) {
        this.idArbitreDeChaise = idArbitreDeChaise;
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

   public int getIdGagnants() {
      return idGagnants;
   }

   public void setIdGagnants(int newIdGagnants) {
      idGagnants = newIdGagnants;
   }

}