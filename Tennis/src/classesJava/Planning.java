package classesJava;

import java.util.*;

public class Planning {

   private int idPlanning;

   private int nomPlanning;

   private Date dateDebut;

   private Date dateFin;

   public java.util.Collection<Match> lesMatchs;

   public int getIdPlanning() {
      return idPlanning;
   }

   public void setIdPlanning(int newIdPlanning) {
      idPlanning = newIdPlanning;
   }

   public java.util.Collection<Match> getLesMatchs() {
      if (lesMatchs == null)
         lesMatchs = new java.util.HashSet<Match>();
      return lesMatchs;
   }

   public java.util.Iterator getIteratorLesMatchs() {
      if (lesMatchs == null)
         lesMatchs = new java.util.HashSet<Match>();
      return lesMatchs.iterator();
   }

   public void setLesMatchs(java.util.Collection<Match> newLesMatchs) {
      removeAllLesMatchs();
      for (java.util.Iterator iter = newLesMatchs.iterator(); iter.hasNext();)
         addLesMatchs((Match)iter.next());
   }

   public void addLesMatchs(Match newMatch) {
      if (newMatch == null)
         return;
      if (this.lesMatchs == null)
         this.lesMatchs = new java.util.HashSet<Match>();
      if (!this.lesMatchs.contains(newMatch))
         this.lesMatchs.add(newMatch);
   }

   public void removeLesMatchs(Match oldMatch) {
      if (oldMatch == null)
         return;
      if (this.lesMatchs != null)
         if (this.lesMatchs.contains(oldMatch))
            this.lesMatchs.remove(oldMatch);
   }

   public void removeAllLesMatchs() {
      if (lesMatchs != null)
         lesMatchs.clear();
   }

}