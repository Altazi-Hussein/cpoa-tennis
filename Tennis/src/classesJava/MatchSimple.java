package classesJava;

import java.util.Date;

public class MatchSimple extends Match {

   private Boolean tournoi;
   
   private Joueur[] lesJoueurs;

    public MatchSimple(Boolean tournoi, Joueur[] lesJoueurs, int idMatch, int idPlanning, ArbitreDeChaise arbitreDeChaise, EquipeArbitreDeLigne equipeArbitresDeLigne, EquipeRamasseur equipeDeRamasseur, Date dateDébut, Date dateFin, Court court, ScoreMatch score, int idGagnant) {
        super(idMatch, idPlanning, arbitreDeChaise, equipeArbitresDeLigne, equipeDeRamasseur, dateDébut, dateFin, court, score, idGagnant);
        this.tournoi = tournoi;
        this.lesJoueurs = lesJoueurs;
    }

    public Boolean getTournoi() {
        return tournoi;
    }

    public void setTournoi(Boolean tournoi) {
        this.tournoi = tournoi;
    }

    public Joueur[] getLesJoueurs() {
        return lesJoueurs;
    }

    public void setLesJoueurs(Joueur[] lesJoueurs) {
        this.lesJoueurs = lesJoueurs;
    }
   
}