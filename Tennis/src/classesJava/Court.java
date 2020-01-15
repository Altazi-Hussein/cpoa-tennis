package classesJava;

public class Court {

   private int idCourt;

   public String typeCourt;

    public Court(int idCourt, String typeCourt) {
        this.idCourt = idCourt;
        this.typeCourt = typeCourt;
    }

    public String getTypeCourt() {
        return typeCourt;
    }

    public void setTypeCourt(String typeCourt) {
        this.typeCourt = typeCourt;
    }

   public int getIdCourt() {
      return idCourt;
   }

   public void setIdCourt(int newIdCourt) {
      idCourt = newIdCourt;
   }

}