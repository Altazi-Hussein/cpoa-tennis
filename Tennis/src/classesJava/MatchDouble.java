package classesJava;

import java.util.Date;

public class MatchDouble extends Match {
   
   private EquipeJoueur[] lesEquipesJoueur;

    public MatchDouble(EquipeJoueur[] lesEquipesJoueur, int idMatch, int idPlanning, ArbitreDeChaise arbitreDeChaise, EquipeArbitreDeLigne equipeArbitresDeLigne, EquipeRamasseur equipeDeRamasseur, Date dateDébut, Date dateFin, Court court, ScoreMatch score, int tour, int idGagnant) {
        super(idMatch, idPlanning, arbitreDeChaise, equipeArbitresDeLigne, equipeDeRamasseur, dateDébut, dateFin, court, score, tour, idGagnant);
        this.lesEquipesJoueur = lesEquipesJoueur;
    }

    public EquipeJoueur[] getLesEquipesJoueur() {
        return lesEquipesJoueur;
    }

    public void setLesEquipesJoueur(EquipeJoueur[] lesEquipesJoueur) {
        this.lesEquipesJoueur = lesEquipesJoueur;
    }

}