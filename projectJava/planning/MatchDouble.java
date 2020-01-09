/***********************************************************************
 * Module:  MatchDouble.java
 * Author:  p1806978
 * Purpose: Defines the Class MatchDouble
 ***********************************************************************/

package planning;

import java.util.*;

/** @pdOid 4e0301e5-c8a6-43e2-8d83-f6ef1a29cc76 */
public class MatchDouble extends Match {
   /** @pdOid a6f31eb9-b6a2-41c7-9cb5-7839e39f4e62 */
   private int idGagnants;
   
   /** @pdRoleInfo migr=no name=Equipe assc=association14 mult=0..2 side=A */
   public Equipe[] lesEquipes;
   /** @pdRoleInfo migr=no name=ArbitreDeChaise assc=association4 mult=1 side=A */
   public ArbitreDeChaise arbitre;
   /** @pdRoleInfo migr=no name=ArbitreDeLigne assc=association5 mult=8 side=A */
   public ArbitreDeLigne[] arbitresDeLignesMD;
   /** @pdRoleInfo migr=no name=EquipeRamasseur assc=association7 mult=2 side=A */
   public EquipeRamasseur[] equipeDeRamasseur;
   
   /** @pdOid f50701f6-cf27-4cd4-bbd0-68fb4c9f7bda */
   public int getIdGagnants() {
      return idGagnants;
   }
   
   /** @param newIdGagnants
    * @pdOid dbbc7b0e-6d4b-4f11-82d4-a6727cdbf978 */
   public void setIdGagnants(int newIdGagnants) {
      idGagnants = newIdGagnants;
   }

}