/***********************************************************************
 * Module:  EquipeRamasseur.java
 * Author:  p1806978
 * Purpose: Defines the Class EquipeRamasseur
 ***********************************************************************/

package planning;

import java.util.*;

/** @pdOid 453231f2-0ab0-4f98-8763-36a820e9d0f1 */
public class EquipeRamasseur {
   /** @pdOid 592567ab-079a-47d3-aa5f-aeda34142d4c */
   private int idEquipeRamasseur;
   
   /** @pdRoleInfo migr=no name=RamasseurDeBalle assc=association6 coll=java.util.Collection impl=java.util.HashSet mult=6 type=Aggregation */
   public java.util.Collection<RamasseurDeBalle> idquipe;
   /** @pdRoleInfo migr=no name=MatchDouble assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<MatchDouble> lesMatchsDouble;
   /** @pdRoleInfo migr=no name=MatchSimple assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<MatchSimple> lesMatchsSimple;
   
   /** @pdOid d18095f3-6db2-4b50-a660-04f2f4a5fa2f */
   public int getIdEquipeRamasseur() {
      return idEquipeRamasseur;
   }
   
   /** @param newIdEquipeRamasseur
    * @pdOid 21678ed4-9e58-42af-8cfc-eaa30bb855ce */
   public void setIdEquipeRamasseur(int newIdEquipeRamasseur) {
      idEquipeRamasseur = newIdEquipeRamasseur;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<RamasseurDeBalle> getIdquipe() {
      if (idquipe == null)
         idquipe = new java.util.HashSet<RamasseurDeBalle>();
      return idquipe;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIdquipe() {
      if (idquipe == null)
         idquipe = new java.util.HashSet<RamasseurDeBalle>();
      return idquipe.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIdquipe */
   public void setIdquipe(java.util.Collection<RamasseurDeBalle> newIdquipe) {
      removeAllIdquipe();
      for (java.util.Iterator iter = newIdquipe.iterator(); iter.hasNext();)
         addIdquipe((RamasseurDeBalle)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRamasseurDeBalle */
   public void addIdquipe(RamasseurDeBalle newRamasseurDeBalle) {
      if (newRamasseurDeBalle == null)
         return;
      if (this.idquipe == null)
         this.idquipe = new java.util.HashSet<RamasseurDeBalle>();
      if (!this.idquipe.contains(newRamasseurDeBalle))
      {
         this.idquipe.add(newRamasseurDeBalle);
         newRamasseurDeBalle.setRamasseurs(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldRamasseurDeBalle */
   public void removeIdquipe(RamasseurDeBalle oldRamasseurDeBalle) {
      if (oldRamasseurDeBalle == null)
         return;
      if (this.idquipe != null)
         if (this.idquipe.contains(oldRamasseurDeBalle))
         {
            this.idquipe.remove(oldRamasseurDeBalle);
            oldRamasseurDeBalle.setRamasseurs((EquipeRamasseur)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIdquipe() {
      if (idquipe != null)
      {
         RamasseurDeBalle oldRamasseurDeBalle;
         for (java.util.Iterator iter = getIteratorIdquipe(); iter.hasNext();)
         {
            oldRamasseurDeBalle = (RamasseurDeBalle)iter.next();
            iter.remove();
            oldRamasseurDeBalle.setRamasseurs((EquipeRamasseur)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<MatchDouble> getLesMatchsDouble() {
      if (lesMatchsDouble == null)
         lesMatchsDouble = new java.util.HashSet<MatchDouble>();
      return lesMatchsDouble;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesMatchsDouble() {
      if (lesMatchsDouble == null)
         lesMatchsDouble = new java.util.HashSet<MatchDouble>();
      return lesMatchsDouble.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesMatchsDouble */
   public void setLesMatchsDouble(java.util.Collection<MatchDouble> newLesMatchsDouble) {
      removeAllLesMatchsDouble();
      for (java.util.Iterator iter = newLesMatchsDouble.iterator(); iter.hasNext();)
         addLesMatchsDouble((MatchDouble)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMatchDouble */
   public void addLesMatchsDouble(MatchDouble newMatchDouble) {
      if (newMatchDouble == null)
         return;
      if (this.lesMatchsDouble == null)
         this.lesMatchsDouble = new java.util.HashSet<MatchDouble>();
      if (!this.lesMatchsDouble.contains(newMatchDouble))
         this.lesMatchsDouble.add(newMatchDouble);
   }
   
   /** @pdGenerated default remove
     * @param oldMatchDouble */
   public void removeLesMatchsDouble(MatchDouble oldMatchDouble) {
      if (oldMatchDouble == null)
         return;
      if (this.lesMatchsDouble != null)
         if (this.lesMatchsDouble.contains(oldMatchDouble))
            this.lesMatchsDouble.remove(oldMatchDouble);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesMatchsDouble() {
      if (lesMatchsDouble != null)
         lesMatchsDouble.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<MatchSimple> getLesMatchsSimple() {
      if (lesMatchsSimple == null)
         lesMatchsSimple = new java.util.HashSet<MatchSimple>();
      return lesMatchsSimple;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesMatchsSimple() {
      if (lesMatchsSimple == null)
         lesMatchsSimple = new java.util.HashSet<MatchSimple>();
      return lesMatchsSimple.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesMatchsSimple */
   public void setLesMatchsSimple(java.util.Collection<MatchSimple> newLesMatchsSimple) {
      removeAllLesMatchsSimple();
      for (java.util.Iterator iter = newLesMatchsSimple.iterator(); iter.hasNext();)
         addLesMatchsSimple((MatchSimple)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMatchSimple */
   public void addLesMatchsSimple(MatchSimple newMatchSimple) {
      if (newMatchSimple == null)
         return;
      if (this.lesMatchsSimple == null)
         this.lesMatchsSimple = new java.util.HashSet<MatchSimple>();
      if (!this.lesMatchsSimple.contains(newMatchSimple))
         this.lesMatchsSimple.add(newMatchSimple);
   }
   
   /** @pdGenerated default remove
     * @param oldMatchSimple */
   public void removeLesMatchsSimple(MatchSimple oldMatchSimple) {
      if (oldMatchSimple == null)
         return;
      if (this.lesMatchsSimple != null)
         if (this.lesMatchsSimple.contains(oldMatchSimple))
            this.lesMatchsSimple.remove(oldMatchSimple);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesMatchsSimple() {
      if (lesMatchsSimple != null)
         lesMatchsSimple.clear();
   }

}