package classesJava;


public class ArbitreDeLigne extends Arbitre {

   public java.util.Collection<MatchDouble> lesMatchs;

   public MatchSimple[] matchsPartiucipes;

   public ArbitreDeLigne(int id, String nom, String pre, String nat, String cat) {
      super(id, nom, pre, nat, cat);
   }



   public java.util.Collection<MatchDouble> getLesMatchs() {
      if (lesMatchs == null)
         lesMatchs = new java.util.HashSet<MatchDouble>();
      return lesMatchs;
   }


   public java.util.Iterator getIteratorLesMatchs() {
      if (lesMatchs == null)
         lesMatchs = new java.util.HashSet<MatchDouble>();
      return lesMatchs.iterator();
   }


   public void setLesMatchs(java.util.Collection<MatchDouble> newLesMatchs) {
      removeAllLesMatchs();
      for (java.util.Iterator iter = newLesMatchs.iterator(); iter.hasNext();)
         addLesMatchs((MatchDouble)iter.next());
   }


   public void addLesMatchs(MatchDouble newMatchDouble) {
      if (newMatchDouble == null)
         return;
      if (this.lesMatchs == null)
         this.lesMatchs = new java.util.HashSet<MatchDouble>();
      if (!this.lesMatchs.contains(newMatchDouble))
         this.lesMatchs.add(newMatchDouble);
   }


   public void removeLesMatchs(MatchDouble oldMatchDouble) {
      if (oldMatchDouble == null)
         return;
      if (this.lesMatchs != null)
         if (this.lesMatchs.contains(oldMatchDouble))
            this.lesMatchs.remove(oldMatchDouble);
   }


   public void removeAllLesMatchs() {
      if (lesMatchs != null)
         lesMatchs.clear();
   }

}