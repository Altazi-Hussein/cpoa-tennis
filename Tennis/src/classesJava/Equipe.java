package classesJava;

import java.util.ArrayList;

public class Equipe {

   private int idEquipe;
   
   private ArrayList<Joueur> lesJoueurs;

    public Equipe(int idEquipe, ArrayList<Joueur> lesJoueurs) {
        this.idEquipe = idEquipe;
        this.lesJoueurs = lesJoueurs;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public ArrayList<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    public void setLesJoueurs(ArrayList<Joueur> lesJoueurs) {
        this.lesJoueurs = lesJoueurs;
    }
   
   public int getIdJoueur1(){
       
       int idJoueur1 = lesJoueurs.get(0).getIdJoueur();
       return idJoueur1;
   }
   
      public int getIdJoueur2(){
       
       int idJoueur2 = lesJoueurs.get(1).getIdJoueur();
       return idJoueur2;
   }

}