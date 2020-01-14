package classesJava;

public class Equipe {

   private int idEquipe;
   private int idJoueur1;
   private int idJoueur2;

   public int getIdJoueur1() {
      return idJoueur1;
   }

   public void setIdJoueur1(int idJoueur1) {
      this.idJoueur1 = idJoueur1;
   }

   public int getidJoueur2() {
      return idJoueur2;
   }

   public void setIdJoueur2(int idJoueur2) {
      idJoueur2 = idJoueur2;
   }

   public MatchDouble[] lesMatchs;

   public Joueur[] equipe;

   public MatchDouble[] getLesMatchs() {
      return lesMatchs;
   }

   public void setLesMatchs(MatchDouble[] lesMatchs) {
      this.lesMatchs = lesMatchs;
   }

   public Equipe(int idEquipe, int idJ1, int idJ2) {
      this.idEquipe = idEquipe;
      this.idJoueur1 = idJ1;
      this.idJoueur2 = idJ2;
   }

   public Joueur[] getEquipe() {
      return equipe;
   }

   public void setEquipe(Joueur[] equipe) {
      this.equipe = equipe;
   }

   public int getIdEquipe() {
      return idEquipe;
   }

   public void setIdEquipe(int newIdEquipe) {
      idEquipe = newIdEquipe;
   }

}