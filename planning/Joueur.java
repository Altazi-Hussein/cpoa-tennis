/***********************************************************************
 * Module:  Joueur.java
 * Author:  p1806978
 * Purpose: Defines the Class Joueur
 ***********************************************************************/

package planning;

import java.util.*;

/** @pdOid 3ed49d3a-6b2c-412f-9aed-4b0c0d28e384 */
public class Joueur {
   /** @pdOid 3843750d-766e-483e-a4e0-7290a76ff309 */
   private int idJoueur;
   /** @pdOid c9c8a5d3-bd0d-44f3-8205-c0de2e82a529 */
   private String nationaliteJoueur;
   /** @pdOid 698948d1-4eff-4071-be7f-bd8a6241cf9e */
   private String nomJoueur;
   /** @pdOid 99c98e99-78f6-4acb-a4ac-c4031052d2e1 */
   private String prenomJoueur;
   
   /** @pdRoleInfo migr=no name=MatchSimple assc=association8 mult=2 side=A */
   public MatchSimple[] lesMatchsSimplesJoues;
   /** @pdRoleInfo migr=no name=Equipe assc=association13 mult=0..1 side=A */
   public Equipe lesJoueur;
   
   /** @pdOid 69b08fd5-5b43-4e35-90f6-081480f3c4c9 */
   public int getIdJoueur() {
      return idJoueur;
   }
   
   /** @param newIdJoueur
    * @pdOid 25045318-cb11-4799-a81e-8e85a972b3b2 */
   public void setIdJoueur(int newIdJoueur) {
      idJoueur = newIdJoueur;
   }

}