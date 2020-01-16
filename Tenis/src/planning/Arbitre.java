package planning;

/***********************************************************************
 * Module:  Arbitre.java
 * Author:  p1806978
 * Purpose: Defines the Class Arbitre
 ***********************************************************************/

import java.util.*;

/** @pdOid b5144f7f-5066-462e-901c-6815db569d9a */
public class Arbitre {
   public String getNationaliteArbitre() {
      return nationaliteArbitre;
   }

   public void setNationaliteArbitre(String nationaliteArbitre) {
      this.nationaliteArbitre = nationaliteArbitre;
   }

   public Arbitre(int id, String nom, String pre, String nat, int type) {
      this.idArbitre = id;
      this.nationaliteArbitre = nat;
      this.nomArbitre = nom;
      this .prenomArbitre = pre;
      this.typeArbitre = type;
   }

   public void setNomArbitre(String nomArbitre) {
      this.nomArbitre = nomArbitre;
   }

   public void setPrenomArbitre(String prenomArbitre) {
      this.prenomArbitre = prenomArbitre;
   }

   public String getNomArbitre() {
      return nomArbitre;
   }

   public String getPrenomArbitre() {
      return prenomArbitre;
   }


   /** @pdOid eec9b1e0-3cdc-43ff-96f4-4cb1ece2b3a1 */
   private int idArbitre;
   /** @pdOid 6e76bdc1-0c56-43a2-b2c5-383680f2b7b5 */
   private String nationaliteArbitre;
   /** @pdOid 086bd6da-df5e-4934-b37b-07d5ab0cf7d1 */
   private String nomArbitre;
   /** @pdOid 89097b18-0e6b-4f49-94a9-683fc66c379b */
   private String prenomArbitre;

   private int typeArbitre;
   
   /** @pdOid 24188593-ef1a-426e-a310-e3745d62cb54 */
   public int getIdArbitre() {
      return idArbitre;
   }
   
   /** @param newIdArbitre
    * @pdOid 8ed586f1-43dd-4a8f-aca8-4f1df87ee68a */
   public void setIdArbitre(int newIdArbitre) {
      idArbitre = newIdArbitre;
   }

}