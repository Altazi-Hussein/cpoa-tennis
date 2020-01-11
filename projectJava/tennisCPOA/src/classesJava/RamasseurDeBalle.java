/***********************************************************************
 * Module:  RamasseurDeBalle.java
 * Author:  p1806978
 * Purpose: Defines the Class RamasseurDeBalle
 ***********************************************************************/

package classesJava;

/** @pdOid e151bc86-f9d6-4280-8764-d72f053fc307 */
public class RamasseurDeBalle {
   /** @pdOid 8709081f-8b36-47b4-b9fe-204fb05c9fa7 */
   private int idRamasseur;
   
   /** @pdRoleInfo migr=no name=EquipeRamasseur assc=association6 mult=1 side=A */
   public EquipeRamasseur ramasseurs;
   
   /** @pdOid cc56b4e8-9382-4d53-bd5f-a52a714692cb */
   public int getIdRamasseur() {
      return idRamasseur;
   }
   
   /** @param newIdRamasseur
    * @pdOid f1e0064a-e33c-45ca-9c1e-141ea839209f */
   public void setIdRamasseur(int newIdRamasseur) {
      idRamasseur = newIdRamasseur;
   }
   
   
   /** @pdGenerated default parent getter */
   public EquipeRamasseur getRamasseurs() {
      return ramasseurs;
   }
   
   /** @pdGenerated default parent setter
     * @param newEquipeRamasseur */
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