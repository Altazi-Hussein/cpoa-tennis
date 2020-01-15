package classesJava;

import java.util.ArrayList;

public class EquipeJoueur {

   private int idEquipe;
   
   private ArrayList<Joueur> lesJoueurs;

    public EquipeJoueur(int idEquipe, ArrayList<Joueur> lesJoueurs) {
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
   
   public Joueur getJoueur1(){
       
       Joueur idJoueur1 = lesJoueurs.get(0);
       return idJoueur1;
   }
   
      public Joueur getJoueur2(){
       
       Joueur idJoueur2 = lesJoueurs.get(1);
       return idJoueur2;
   }

}