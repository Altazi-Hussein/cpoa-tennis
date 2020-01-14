package classesJava;

import java.util.*;

public class ReservationEntrainement {

   private int idReservation;

   private Date crenauEntrainement;
   
   private Court court;
   
   private Joueur joueur;

   public int getIdReservation() {
      return idReservation;
   }

   public void setIdReservation(int newIdReservation) {
      idReservation = newIdReservation;
   }

}