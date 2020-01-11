/***********************************************************************
 * Module:  Equipe.java
 * Author:  p1806978
 * Purpose: Defines the Class Equipe
 ***********************************************************************/

package classesJava;

/** @pdOid ab3bc7a2-545b-4601-a289-0b18cfbe0fa9 */
public class Equipe {
   /** @pdOid e9431fa9-c8e2-4e43-9bb7-d778922f0065 */
   private int idEquipe;
   
   /** @pdRoleInfo migr=no name=MatchDouble assc=association14 mult=0..* */
   public MatchDouble[] lesMatchs;
   /** @pdRoleInfo migr=no name=Joueur assc=association13 mult=2 */
   public Joueur[] equipe;
   
   /** @pdOid 14f44115-ca88-463b-9d78-f2f9e070b145 */
   public int getIdEquipe() {
      return idEquipe;
   }
   
   /** @param newIdEquipe
    * @pdOid 818f5409-efdc-4e96-8269-875d149fdc36 */
   public void setIdEquipe(int newIdEquipe) {
      idEquipe = newIdEquipe;
   }

}