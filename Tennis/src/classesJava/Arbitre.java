/***********************************************************************
 * Module:  Arbitre.java
 * Author:  p1806978
 * Purpose: Defines the Class Arbitre
 ***********************************************************************/

package classesJava;


public class Arbitre {

   private int idArbitre;

   private String nationalite;

   private String nom;

   private String prenom;

   private String categorie;

   public String getNationalite() {
      return nationalite;
   }

   public void setNationalite(String nationalite) {
      this.nationalite = nationalite;
   }

   public Arbitre(int id, String nom, String pre, String nat, String cat) {
      this.idArbitre = id;
      this.nationalite = nat;
      this.nom = nom;
      this .prenom = pre;
      this.categorie = cat;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public void setPrenom(String prenom) {
      this.prenom = prenom;
   }

   public String getNom() {
      return nom;
   }

   public String getPrenom() {
      return prenom;
   }

   public String getCategorie() {
      return categorie;
   }

   public void setCategorie(String categorie) {
      this.categorie = categorie;
   }

   public int getIdArbitre() {
      return idArbitre;
   }

   public void setIdArbitre(int newIdArbitre) {
      idArbitre = newIdArbitre;
   }

}