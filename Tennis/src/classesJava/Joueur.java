package classesJava;


public class Joueur {

   private int idJoueur;

   private String nationaliteJ;

   private String nomJ;

   private String prenomJ;

   private int idEquipeJ;

   private Match lesMatchsSimplesJoues;

    public String getNationaliteJ() {
        return nationaliteJ;
    }

    public String getNomJ() {
        return nomJ;
    }

    public int getIdEquipeJ() {
        return idEquipeJ;
    }

    public void setIdEquipeJ(int idEquipeJ) {
        this.idEquipeJ = idEquipeJ;
    }

    public Match getLesMatchsSimplesJoues() {
        return lesMatchsSimplesJoues;
    }

    public void setLesMatchsSimplesJoues(Match lesMatchsSimplesJoues) {
        this.lesMatchsSimplesJoues = lesMatchsSimplesJoues;
    }

    public String getPrenomJ() {
        return prenomJ;
    }

    public void setNationaliteJ(String nationaliteJ) {
        this.nationaliteJ = nationaliteJ;
    }

    public void setNomJ(String nomJ) {
        this.nomJ = nomJ;
    }

    public void setPrenomJ(String prenomJ) {
        this.prenomJ = prenomJ;
    }
   

    public Joueur(int no, int eq, String nat, String nom, String pre) {
        this.idJoueur = no;
        this.nomJ = nom;
        this.prenomJ = pre;
        this.nationaliteJ = nat;
        this.idEquipeJ = eq;
    }

   public int getIdJoueur() {
      return idJoueur;
   }

   public void setIdJoueur(int newIdJoueur) {
      idJoueur = newIdJoueur;
   }

}