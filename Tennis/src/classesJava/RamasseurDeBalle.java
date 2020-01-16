package classesJava;

public class RamasseurDeBalle {

   private int idRamasseur;
   
   private String nomR;
   
   private String prenomR;

    public RamasseurDeBalle(int idRamasseur, String nomRamasseur, String prenomRamasseur) {
        this.idRamasseur = idRamasseur;
        this.nomR = nomRamasseur;
        this.prenomR = prenomRamasseur;
    }

    public int getIdRamasseur() {
        return idRamasseur;
    }

    public void setIdRamasseur(int idRamasseur) {
        this.idRamasseur = idRamasseur;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getPrenomR() {
        return prenomR;
    }

    public void setPrenomR(String prenomR) {
        this.prenomR = prenomR;
    }

}