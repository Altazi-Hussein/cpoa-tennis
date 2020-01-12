package classesJava;

public class MatchDouble extends Match {

   private int idGagnants;

   public Equipe[] lesEquipes;

   public ArbitreDeChaise arbitre;

   public ArbitreDeLigne[] arbitresDeLignesMD;

   public EquipeRamasseur[] equipeDeRamasseur;

   public int getIdGagnants() {
      return idGagnants;
   }

   public void setIdGagnants(int newIdGagnants) {
      idGagnants = newIdGagnants;
   }

}