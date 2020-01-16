/***********************************************************************
 * Module:  ArbitreDeChaise.java
 * Author:  p1806978
 * Purpose: Defines the Class ArbitreDeChaise
 ***********************************************************************/

package classesJava;

import java.util.ArrayList;


public class ArbitreDeChaise extends Arbitre{

   private int nbMatchSimple;

   private int nbMatchDouble;
   

   public ArrayList<MatchDouble> matchsDoubleArbitres;

   public ArrayList<MatchSimple> matchsSimplesAbritres;

   public ArrayList<MatchDouble>  getMatchsDoubleArbitres() {
      return matchsDoubleArbitres;
   }

   public void setMatchsDoubleArbitres(ArrayList<MatchDouble>  matchsDoubleArbitres) {
      this.matchsDoubleArbitres = matchsDoubleArbitres;
   }

   public ArrayList<MatchSimple> getMatchsSimplesAbritres() {
      return matchsSimplesAbritres;
   }

   public void setMatchsSimplesAbritres(ArrayList<MatchSimple> matchsSimplesAbritres) {
      this.matchsSimplesAbritres = matchsSimplesAbritres;
   }

   public int getNbMatchDouble() {
      return nbMatchDouble;
   }

   public void setNbMatchDouble(int nbMatchDouble) {
      this.nbMatchDouble = nbMatchDouble;
   }

   public ArbitreDeChaise(int id, String nom, String pre, String nat, String cat, int maS, int maD) {
      super(id, nom, pre, nat, cat);
      this.nbMatchSimple = maS;
      this.nbMatchDouble = maD;
   }

   public int getNbMatchSimple() {
      return nbMatchSimple;
   }

   public void setNbMatchSimple(int newNbMatchSimple) {
      nbMatchSimple = newNbMatchSimple;
   }

}