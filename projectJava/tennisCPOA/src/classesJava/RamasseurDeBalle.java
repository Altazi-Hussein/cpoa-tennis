package classesJava;

public class RamasseurDeBalle {

   private int idRamasseur;

   public EquipeRamasseur ramasseurs;

   public int getIdRamasseur() {
      return idRamasseur;
   }

   public void setIdRamasseur(int newIdRamasseur) {
      idRamasseur = newIdRamasseur;
   }

   public EquipeRamasseur getRamasseurs() {
      return ramasseurs;
   }

   public RamasseurDeBalle(int idRamasseur, EquipeRamasseur ramasseurs) {
      this.idRamasseur = idRamasseur;
      this.ramasseurs = ramasseurs;
   }

   public void setRamasseurs(EquipeRamasseur newEquipeRamasseur) {
      if (this.ramasseurs == null || !this.ramasseurs.equals(newEquipeRamasseur))
      {
         if (this.ramasseurs != null)
         {
            EquipeRamasseur oldEquipeRamasseur = this.ramasseurs;
            this.ramasseurs = null;
            oldEquipeRamasseur.removeIdquipe(this);
         }
         if (newEquipeRamasseur != null)
         {
            this.ramasseurs = newEquipeRamasseur;
            this.ramasseurs.addIdquipe(this);
         }
      }
   }

}