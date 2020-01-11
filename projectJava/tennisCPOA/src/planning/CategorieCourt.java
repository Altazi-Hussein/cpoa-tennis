/***********************************************************************
 * Module:  CategorieCourt.java
 * Author:  p1806978
 * Purpose: Defines the Class CategorieCourt
 ***********************************************************************/

package planning;

import java.util.*;

/** @pdOid 8a714f22-3513-4960-9959-7a349152d7fb */
public class CategorieCourt {
   /** @pdOid 155fa7f1-d333-41d7-933e-85340d798f4e */
   private int idCategorieCourt;
   /** @pdOid 55b5584c-c5ab-4957-8882-af140f2c5ec7 */
   private String typeCourt;
   
   /** @pdRoleInfo migr=no name=Court assc=association2 mult=0..* side=A */
   public Court[] listeCourts;
   
   /** @pdOid f4e73e03-c42a-4bcf-b6ca-fa4796d9db81 */
   public int getIdCategorieCourt() {
      return idCategorieCourt;
   }
   
   /** @param newIdCategorieCourt
    * @pdOid 9cd8d46f-66b9-4fc9-9ce4-c5a5cf701095 */
   public void setIdCategorieCourt(int newIdCategorieCourt) {
      idCategorieCourt = newIdCategorieCourt;
   }

}