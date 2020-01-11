/***********************************************************************
 * Module:  Court.java
 * Author:  p1806978
 * Purpose: Defines the Class Court
 ***********************************************************************/

package classesJava;

/** @pdOid 8005c689-eb1e-43f2-83e1-c9ee39aa2ade */
public class Court {
   /** @pdOid 33d8f327-232c-49b8-a310-d8bbfa5cca52 */
   private int idCourt;
   
   /** @pdRoleInfo migr=no name=CategorieCourt assc=association2 mult=1 */
   public CategorieCourt idCatCourt;
   
   /** @pdOid dd35d0b0-6d30-4baf-accf-84c8b8798be6 */
   public int getIdCourt() {
      return idCourt;
   }
   
   /** @param newIdCourt
    * @pdOid 0540423a-4e8d-4835-89b2-63a6e1896557 */
   public void setIdCourt(int newIdCourt) {
      idCourt = newIdCourt;
   }

}