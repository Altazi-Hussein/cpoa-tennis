/***********************************************************************
 * Module:  ArbitreDeChaise.java
 * Author:  p1806978
 * Purpose: Defines the Class ArbitreDeChaise
 ***********************************************************************/

package planning;

import java.util.*;

/** @pdOid de260202-9142-4abc-bbb0-9c5e75f256b3 */
public class ArbitreDeChaise extends Arbitre {
   /** @pdOid f7fa9a69-4562-48ce-817e-1d725c1a8802 */
   private int nbMatchSimple;
   /** @pdOid 78cfc1ac-1649-4f96-9de7-9f24cabfb33f */
   private int nbMatchDouble;
   
   /** @pdRoleInfo migr=no name=MatchDouble assc=association4 mult=0..2 */
   public MatchDouble[] matchsDoubleArbitres;
   /** @pdRoleInfo migr=no name=MatchSimple assc=association11 mult=0..2 side=A */
   public MatchSimple[] matchsSimplesAbritres;
   
   /** @pdOid 94a8af1f-c523-428c-8c7f-fa9921c3f455 */
   public int getNbMatchSimple() {
      return nbMatchSimple;
   }
   
   /** @param newNbMatchSimple
    * @pdOid d1577057-0017-4e26-9111-56b8b122b6a8 */
   public void setNbMatchSimple(int newNbMatchSimple) {
      nbMatchSimple = newNbMatchSimple;
   }

}