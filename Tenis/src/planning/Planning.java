/***********************************************************************
 * Module:  Planning.java
 * Author:  p1806978
 * Purpose: Defines the Class Planning
 ***********************************************************************/

package planning;

import java.util.*;

/** @pdOid 1051f860-19ac-460d-b4c5-840779dc64ae */
public class Planning {
   /** @pdOid 2797466a-cc3e-49a0-97bc-440f168005b5 */
   private int idPlanning;
   /** @pdOid 2b9a10f1-e34d-4147-afb6-b0320cdc46cb */
   private int nomPlanning;
   /** @pdOid 3028f073-2ccf-42f4-8a59-4066eda09fb7 */
   private Date dateDebut;
   /** @pdOid 6087efeb-c8cc-4bdf-a0f7-e43bf1c34474 */
   private Date dateFin;
   
   /** @pdRoleInfo migr=no name=Match assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public Collection<Match> lesMatchs;
   
   /** @pdOid bc65e574-6869-4fc5-80e7-9e1782e78d22 */
   public int getIdPlanning() {
      return idPlanning;
   }
   
   /** @param newIdPlanning
    * @pdOid 4175318c-cf07-4801-9001-e5773dc931f4 */
   public void setIdPlanning(int newIdPlanning) {
      idPlanning = newIdPlanning;
   }
   
   
   /** @pdGenerated default getter */
   public Collection<Match> getLesMatchs() {
      if (lesMatchs == null)
         lesMatchs = new HashSet<Match>();
      return lesMatchs;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorLesMatchs() {
      if (lesMatchs == null)
         lesMatchs = new HashSet<Match>();
      return lesMatchs.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesMatchs */
   public void setLesMatchs(Collection<Match> newLesMatchs) {
      removeAllLesMatchs();
      for (Iterator iter = newLesMatchs.iterator(); iter.hasNext();)
         addLesMatchs((Match)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMatch */
   public void addLesMatchs(Match newMatch) {
      if (newMatch == null)
         return;
      if (this.lesMatchs == null)
         this.lesMatchs = new HashSet<Match>();
      if (!this.lesMatchs.contains(newMatch))
         this.lesMatchs.add(newMatch);
   }
   
   /** @pdGenerated default remove
     * @param oldMatch */
   public void removeLesMatchs(Match oldMatch) {
      if (oldMatch == null)
         return;
      if (this.lesMatchs != null)
         if (this.lesMatchs.contains(oldMatch))
            this.lesMatchs.remove(oldMatch);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesMatchs() {
      if (lesMatchs != null)
         lesMatchs.clear();
   }

}