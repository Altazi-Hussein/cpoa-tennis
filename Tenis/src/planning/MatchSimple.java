/***********************************************************************
 * Module:  MatchSimple.java
 * Author:  p1806978
 * Purpose: Defines the Class MatchSimple
 ***********************************************************************/

package planning;

import java.util.*;

/** @pdOid 0ba17612-d216-4d76-9344-9dc98e00f8a9 */
public class MatchSimple extends Match {
   /** @pdOid 0ddff6ea-7576-4d72-a68b-0f22a0b25576 */
   private int idGagnant;
   /** @pdOid a7617205-4a50-43ad-bf02-450dc5bf072e */
   private Boolean tournoi;
   
   /** @pdRoleInfo migr=no name=Joueur assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public Collection<Joueur> lesJoueurs;
   /** @pdRoleInfo migr=no name=ArbitreDeLigne assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=8 */
   public Collection<ArbitreDeLigne> arbitreDeLignesMS;
   /** @pdRoleInfo migr=no name=ArbitreDeChaise assc=association11 mult=1 */
   public ArbitreDeChaise arbitre;
   /** @pdRoleInfo migr=no name=EquipeRamasseur assc=association9 mult=2 side=A */
   public EquipeRamasseur[] equipeDeRamasseur;
   
   /** @pdOid 20eb0c27-92e0-48e4-9e01-5cdcaf000c80 */
   public int getIdGagnant() {
      return idGagnant;
   }
   
   /** @param newIdGagnant
    * @pdOid d05bf05d-5409-477c-b2ea-63057d1e59b9 */
   public void setIdGagnant(int newIdGagnant) {
      idGagnant = newIdGagnant;
   }
   
   
   /** @pdGenerated default getter */
   public Collection<Joueur> getLesJoueurs() {
      if (lesJoueurs == null)
         lesJoueurs = new HashSet<Joueur>();
      return lesJoueurs;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorLesJoueurs() {
      if (lesJoueurs == null)
         lesJoueurs = new HashSet<Joueur>();
      return lesJoueurs.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesJoueurs */
   public void setLesJoueurs(Collection<Joueur> newLesJoueurs) {
      removeAllLesJoueurs();
      for (Iterator iter = newLesJoueurs.iterator(); iter.hasNext();)
         addLesJoueurs((Joueur)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newJoueur */
   public void addLesJoueurs(Joueur newJoueur) {
      if (newJoueur == null)
         return;
      if (this.lesJoueurs == null)
         this.lesJoueurs = new HashSet<Joueur>();
      if (!this.lesJoueurs.contains(newJoueur))
         this.lesJoueurs.add(newJoueur);
   }
   
   /** @pdGenerated default remove
     * @param oldJoueur */
   public void removeLesJoueurs(Joueur oldJoueur) {
      if (oldJoueur == null)
         return;
      if (this.lesJoueurs != null)
         if (this.lesJoueurs.contains(oldJoueur))
            this.lesJoueurs.remove(oldJoueur);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesJoueurs() {
      if (lesJoueurs != null)
         lesJoueurs.clear();
   }
   /** @pdGenerated default getter */
   public Collection<ArbitreDeLigne> getArbitreDeLignesMS() {
      if (arbitreDeLignesMS == null)
         arbitreDeLignesMS = new HashSet<ArbitreDeLigne>();
      return arbitreDeLignesMS;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorArbitreDeLignesMS() {
      if (arbitreDeLignesMS == null)
         arbitreDeLignesMS = new HashSet<ArbitreDeLigne>();
      return arbitreDeLignesMS.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newArbitreDeLignesMS */
   public void setArbitreDeLignesMS(Collection<ArbitreDeLigne> newArbitreDeLignesMS) {
      removeAllArbitreDeLignesMS();
      for (Iterator iter = newArbitreDeLignesMS.iterator(); iter.hasNext();)
         addArbitreDeLignesMS((ArbitreDeLigne)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArbitreDeLigne */
   public void addArbitreDeLignesMS(ArbitreDeLigne newArbitreDeLigne) {
      if (newArbitreDeLigne == null)
         return;
      if (this.arbitreDeLignesMS == null)
         this.arbitreDeLignesMS = new HashSet<ArbitreDeLigne>();
      if (!this.arbitreDeLignesMS.contains(newArbitreDeLigne))
         this.arbitreDeLignesMS.add(newArbitreDeLigne);
   }
   
   /** @pdGenerated default remove
     * @param oldArbitreDeLigne */
   public void removeArbitreDeLignesMS(ArbitreDeLigne oldArbitreDeLigne) {
      if (oldArbitreDeLigne == null)
         return;
      if (this.arbitreDeLignesMS != null)
         if (this.arbitreDeLignesMS.contains(oldArbitreDeLigne))
            this.arbitreDeLignesMS.remove(oldArbitreDeLigne);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllArbitreDeLignesMS() {
      if (arbitreDeLignesMS != null)
         arbitreDeLignesMS.clear();
   }

}