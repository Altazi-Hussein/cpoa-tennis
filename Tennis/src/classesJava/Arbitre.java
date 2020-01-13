/***********************************************************************
 * Module:  Arbitre.java
 * Author:  p1806978
 * Purpose: Defines the Class Arbitre
 ***********************************************************************/

package classesJava;


public class Arbitre {

   private int idArbitre;

   private String nationaliteArbitre;

   private String nomArbitre;

   private String prenomArbitre;

   private String categorieArbitre;

   public String getNationaliteArbitre() {
      return nationaliteArbitre;
   }

   public void setNationaliteArbitre(String nationaliteArbitre) {
      this.nationaliteArbitre = nationaliteArbitre;
   }

   public Arbitre(int id, String nom, String pre, String nat, String cat) {
      this.idArbitre = id;
      this.nationaliteArbitre = nat;
      this.nomArbitre = nom;
      this .prenomArbitre = pre;
      this.categorieArbitre = cat;
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

   public String getCategorieArbitre() {
      return categorieArbitre;
   }

   public void setCategorieArbitre(String categorieArbitre) {
      this.categorieArbitre = categorieArbitre;
   }

   public int getIdArbitre() {
      return idArbitre;
   }

   public void setIdArbitre(int newIdArbitre) {
      idArbitre = newIdArbitre;
   }

}