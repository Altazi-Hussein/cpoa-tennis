/***********************************************************************
 * Module:  ReservationEntrainement.java
 * Author:  p1806978
 * Purpose: Defines the Class ReservationEntrainement
 ***********************************************************************/

package classesJava;

import java.util.*;

/** @pdOid dae3a5d5-4a21-456f-aa92-769f1aad9eb8 */
public class ReservationEntrainement {
   /** @pdOid adcfe246-b055-452f-bba0-34e00aab521c */
   private int idReservation;
   /** @pdOid 156e8882-d25d-4b2d-a2ab-bae0be422fe7 */
   private Date crenauEntrainement;
   
   /** @pdOid 5c3deb06-fb0f-4a5d-ae0e-185ef7f733ed */
   public int getIdReservation() {
      return idReservation;
   }
   
   /** @param newIdReservation
    * @pdOid d5262120-8b80-4c54-8869-f640995351f9 */
   public void setIdReservation(int newIdReservation) {
      idReservation = newIdReservation;
   }

}