package classesJava;

public class EquipeRamasseur {

   private int idEquipeRamasseur;

   public java.util.Collection<RamasseurDeBalle> idquipe;

   public java.util.Collection<MatchDouble> lesMatchsDouble;

   public java.util.Collection<MatchSimple> lesMatchsSimple;

   public int getIdEquipeRamasseur() {
      return idEquipeRamasseur;
   }

   public void setIdEquipeRamasseur(int newIdEquipeRamasseur) {
      idEquipeRamasseur = newIdEquipeRamasseur;
   }

   public java.util.Collection<RamasseurDeBalle> getIdquipe() {
      if (idquipe == null)
         idquipe = new java.util.HashSet<RamasseurDeBalle>();
      return idquipe;
   }

   public java.util.Iterator getIteratorIdquipe() {
      if (idquipe == null)
         idquipe = new java.util.HashSet<RamasseurDeBalle>();
      return idquipe.iterator();
   }

   public void setIdquipe(java.util.Collection<RamasseurDeBalle> newIdquipe) {
      removeAllIdquipe();
      for (java.util.Iterator iter = newIdquipe.iterator(); iter.hasNext();)
         addIdquipe((RamasseurDeBalle)iter.next());
   }

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

   public java.util.Collection<MatchDouble> getLesMatchsDouble() {
      if (lesMatchsDouble == null)
         lesMatchsDouble = new java.util.HashSet<MatchDouble>();
      return lesMatchsDouble;
   }

   public java.util.Iterator getIteratorLesMatchsDouble() {
      if (lesMatchsDouble == null)
         lesMatchsDouble = new java.util.HashSet<MatchDouble>();
      return lesMatchsDouble.iterator();
   }

   public void setLesMatchsDouble(java.util.Collection<MatchDouble> newLesMatchsDouble) {
      removeAllLesMatchsDouble();
      for (java.util.Iterator iter = newLesMatchsDouble.iterator(); iter.hasNext();)
         addLesMatchsDouble((MatchDouble)iter.next());
   }

   public void addLesMatchsDouble(MatchDouble newMatchDouble) {
      if (newMatchDouble == null)
         return;
      if (this.lesMatchsDouble == null)
         this.lesMatchsDouble = new java.util.HashSet<MatchDouble>();
      if (!this.lesMatchsDouble.contains(newMatchDouble))
         this.lesMatchsDouble.add(newMatchDouble);
   }

   public void removeLesMatchsDouble(MatchDouble oldMatchDouble) {
      if (oldMatchDouble == null)
         return;
      if (this.lesMatchsDouble != null)
         if (this.lesMatchsDouble.contains(oldMatchDouble))
            this.lesMatchsDouble.remove(oldMatchDouble);
   }

   public void removeAllLesMatchsDouble() {
      if (lesMatchsDouble != null)
         lesMatchsDouble.clear();
   }

   public java.util.Collection<MatchSimple> getLesMatchsSimple() {
      if (lesMatchsSimple == null)
         lesMatchsSimple = new java.util.HashSet<MatchSimple>();
      return lesMatchsSimple;
   }

   public java.util.Iterator getIteratorLesMatchsSimple() {
      if (lesMatchsSimple == null)
         lesMatchsSimple = new java.util.HashSet<MatchSimple>();
      return lesMatchsSimple.iterator();
   }

   public void setLesMatchsSimple(java.util.Collection<MatchSimple> newLesMatchsSimple) {
      removeAllLesMatchsSimple();
      for (java.util.Iterator iter = newLesMatchsSimple.iterator(); iter.hasNext();)
         addLesMatchsSimple((MatchSimple)iter.next());
   }

   public void addLesMatchsSimple(MatchSimple newMatchSimple) {
      if (newMatchSimple == null)
         return;
      if (this.lesMatchsSimple == null)
         this.lesMatchsSimple = new java.util.HashSet<MatchSimple>();
      if (!this.lesMatchsSimple.contains(newMatchSimple))
         this.lesMatchsSimple.add(newMatchSimple);
   }

   public void removeLesMatchsSimple(MatchSimple oldMatchSimple) {
      if (oldMatchSimple == null)
         return;
      if (this.lesMatchsSimple != null)
         if (this.lesMatchsSimple.contains(oldMatchSimple))
            this.lesMatchsSimple.remove(oldMatchSimple);
   }

   public void removeAllLesMatchsSimple() {
      if (lesMatchsSimple != null)
         lesMatchsSimple.clear();
   }

}