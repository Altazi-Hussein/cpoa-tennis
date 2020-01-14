package classesJava;

import java.util.*;

public class Match {

   private int idMatch;

   private Date dateDébut;
   
   private Date dateFin;
   
   /**
    * Les lignes du tableau correspondent au différent manches, la première colonne stockera le score du Joueur ou de l'Equipe 1, et la deuxième celle de l'autre.
    */
   private ScoreMatch score;

   public int getIdMatch() {
      return idMatch;
   }

   public void setIdMatch(int newIdMatch) {
      idMatch = newIdMatch;
   }

}