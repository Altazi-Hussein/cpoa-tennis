package classesJava;


public class ArbitreDeLigne extends Arbitre {

    private int idEquipeL;
    
   public ArbitreDeLigne(int idArbitre, int idEquipe, String nom, String pre, String nat, String cat) {
      super(idArbitre, nom, pre, nat, cat);
      this.idEquipeL = idEquipe;
   }

    public int getIdEquipeL() {
        return idEquipeL;
    }

    public void setIdEquipeL(int idEquipeL) {
        this.idEquipeL = idEquipeL;
    }

}