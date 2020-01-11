/***********************************************************************
 * Module:  ArbitreDeChaise.java
 * Author:  p1806978
 * Purpose: Defines the Class ArbitreDeChaise
 ***********************************************************************/

package classesJava;


public class ArbitreDeChaise extends Arbitre{

   private int nbMatchSimple;

   private int nbMatchDouble;
   

   public MatchDouble[] matchsDoubleArbitres;

   public MatchSimple[] matchsSimplesAbritres;

   public MatchDouble[] getMatchsDoubleArbitres() {
      return matchsDoubleArbitres;
   }

   public void setMatchsDoubleArbitres(MatchDouble[] matchsDoubleArbitres) {
      this.matchsDoubleArbitres = matchsDoubleArbitres;
   }

   public MatchSimple[] getMatchsSimplesAbritres() {
      return matchsSimplesAbritres;
   }

   public void setMatchsSimplesAbritres(MatchSimple[] matchsSimplesAbritres) {
      this.matchsSimplesAbritres = matchsSimplesAbritres;
   }

   public int getNbMatchDouble() {
      return nbMatchDouble;
   }

   public void setNbMatchDouble(int nbMatchDouble) {
      this.nbMatchDouble = nbMatchDouble;
   }

   public ArbitreDeChaise(int id, String nom, String pre, String nat, int type, int maS, int maD) {
      super(id, nom, pre, nat, type);
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