/***********************************************************************
 * Module:  ArbitreDeLigne.java
 * Author:  p1806052
 * Purpose: Defines the Class ArbitreDeLigne
 ***********************************************************************/

package classesJava;

/** @pdOid 329928c7-84b3-470d-a0e4-6b218f3fa56b */
public class ArbitreDeLigne extends Arbitre {
   /** @pdRoleInfo migr=no name=MatchDouble assc=association5 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<MatchDouble> lesMatchs;
   /** @pdRoleInfo migr=no name=MatchSimple assc=association10 mult=0..* side=A */
   public MatchSimple[] matchsPartiucipes;

   public ArbitreDeLigne(int id, String nom, String pre, String nat, int type) {
      super(id, nom, pre, nat, type);
   }


   /** @pdGenerated default getter */
   public java.util.Collection<MatchDouble> getLesMatchs() {
      if (lesMatchs == null)
         lesMatchs = new java.util.HashSet<MatchDouble>();
      return lesMatchs;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesMatchs() {
      if (lesMatchs == null)
         lesMatchs = new java.util.HashSet<MatchDouble>();
      return lesMatchs.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesMatchs */
   public void setLesMatchs(java.util.Collection<MatchDouble> newLesMatchs) {
      removeAllLesMatchs();
      for (java.util.Iterator iter = newLesMatchs.iterator(); iter.hasNext();)
         addLesMatchs((MatchDouble)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMatchDouble */
   public void addLesMatchs(MatchDouble newMatchDouble) {
      if (newMatchDouble == null)
         return;
      if (this.lesMatchs == null)
         this.lesMatchs = new java.util.HashSet<MatchDouble>();
      if (!this.lesMatchs.contains(newMatchDouble))
         this.lesMatchs.add(newMatchDouble);
   }
   
   /** @pdGenerated default remove
     * @param oldMatchDouble */
   public void removeLesMatchs(MatchDouble oldMatchDouble) {
      if (oldMatchDouble == null)
         return;
      if (this.lesMatchs != null)
         if (this.lesMatchs.contains(oldMatchDouble))
            this.lesMatchs.remove(oldMatchDouble);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesMatchs() {
      if (lesMatchs != null)
         lesMatchs.clear();
   }

}