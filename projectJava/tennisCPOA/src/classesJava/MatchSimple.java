package classesJava;

public class MatchSimple extends Match {

   private int idGagnant;

   private Boolean tournoi;

   public java.util.Collection<Joueur> lesJoueurs;

   public java.util.Collection<ArbitreDeLigne> arbitreDeLignesMS;

   public ArbitreDeChaise arbitre;

   public EquipeRamasseur[] equipeDeRamasseur;

   public int getIdGagnant() {
      return idGagnant;
   }

   public void setIdGagnant(int newIdGagnant) {
      idGagnant = newIdGagnant;
   }

   public java.util.Collection<Joueur> getLesJoueurs() {
      if (lesJoueurs == null)
         lesJoueurs = new java.util.HashSet<Joueur>();
      return lesJoueurs;
   }

   public java.util.Iterator getIteratorLesJoueurs() {
      if (lesJoueurs == null)
         lesJoueurs = new java.util.HashSet<Joueur>();
      return lesJoueurs.iterator();
   }

   public void setLesJoueurs(java.util.Collection<Joueur> newLesJoueurs) {
      removeAllLesJoueurs();
      for (java.util.Iterator iter = newLesJoueurs.iterator(); iter.hasNext();)
         addLesJoueurs((Joueur)iter.next());
   }

   public void addLesJoueurs(Joueur newJoueur) {
      if (newJoueur == null)
         return;
      if (this.lesJoueurs == null)
         this.lesJoueurs = new java.util.HashSet<Joueur>();
      if (!this.lesJoueurs.contains(newJoueur))
         this.lesJoueurs.add(newJoueur);
   }

   public void removeLesJoueurs(Joueur oldJoueur) {
      if (oldJoueur == null)
         return;
      if (this.lesJoueurs != null)
         if (this.lesJoueurs.contains(oldJoueur))
            this.lesJoueurs.remove(oldJoueur);
   }

   public void removeAllLesJoueurs() {
      if (lesJoueurs != null)
         lesJoueurs.clear();
   }

   public java.util.Collection<ArbitreDeLigne> getArbitreDeLignesMS() {
      if (arbitreDeLignesMS == null)
         arbitreDeLignesMS = new java.util.HashSet<ArbitreDeLigne>();
      return arbitreDeLignesMS;
   }

   public java.util.Iterator getIteratorArbitreDeLignesMS() {
      if (arbitreDeLignesMS == null)
         arbitreDeLignesMS = new java.util.HashSet<ArbitreDeLigne>();
      return arbitreDeLignesMS.iterator();
   }

   public void setArbitreDeLignesMS(java.util.Collection<ArbitreDeLigne> newArbitreDeLignesMS) {
      removeAllArbitreDeLignesMS();
      for (java.util.Iterator iter = newArbitreDeLignesMS.iterator(); iter.hasNext();)
         addArbitreDeLignesMS((ArbitreDeLigne)iter.next());
   }

   public void addArbitreDeLignesMS(ArbitreDeLigne newArbitreDeLigne) {
      if (newArbitreDeLigne == null)
         return;
      if (this.arbitreDeLignesMS == null)
         this.arbitreDeLignesMS = new java.util.HashSet<ArbitreDeLigne>();
      if (!this.arbitreDeLignesMS.contains(newArbitreDeLigne))
         this.arbitreDeLignesMS.add(newArbitreDeLigne);
   }

   public void removeArbitreDeLignesMS(ArbitreDeLigne oldArbitreDeLigne) {
      if (oldArbitreDeLigne == null)
         return;
      if (this.arbitreDeLignesMS != null)
         if (this.arbitreDeLignesMS.contains(oldArbitreDeLigne))
            this.arbitreDeLignesMS.remove(oldArbitreDeLigne);
   }

   public void removeAllArbitreDeLignesMS() {
      if (arbitreDeLignesMS != null)
         arbitreDeLignesMS.clear();
   }

}