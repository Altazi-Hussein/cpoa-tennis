package classesJava;


public class Joueur {

   private int idJoueur;

   private String nationaliteJoueur;

   private String nomJoueur;

   private String prenomJoueur;

   private int idEquipe;

   private Match lesMatchsSimplesJoues;

    public String getNationaliteJoueur() {
        return nationaliteJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Match getLesMatchsSimplesJoues() {
        return lesMatchsSimplesJoues;
    }

    public void setLesMatchsSimplesJoues(Match lesMatchsSimplesJoues) {
        this.lesMatchsSimplesJoues = lesMatchsSimplesJoues;
    }

    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public void setNationaliteJoueur(String nationaliteJoueur) {
        this.nationaliteJoueur = nationaliteJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }
   

    public Joueur(int no, int eq, String nat, String nom, String pre) {
        this.idJoueur = no;
        this.nomJoueur = nom;
        this.prenomJoueur = pre;
        this.nationaliteJoueur = nat;
        this.idEquipe = eq;
    }

   public int getIdJoueur() {
      return idJoueur;
   }

   public void setIdJoueur(int newIdJoueur) {
      idJoueur = newIdJoueur;
   }

}