/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesJava;

import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class EquipeArbitreDeLigne {
    private int idEquipeAL;
    private ArrayList<ArbitreDeLigne> lesArbitresDeLigne;

    public EquipeArbitreDeLigne(int idEquipe, ArrayList<ArbitreDeLigne> lesArbitresDeLignes) {
        this.idEquipeAL = idEquipe;
        this.lesArbitresDeLigne = lesArbitresDeLignes;
    }

    
    
    public int getIdEquipeAL() {
        return idEquipeAL;
    }

    public void setIdEquipeAL(int idEquipeAL) {
        this.idEquipeAL = idEquipeAL;
    }

    public ArrayList<ArbitreDeLigne> getLesArbitresDeLigne() {
        return lesArbitresDeLigne;
    }

    public void setLesArbitresDeLigne(ArrayList<ArbitreDeLigne> lesArbitresDeLignes) {
        this.lesArbitresDeLigne = lesArbitresDeLignes;
    }
}
